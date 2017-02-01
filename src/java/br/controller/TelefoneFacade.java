/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.model.Telefone;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author elias
 */
@Stateless
public class TelefoneFacade extends AbstractFacade<Telefone> {
    @PersistenceContext(unitName = "liricusBiblio")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefoneFacade() {
        super(Telefone.class);
    }
    
}
