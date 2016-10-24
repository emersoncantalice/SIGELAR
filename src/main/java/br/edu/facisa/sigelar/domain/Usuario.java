package br.edu.facisa.sigelar.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario extends GenericDomain {

	private static final long serialVersionUID = 201404140102L;

	
	@Column(length = 300, nullable = false)
	private String nome;

	@Column(length = 32, nullable = false, unique = true)
	private String username;

	@Column(length = 32, nullable = false)
	private String password;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimoAcesso;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAcessoAtual;

	@Column(length = 50, nullable = false)
	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "usuario")
	private Set<RegraAcesso> regras;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public Date getDataAcessoAtual() {
		return dataAcessoAtual;
	}

	public void setDataAcessoAtual(Date dataAcessoAtual) {
		this.dataAcessoAtual = dataAcessoAtual;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<RegraAcesso> getRegras() {
		return regras;
	}

	public void setRegras(Set<RegraAcesso> regras) {
		this.regras = regras;
	}

}
