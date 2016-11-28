package br.edu.facisa.sigelar.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.facisa.sigelar.domain.Medico;
import br.edu.facisa.sigelar.main.HibernateUtil;

public class MedicoDAO extends GenericDAO<Medico> {

	public Medico buscarPorNome(String username) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Criteria listagem = sessao.createCriteria(Medico.class);
			listagem.add(Restrictions.like("nome", username));
			Medico medicoDB = (Medico) listagem.uniqueResult();

			return medicoDB;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}
	}


}
