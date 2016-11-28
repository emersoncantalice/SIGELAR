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

import br.edu.facisa.sigelar.dao.PacienteDAO;
import br.edu.facisa.sigelar.domain.Paciente;

@ManagedBean
@ViewScoped
public class BeanPacienteCRUD implements Serializable {

	private static final long serialVersionUID = 617198227218687730L;

	private List<Paciente> pacientes;

	@PostConstruct
	public void init() {
		PacienteDAO pd = new PacienteDAO();
		pacientes = pd.listar();
	}

	public void editar(ActionEvent evento) {
		try {
			Paciente paciente = new Paciente();
			paciente = (Paciente) evento.getComponent().getAttributes().get("selecionadoCorrente");
			String idPac = paciente.getCpf();
			BeanBoxNavigation box = BeanBoxNavigation.getInstance();
			box.setId(idPac);
			Faces.redirect("./pages/paciente/pacienteCadastro.xhtml");
		} catch (IOException e) {
			Messages.addGlobalInfo("Erro ao tentar editar o produto");
		}

	}

	public void excluir(ActionEvent evento) {
		Paciente paciente = new Paciente();
		try {
			paciente = (Paciente) evento.getComponent().getAttributes().get("selecionadoCorrente");
			PacienteDAO pd = new PacienteDAO();
			pd.excluir(paciente);
			Faces.redirect("./pages/paciente/pacienteCRUD.xhtml");
			Messages.addGlobalInfo("Paciente: " + paciente.getNome() + " excluido com sucesso!");
		} catch (IOException e) {
			Messages.addGlobalInfo("Erro ao tentar excluir o produto");
		}
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
