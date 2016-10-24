package br.edu.facisa.sigelar.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "prescricoes_medicas")
public class PrescricaoMedica implements Serializable{

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_prescricao" ,unique = true)
	private Long id;
	
	@Column(name ="prescricao", length = 200)
	private String prescricao;
	
	@Column(name ="data_emicao")
	@Temporal(TemporalType.DATE)
	private Calendar dataEmisao; 
	
	@Column(name ="data_validade")
	@Temporal(TemporalType.DATE)
	private Calendar dataValidade;
	
	@Column(name ="dosagem", length = 50)
	private String dosagem;
	
	@Column(name ="quantidade", length = 4)
	private String quantidade;

	public String getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}

	public Calendar getDataEmisao() {
		return dataEmisao;
	}

	public void setDataEmisao(Calendar dataEmisao) {
		this.dataEmisao = dataEmisao;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	
}
