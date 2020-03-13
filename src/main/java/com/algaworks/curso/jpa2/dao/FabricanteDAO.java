package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FabricanteDAO implements Serializable {

    private static final long serialVersionUID = 1L;
    
   @Inject private EntityManager em;
   
    
    public void salvar(Fabricante fabricante) {
	em.getTransaction().begin();
	em.persist(fabricante);
	em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
    public List<Fabricante> buscarTodos() {
	return em.createQuery("from Fabricante").getResultList();
    }
    @Transactional
    public void excluir(Fabricante fabricante) throws NegocioException {
	fabricante = em.find(Fabricante.class, fabricante.getCodigo());
	em.remove(fabricante);
	em.flush();
	
    }

}
