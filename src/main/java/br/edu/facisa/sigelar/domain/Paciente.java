package br.edu.facisa.sigelar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Paciente extends Pessoa{
	
	private static final long serialVersionUID = -9053662281108008689L;
	
	@Column(name = "plano_de_saude", length = 15)
	private String planoDeSaude;
	
	

}
