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
@Table(name = "almoxarifado")
public class Almoxarifado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_almoxarifado", unique = true)
	private Long id;
	
	
	@OneToMany(mappedBy = "almoxarifado")
	private List<Produtos> produtos;
	
	
}
