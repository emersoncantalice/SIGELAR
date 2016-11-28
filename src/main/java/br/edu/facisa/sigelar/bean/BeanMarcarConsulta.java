package br.edu.facisa.sigelar.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.facisa.sigelar.dao.ConsultaDAO;
import br.edu.facisa.sigelar.dao.FuncionarioDAO;
import br.edu.facisa.sigelar.dao.PacienteDAO;
import br.edu.facisa.sigelar.domain.Consulta;
import br.edu.facisa.sigelar.domain.Funcionario;
import br.edu.facisa.sigelar.domain.Medico;
import br.edu.facisa.sigelar.domain.Paciente;

@ManagedBean
@ViewScoped
public class BeanMarcarConsulta implements Serializable {

	private static final long serialVersionUID = 4952476482356094470L;
	private Consulta consulta;
	private Paciente paciente;
	private List<Paciente> pacientes;
	private List<Funcionario> medicos;
	private Medico medico;

	@PostConstruct
	public void init() {
		consulta = new Consulta();
		String id = BeanBoxNavigation.getInstance().getId();
		if (id != null && id != "") {
			ConsultaDAO pd = new ConsultaDAO();
			consulta = pd.buscar(Long.parseLong(id));
			paciente = consulta.getPaciente();
			medico = consulta.getMedico();
			BeanBoxNavigation.getInstance().clean();
		}

		popularPacientes();
		popularMedicos();
	}

	private void popularMedicos() {
		medicos = new ArrayList<Funcionario>();
		FuncionarioDAO md = new FuncionarioDAO();
		medicos = md.listarMedicos();

	}

	private void popularPacientes() {
		pacientes = new ArrayList<Paciente>();
		PacienteDAO pd = new PacienteDAO();
		pacientes = pd.listar();

	}

	public void salvar() {

		try {
			ConsultaDAO pd = new ConsultaDAO();
			pd.merge(consulta);
			consulta.setMedico(medico);
			consulta.setPaciente(paciente);
			Messages.addGlobalInfo("Consulta com queixa " + consulta.getQueixa() + " cadastrada com sucesso!");
			consulta = new Consulta();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao cadastrar consulta");
		}
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public List<Funcionario> getMedicos() {
		return medicos;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public void setMedicos(List<Funcionario> medicos) {
		this.medicos = medicos;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}
