package br.edu.facisa.sigelar.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospitais")
public class Hospital implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_hospital" ,unique = true)
	private Long id;


	@Column(name ="nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name ="cnh", length = 15, nullable = false)
	private String cnh;
	
	@Column(name ="bairo", length = 100, nullable = false)
	private String bairro;
	
	@Column(name ="cidade", length = 100, nullable = false)
	private String cidade;
	
	@Column(name ="rua", length = 100, nullable = false)
	private String rua;
	
	@Column(name ="numero", length = 5, nullable = false)
	private String numero;
	
	@Column(name ="cep", length = 15, nullable = false)
	private String cep;
	
	public Hospital(String nome, String cnh, String bairro, String cidade, String rua, String numero, String cep) {
		this.nome = nome;
		this.cnh = cnh;
		this.bairro = bairro;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
