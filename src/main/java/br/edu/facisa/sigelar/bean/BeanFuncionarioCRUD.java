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

import br.edu.facisa.sigelar.dao.FuncionarioDAO;
import br.edu.facisa.sigelar.dao.UsuarioDAO;
import br.edu.facisa.sigelar.domain.Funcionario;

@ManagedBean
@ViewScoped
public class BeanFuncionarioCRUD implements Serializable {

	private static final long serialVersionUID = 5096136652371175046L;
	private List<Funcionario> funcionarios;

	@PostConstruct
	public void init() {
		FuncionarioDAO pd = new FuncionarioDAO();
		funcionarios = pd.listar();
	}


	public void editar(ActionEvent evento) {
		try {
			Funcionario funcionario = new Funcionario();
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("selecionadoCorrente");
			Long id = funcionario.getId();
			BeanBoxNavigation box = BeanBoxNavigation.getInstance();
			box.setId(String.valueOf(id));
			Faces.redirect("./pages/funcionario/funcionarioCadastro.xhtml");
		} catch (IOException e) {
			Messages.addGlobalInfo("Erro ao tentar editar o funcionario");
		}

	}

	public void excluir(ActionEvent evento) {
		Funcionario funcionario = new Funcionario();
		try {
		funcionario = (Funcionario) evento.getComponent().getAttributes().get("selecionadoCorrente");
		UsuarioDAO ud = new UsuarioDAO();
		FuncionarioDAO pd = new FuncionarioDAO();
		ud.excluir(funcionario.getUsuario());
		pd.excluir(funcionario);
			Faces.redirect("./pages/funcionario/funcionarioCRUD.xhtml");
		} catch (IOException e) {
			Messages.addGlobalInfo("Erro ao tentar excluir o funcionario");
		}
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
