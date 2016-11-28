package br.edu.facisa.sigelar.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.facisa.sigelar.dao.FuncionarioDAO;
import br.edu.facisa.sigelar.dao.MedicoDAO;
import br.edu.facisa.sigelar.dao.UsuarioDAO;
import br.edu.facisa.sigelar.domain.Funcionario;
import br.edu.facisa.sigelar.domain.Medico;
import br.edu.facisa.sigelar.domain.RegraAcesso;
import br.edu.facisa.sigelar.domain.Usuario;

@ManagedBean
@ViewScoped
public class BeanFuncionarioCadastro implements Serializable {

	private static final long serialVersionUID = 4952476482356094470L;
	private Funcionario funcionario;
	private String funcao;
	private List<String> funcoes;
	private List<String> regrasAcesso;
	private Character criaUserVar;
	private Medico medico;
	private String[] regrasSelecionadas;

	@PostConstruct
	public void init() {
		funcionario = new Funcionario();
		String id = BeanBoxNavigation.getInstance().getId();
		if (id != null && id != "") {
			FuncionarioDAO pd = new FuncionarioDAO();
			funcionario = pd.buscar(Long.parseLong(id));
			UsuarioDAO ud = new UsuarioDAO();
			funcao = funcionario.getFuncao();
			Usuario user = ud.buscarPorNome(funcionario.getNome());

			if (user != null) {

				int i = 0;
				regrasSelecionadas = new String[user.getRegras().size()];
				for (RegraAcesso regra : user.getRegras()) {
					regrasSelecionadas[i] = regra.getDescricao().toString();
					i++;
				}
				funcionario.setUsuario(user);
				criaUserVar = 'S';

			} else {
				criaUserVar = 'N';
			}

			if (FuncoesTrabalhistas.Médico.getNome().equals(funcao)) {
				MedicoDAO md = new MedicoDAO();
				medico = md.buscarPorNome(user.getUsername());
			}
			BeanBoxNavigation.getInstance().clean();
		}

		populaFuncoes();
		populaRegrasAcesso();

	}

	public boolean ehMedico() {
		if (FuncoesTrabalhistas.Médico.getNome().equals(funcao)) {
			if (medico == null) {
				medico = new Medico();
			}
			return true;
		} else {
			medico = null;
			return false;
		}
	}

	public boolean criaUser() {
		boolean retorno = false;
		if (funcionario != null) {
			if (criaUserVar != null && criaUserVar == 'S') {
				if (funcionario.getUsuario() == null) {
					funcionario.setUsuario(new Usuario());
				}
				retorno = true;
			} else {
				funcionario.setUsuario(null);
				regrasSelecionadas = new String[0];
			}
		}
		return retorno;
	}

	public void populaFuncoes() {
		regrasAcesso = new ArrayList<String>();

		for (RegrasAcesso regra : RegrasAcesso.values()) {
			regrasAcesso.add(regra.getNome());
		}

	}

	public void populaRegrasAcesso() {
		funcoes = new ArrayList<String>();

		for (FuncoesTrabalhistas funcao : FuncoesTrabalhistas.values()) {
			funcoes.add(funcao.getNome());
		}

	}

	public void salvar() {

		try {
			FuncionarioDAO pd = new FuncionarioDAO();
			funcionario.setFuncao(funcao);
			funcionario.setIdHospital(VerificadorDeCadastroDeSistema.hospital.getId());
			if (funcionario.getUsuario() != null) {
				Set<RegraAcesso> regras = new HashSet<RegraAcesso>();
				for (String regra : regrasSelecionadas) {
					regras.add(new RegraAcesso(regra, funcionario.getUsuario()));
				}
				funcionario.getUsuario().setRegras(regras);
				funcionario.getUsuario().setNome(funcionario.getNome());
			}

			pd.merge(funcionario);

			Usuario user = new Usuario();
			UsuarioDAO ud = new UsuarioDAO();
			user = ud.buscarPorNome(funcionario.getNome());

			if (medico != null && medico.getCrm() != "") {
				MedicoDAO md = new MedicoDAO();
				medico.setNome(user.getUsername());
				md.salvar(medico);
			}

			Messages.addGlobalInfo("Funcionario: " + funcionario.getNome() + " cadastrado com sucesso!");
			funcionario = new Funcionario();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao cadastrar funcionario");
		}
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getFuncao() {
		return funcao;
	}

	public List<String> getFuncoes() {
		return funcoes;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public void setFuncoes(List<String> funcoes) {
		this.funcoes = funcoes;
	}

	public Character getCriaUserVar() {
		return criaUserVar;
	}

	public void setCriaUserVar(Character criaUserVar) {
		this.criaUserVar = criaUserVar;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String[] getRegrasSelecionadas() {
		return regrasSelecionadas;
	}

	public void setRegrasSelecionadas(String[] regrasSelecionadas) {
		this.regrasSelecionadas = regrasSelecionadas;
	}

	public List<String> getRegrasAcesso() {
		return regrasAcesso;
	}

	public void setRegrasAcesso(List<String> regrasAcesso) {
		this.regrasAcesso = regrasAcesso;
	}

}
