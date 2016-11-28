package br.edu.facisa.sigelar.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.edu.facisa.sigelar.domain.Paciente;
import br.edu.facisa.sigelar.main.HibernateUtil;

public class PacienteDAO extends GenericDAO<Paciente> {
	
	public Paciente buscar(String codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Criteria listagem = sessao.createCriteria(Paciente.class);
			listagem.add(Restrictions.like("cpf", codigo));
			Paciente paciente = (Paciente) listagem.uniqueResult();

			return paciente;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}

	}
	
	public void merge(Paciente paciente) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.merge(paciente);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			sessao.close();
		}
	}


}
