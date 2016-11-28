package br.edu.facisa.sigelar.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.facisa.sigelar.dao.PacienteDAO;
import br.edu.facisa.sigelar.domain.Paciente;

@ManagedBean
@ViewScoped
public class BeanPacienteCadastrar implements Serializable{

	private static final long serialVersionUID = -333931291576546930L;
	private Paciente paciente;
	
	@PostConstruct
	public void init() {
		paciente = new Paciente();
		String id = BeanBoxNavigation.getInstance().getId();
		if (id != null && id != "") {
			PacienteDAO pd = new PacienteDAO();
			paciente = pd.buscar(id);
			BeanBoxNavigation.getInstance().clean();
		}
	}
	
	public void salvar() {

		try {
			PacienteDAO pd = new PacienteDAO();
			paciente.setHospital(VerificadorDeCadastroDeSistema.hospital);
			pd.merge(paciente);
			Messages.addGlobalInfo("Produto: " + paciente.getNome() + " cadastrado com sucesso!");
			paciente = new Paciente();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao cadastrar produto");
		}
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
}
