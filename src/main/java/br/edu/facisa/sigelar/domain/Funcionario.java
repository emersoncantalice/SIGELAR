package br.edu.facisa.sigelar.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 2361272429411761361L;

	@Column(length = 300, nullable = false)
	private String nome;

	@Column(nullable = false)
	private double salario;

	@Column(nullable = false)
	private Date admitidoEm;

	@Column(length = 300, nullable = false)
	private String carteiraTrabalho;

	@Column(length = 100)
	private String funcao;

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private Usuario Usuario;

	public String getNome() {
		return nome;
	}

	public double getSalario() {
		return salario;
	}

	public Date getAdmitidoEm() {
		return admitidoEm;
	}

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public String getFuncao() {
		return funcao;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setAdmitidoEm(Date admitidoEm) {
		this.admitidoEm = admitidoEm;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

}
