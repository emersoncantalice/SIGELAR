package br.edu.facisa.sigelar.bean;

public enum FuncoesTrabalhistas {

	Médico("Médico"), Recepcionista("Recepcionista"), Almoxarifado("Almoxarifado"), Enfermeiro(
			"Enfermeiro"), RecursosHumanos("RecursosHumanos"), Administraçao("Administraçao");

	FuncoesTrabalhistas(String nome) {
		this.nome = nome;
	}

	// Attributes
	private String nome;

	// Properties
	public String getNome() {
		return nome;
	}

}
