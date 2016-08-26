package br.edu.facisa.sigelar.util;

import org.hibernate.Session;
import org.junit.Test;

import br.edu.facisa.sigelar.main.HibernateUtil;

public class HibernateUtilTest {

	@Test
	public void conectar() {
		Session connect = HibernateUtil.getFabricaDeSessoes().openSession();
		connect.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}

}
