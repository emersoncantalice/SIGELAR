package br.edu.facisa.sigelar.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.facisa.sigelar.bean.FuncoesTrabalhistas;
import br.edu.facisa.sigelar.domain.Funcionario;
import br.edu.facisa.sigelar.main.HibernateUtil;

public class FuncionarioDAO extends GenericDAO<Funcionario> {

	@SuppressWarnings("unchecked")
	public List<Funcionario> listarMedicos() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {

			Criteria listagem = sessao.createCriteria(Funcionario.class);
			listagem.add(Restrictions.like("funcao", FuncoesTrabalhistas.Médico.getNome()));
			List<Funcionario> medicosDB = listagem.list();

			return medicosDB;

		} catch (Exception e) {
			throw e;
		} finally {
			sessao.close();
		}
	}

}
