package br.edu.facisa.sigelar.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("Restful")
public class SigelarResourceConfig extends ResourceConfig {
	
	public SigelarResourceConfig() {
		packages("br.edu.facisa.sigelar.service");
	}
	

}
