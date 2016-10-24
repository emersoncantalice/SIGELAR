package br.edu.facisa.sigelar.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produtos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto" ,unique = true)
	private Long id;

	
	@ManyToOne
	@JoinColumn(name = "id_almoxarifado")
	private Almoxarifado almoxarifado;
	
	@Column(name ="codigo_produto", length = 20, nullable = false, unique = true)
	private String codigoProduto;
	
	@Column(name ="quantidade", nullable = false)
	private int quantidade;
	
	@Column(name ="referencia", length = 50, nullable = false, unique = true)
	private String referencia;
	
	@Column(name ="nome", length = 100, nullable = false, unique = true)
	private String nome;

	public Produtos(Almoxarifado almoxarifado, String codigoProduto, int quantidade, String referencia, String nome) {
		this.almoxarifado = almoxarifado;
		this.codigoProduto = codigoProduto;
		this.quantidade = quantidade;
		this.referencia = referencia;
		this.nome = nome;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
