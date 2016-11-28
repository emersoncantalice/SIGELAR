package br.edu.facisa.sigelar.bean;

public enum RegrasAcesso {

	ROLE_ADMIN("ROLE_ADMIN"), ROLE_ALM("ROLE_ALM"), ROLE_REC("ROLE_REC"), ROLE_RH("ROLE_RH"), ROLE_MED(
			"ROLE_MED"), ROLE_USER("ROLE_USER"), ROLE_GER("ROLE_GER");

	RegrasAcesso(String nome) {
		this.nome = nome;
	}

	// Attributes
	private String nome;

	// Properties
	public String getNome() {
		return nome;
	}

}
