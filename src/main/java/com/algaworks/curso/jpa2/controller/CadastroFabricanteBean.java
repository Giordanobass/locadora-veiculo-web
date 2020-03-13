package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.CadastroFabricanteService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject private CadastroFabricanteService cadastroFabricanteService;
    
    private Fabricante fabricante;
    
    public void salvar() {
	try {
	    this.cadastroFabricanteService.salvar(fabricante);
	    FacesUtil.addSuccessMessage("Fabricante salvo com sucesso!");
	} catch (NegocioException e) {
	    FacesUtil.addErrorMessage(e.getMessage());
	}
	this.limpar();
    }
    
    @PostConstruct
    public void init() {
	this.limpar();
    }
    
 
    private void limpar() {
	this.fabricante = new Fabricante();
    }



    public CadastroFabricanteService getCadastroFabricanteService() {
        return cadastroFabricanteService;
    }

    public void setCadastroFabricanteService(CadastroFabricanteService cadastroFabricanteService) {
        this.cadastroFabricanteService = cadastroFabricanteService;
    }

    public Fabricante getFabricante() {
	return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
	this.fabricante = fabricante;
    }
    

}
