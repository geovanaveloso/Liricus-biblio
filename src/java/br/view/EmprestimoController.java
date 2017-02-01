package br.view;

import br.controller.AcervoFacade;
import br.model.Emprestimo;
import br.view.util.JsfUtil;
import br.view.util.PaginationHelper;
import br.controller.EmprestimoFacade;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@ManagedBean(name = "emprestimoController")
@SessionScoped
public class EmprestimoController implements Serializable {

    private Emprestimo current;
    private DataModel items = null;
    @EJB
    private br.controller.EmprestimoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public EmprestimoController() {
    }

    public Emprestimo getSelected() {
        if (current == null) {
            current = new Emprestimo();
            selectedItemIndex = -1;
        }
        return current;
    }

    private EmprestimoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Emprestimo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
                                
        current = new Emprestimo();
        
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            System.out.println(current.getIdAcervo().getTitulo());
            System.out.println(current.getIdAcervo().getSituacao());
            
            current.getIdAcervo().setSituacao("emprestado");
            AcervoController acontrol = new AcervoController();
            acontrol.update(current.getIdAcervo());
            
            getFacade().create(current);
            
            System.out.println(current.getIdAcervo().getTitulo());
            System.out.println(current.getIdAcervo().getSituacao());

            //ejbAcervoFacade.edit(current.getIdAcervo());
            
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmprestimoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Emprestimo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmprestimoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Emprestimo) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmprestimoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Date getDateNow() {
        Date date;
        Calendar cal = Calendar.getInstance();
        date = cal.getTime();
        
        current.setDataEmprestimo(date);
        return date;
    }

    public Date getDateDevolucao() {
        Date date;
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        date = cal.getTime();
        
        current.setDevolucaoPrevista(date);
        return date;
    }

    @FacesConverter(forClass = Emprestimo.class)
    public static class EmprestimoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            EmprestimoController controller = (EmprestimoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "emprestimoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Emprestimo) {
                Emprestimo o = (Emprestimo) object;
                return getStringKey(o.getIdEmprestimo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Emprestimo.class.getName());
            }
        }
    }
}
