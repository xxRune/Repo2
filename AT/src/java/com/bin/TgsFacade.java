/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PRECISION
 */
@Stateless
public class TgsFacade extends AbstractFacade<Tgs> {

    @PersistenceContext(unitName = "ATPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TgsFacade() {
        super(Tgs.class);
    }
    
}
