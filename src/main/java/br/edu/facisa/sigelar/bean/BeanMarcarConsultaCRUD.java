package br.edu.facisa.sigelar.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.edu.facisa.sigelar.dao.ConsultaDAO;
import br.edu.facisa.sigelar.domain.Consulta;

@ManagedBean
@ViewScoped
public class BeanMarcarConsultaCRUD implements Serializable {

	private static final long serialVersionUID = 4952476482356094470L;
	private List<Consulta> consultas;

	@PostConstruct
	public void init() {
		ConsultaDAO pd = new ConsultaDAO();
		consultas = pd.listar();
	}

	public void editar(ActionEvent evento) {
		try {
			Consulta consulta = new Consulta();
			consulta = (Consulta) evento.getComponent().getAttributes().get("selecionadoCorrente");
			String idProd = consulta.getId().toString();
			BeanBoxNavigation box = BeanBoxNavigation.getInstance();
			box.setId(idProd);
			Faces.redirect("./pages/consulta/consultaCadastro.xhtml");
		} catch (IOException e) {
			Messages.addGlobalInfo("Erro ao tentar editar o consulta");
		}

	}

	public void excluir(ActionEvent evento) {
		Consulta consulta = new Consulta();
		try {
			consulta = (Consulta) evento.getComponent().getAttributes().get("selecionadoCorrente");
			ConsultaDAO pd = new ConsultaDAO();
			pd.excluir(consulta);
			Faces.redirect("./pages/consulta/consultaCRUD.xhtml");
		} catch (IOException e) {
			Messages.addGlobalInfo("Erro ao tentar excluir o consulta");
		}
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

}
