package br.com.teste.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import br.com.teste.dao.FuncionarioDAO;
import br.com.teste.entity.Funcionario;

@ManagedBean
@SessionScoped
public class FuncionarioBean {
	
	
	/* aqui é o gerenciador, onde vc pode gerenciar os metodos delete,save etc*/
	private Funcionario funcionario;
	private FuncionarioDAO DAO;
	private List<Funcionario> FuncionarioLista;
	
	@PostConstruct
	public void init() {
		this.funcionario = new Funcionario();
		this.DAO = new FuncionarioDAO();
		this.FuncionarioLista = DAO.list();
		
		
	}
	
	public String newFuncionario() {
		return "manageFuncionario";
	}
	
	
	
	public String delete(Funcionario funcionario) {
		DAO.Delete_dados(funcionario);
		return "funcionario";
	}
	
	public String editar(Funcionario funcionario) {
		this.funcionario = funcionario;
		return "manageFuncionario";
	}
	
	
	public String save() {
		DAO.Save_Update(funcionario);
		this.funcionario = new Funcionario();
		return "funcionario";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public FuncionarioDAO getDAO() {
		return DAO;
	}

	public void setDAO(FuncionarioDAO dAO) {
		DAO = dAO;
	}

	public List<Funcionario> getFuncionarioLista() {
		return FuncionarioLista;
	}

	public void setFuncionarioLista(List<Funcionario> funcionarioLista) {
		FuncionarioLista = funcionarioLista;
	}
	
	
	

}
