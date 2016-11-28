package br.edu.facisa.sigelar.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "solicitacoes")
public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "quantidade", nullable = false)
	private int quantidade;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "produto", length = 100, nullable = false)
	private String produto;

	@Column(name = "solicitante", length = 100, nullable = false)
	private String solicitante;

	public Solicitacao() {
	}

	public int getQuantidade() {
		return quantidade;
	}

	public String getNome() {
		return nome;
	}

	public String getProduto() {
		return produto;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

}
