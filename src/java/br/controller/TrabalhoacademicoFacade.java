/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.model.Trabalhoacademico;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author elias
 */
@Stateless
public class TrabalhoacademicoFacade extends AbstractFacade<Trabalhoacademico> {
    @PersistenceContext(unitName = "liricusBiblio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabalhoacademicoFacade() {
        super(Trabalhoacademico.class);
    }
    
}
