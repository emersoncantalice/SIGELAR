package br.edu.facisa.sigelar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Participante extends GenericDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2361272429411761361L;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(length = 14, nullable = false)
	private String telefone;
	
	@Column(length = 15, nullable = false)
	private String celular;

	@Column(length = 30, nullable = false)
	private String email;
	
	@Column(length = 100)
	private String site;
	
	@Column(length = 100, nullable = false)
	private String areaDeInteresse;
	
	@Column(nullable = false)
	private Character estudanteFacisa;
	
	@Column(length = 30)
	private String matricula;
	
	@Column(length = 30)
	private String curso;
	
	@Column(length = 30)
	private String periodo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getAreaDeInteresse() {
		return areaDeInteresse;
	}

	public void setAreaDeInteresse(String areaDeInteresse) {
		this.areaDeInteresse = areaDeInteresse;
	}

	public Character getEstudanteFacisa() {
		return estudanteFacisa;
	}

	public void setEstudanteFacisa(Character estudanteFacisa) {
		this.estudanteFacisa = estudanteFacisa;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
}
