package br.edu.facisa.sigelar.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Funcionario extends Pessoa{

	private static final long serialVersionUID = 2361272429411761361L;


	@Column(length = 300, nullable = false)
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true )
	@PrimaryKeyJoinColumn
	private Usuario Usuario;
	
	@Column(length = 100)
	private String funcao;

	@Column(length = 32, nullable = false)
	private String username;

	@Column(length = 32, nullable = false)
	private String password;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimoAcesso;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAcessoAtual;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataUltimaAlteracao;

	@Column(length = 32, nullable = false)
	private String role;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
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

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}


}
