package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    FabricanteDAO fabricanteDAO;
    
    private List<Fabricante> fabricantes = new ArrayList<>();
    
    private Fabricante fabricanteSelecionado;
    
    @PostConstruct
    public void inicializar() {
	fabricantes = fabricanteDAO.buscarTodos();
    }
    

    public void excluir() {
	try {
	    fabricanteDAO.excluir(fabricanteSelecionado);
	    this.fabricantes.remove(fabricanteSelecionado);
	    FacesUtil.addSuccessMessage("Fabricante "+fabricanteSelecionado.getNome()+" excluido");
	} catch (NegocioException e) {
	    FacesUtil.addErrorMessage(e.getMessage());
	}
    }

    public List<Fabricante> getFabricantes() {
        return fabricantes;
    }

    public void setFabricantes(List<Fabricante> fabricantes) {
        this.fabricantes = fabricantes;
    }

    public Fabricante getFabricanteSelecionado() {
        return fabricanteSelecionado;
    }

    public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
        this.fabricanteSelecionado = fabricanteSelecionado;
    }

}
