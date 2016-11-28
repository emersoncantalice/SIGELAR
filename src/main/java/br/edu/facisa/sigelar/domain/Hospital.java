package br.edu.facisa.sigelar.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hospitais")
public class Hospital implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_hospital", unique = true)
	private Long id;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "nome_fantasia", length = 100, nullable = false)
	private String nomeFantasia;

	@Column(name = "cnpj", length = 20, nullable = false)
	private String cnpj;

	@Column(name = "inscricao_estadual", length = 15, nullable = false)
	private String inscricaoEstadual;

	@Column(name = "bairo", length = 100, nullable = false)
	private String bairro;

	@Column(name = "estado", length = 100, nullable = false)
	private String estado;

	@Column(name = "cidade", length = 100, nullable = false)
	private String cidade;

	@Column(name = "rua", length = 100, nullable = false)
	private String rua;

	@Column(name = "numero", length = 10, nullable = false)
	private String numero;

	@Column(name = "complemento", length = 50)
	private String complemento;

	@Column(name = "cep", length = 15, nullable = false)
	private String cep;

	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;

	@Column(name = "site", length = 150, nullable = false)
	private String site;
	
	@OneToMany(mappedBy = "hospital")
	private List<Pessoa> pessoas;

	public Hospital() {
	}

	public Hospital(String nome, String nomeFantasia, String cnpj, String inscricaoEstadual, String bairro,
			String cidade, String rua, String numero, String cep, String telefone, String site) {
		super();
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.bairro = bairro;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.telefone = telefone;
		this.site = site;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSite() {
		return site;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
