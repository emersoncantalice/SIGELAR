package br.edu.facisa.sigelar.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.edu.facisa.sigelar.domain.Funcionario;
import br.edu.facisa.sigelar.main.HibernateUtil;

public class MedicoDAO extends GenericDAO<Funcionario> {

	public Funcionario findByUsernameAndPassword(String nome, String senha) {
		Funcionario user = buscar(nome, senha);
		return user;
	}

	public Funcionario buscar(String usuario, String senha) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria listagem = sessao.createCriteria(Funcionario.class);
			listagem.add(Restrictions.like("username", usuario));
			Funcionario usuarioDB = (Funcionario) listagem.uniqueResult();

			if (usuarioDB != null) {
				if (usuarioDB.getPassword().equals(senha)) {
					return usuarioDB;
				} else {
					usuarioDB = null;
				}
			}
			return usuarioDB;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}
	}

	public Funcionario buscarPorUsername(String usuario) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Criteria listagem = sessao.createCriteria(Funcionario.class);
			listagem.add(Restrictions.like("username", usuario));
			Funcionario funcionarioDB = (Funcionario) listagem.uniqueResult();

			return funcionarioDB;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}
	}

	public void salvarUltimoAcesso(String data) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(data);
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
