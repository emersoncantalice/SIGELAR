package br.edu.facisa.sigelar.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "consultas")
public class Consulta implements Serializable {

	private static final long serialVersionUID = -2703182422227301857L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_consulta")
	private Long id;

	@Column(name = "data_consulta", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataConsulta;

	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private Medico medico;

	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private Paciente paciente;

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	@PrimaryKeyJoinColumn
	private PrescricaoMedica prescricao;

	@Column(nullable = true)
	private String sala;

	@Column(nullable = true)
	private String local;

	@Column(nullable = false)
	private String queixa;

	public Long getId() {
		return id;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public Medico getMedico() {
		return medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public PrescricaoMedica getPrescricao() {
		return prescricao;
	}

	public String getSala() {
		return sala;
	}

	public String getLocal() {
		return local;
	}

	public String getQueixa() {
		return queixa;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setPrescricao(PrescricaoMedica prescricao) {
		this.prescricao = prescricao;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setQueixa(String queixa) {
		this.queixa = queixa;
	}

}
