package br.com.teste.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable{
	
	
	/**
	 *   aqui cria as variaveis de nome,datadenascimento,cpf etc e também cria seus get e setters para definir e retornar.
	 *   as anotações servem para definir algo que vai ser no banco de dados.
	 */
	private static final long serialVersionUID = 1L;

	@Id // seta id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	@Column(name="nome")
	//@Inject
	private String nome;
	
	@NotEmpty
	@Column(name="CPF")
	//@Inject
	private String CPF;
	
	@NotNull
	@Column(name="salario")
	//@Inject
	private Double salario;
	
	@Past
	@Column(name="dataNascimento")
	private LocalDate dataNascimento;
	
	public Funcionario(int id, String nome, LocalDate dataNascimento, String CPF, Double salario) {
		
		this.id = id;
		this.nome = nome;
		//this.dataNascimento = dataNascimento;
		this.CPF = CPF;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
		
	}

	public Funcionario() {
		// TODO Auto-generated constructor stub
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
/*
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}*/

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	

}
