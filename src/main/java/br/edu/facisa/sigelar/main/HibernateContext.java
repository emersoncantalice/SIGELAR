package br.edu.facisa.sigelar.main;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getFabricaDeSessoes();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
