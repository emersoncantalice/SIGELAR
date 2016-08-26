package br.edu.facisa.sigelar.util;

public enum EnumCursos {
	SI("Sistemas de Informação"), J("Jogos Digitais"), M("Medicina"),
	A("Administração"), F("Fisioterapia");
    
	EnumCursos(String nome){
        this.nome = nome;
    }
    
    //Attributes
    private String nome;
    
 
    //Properties
    public String getNome(){
        return nome;
    }

}
