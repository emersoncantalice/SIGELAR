package br.edu.facisa.sigelar.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.edu.facisa.sigelar.domain.Usuario;
import br.edu.facisa.sigelar.main.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario buscaPorLoginESenha(String nome, String senha) {
		Usuario user = buscar(nome, senha);
		return user;
	}

	public Usuario buscar(String usuario, String senha) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria listagem = sessao.createCriteria(Usuario.class);
			listagem.add(Restrictions.like("username", usuario));
			Usuario usuarioDB = (Usuario) listagem.uniqueResult();

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

	public Usuario buscarPorUsername(String usuario) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Criteria listagem = sessao.createCriteria(Usuario.class);
			listagem.add(Restrictions.like("username", usuario));
			Usuario usuarioDB = (Usuario) listagem.uniqueResult();

			return usuarioDB;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	
	public Usuario buscarPorNome(String usuario) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Criteria listagem = sessao.createCriteria(Usuario.class);
			listagem.add(Restrictions.like("nome", usuario));
			Usuario usuarioDB = (Usuario) listagem.uniqueResult();

			return usuarioDB;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}
	}
	
	public Usuario buscarPorEmail(String email) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Criteria listagem = sessao.createCriteria(Usuario.class);
			listagem.add(Restrictions.like("email", email));
			Usuario usuarioDB = (Usuario) listagem.uniqueResult();

			return usuarioDB;

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
