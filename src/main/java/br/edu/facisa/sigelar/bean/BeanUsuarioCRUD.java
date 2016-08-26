package br.edu.facisa.sigelar.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.edu.facisa.sigelar.dao.UsuarioDAO;
import br.edu.facisa.sigelar.domain.Usuario;
import br.edu.facisa.sigelar.util.EnumOperacoesCRUD;

@ManagedBean
@ViewScoped
public class BeanUsuarioCRUD implements Serializable {

	private static final long serialVersionUID = 5096136652371175046L;
	private Usuario usuario;
	private List<Usuario> participantes;
	private EnumOperacoesCRUD operacao;

	@PostConstruct
	public void init() {
		listar();
	}

//	public void instanciarNovo() {
//		
//		try {
//			
//			participante = new Participante();
//			estado = new Estado();
//			operacao = EnumOperacoesCRUD.CADASTAR;
//			
//			EstadoDAO estadoDAO = new EstadoDAO();
//			estados = estadoDAO.listar("nome");
//			
//			cidades = new ArrayList<Cidade>(); 
//			
//		} catch (Exception e) {
//			Messages.addGlobalError("Erro ao carregar a página de cadastro");
//		}
//	}
//
//	public void excluir(ActionEvent event) {
//		try {
//			participante = (Participante) event.getComponent().getAttributes().get("selecionadoCorrente");
//			PessoaDAO pessoaDAO = new PessoaDAO();
//			pessoaDAO.excluir(participante);
//			Messages.addGlobalInfo("Participante " + participante.getNome() + " excluida com sucesso!");
//			participantes = pessoaDAO.listar();
////			Collections.sort(participantes);
//		} catch (Exception e) {
//			Messages.addGlobalError("Erro ao excluir o participante");
//		}
//	}
//
//	public void editar(ActionEvent event) {
//		
//		try {
//			participante = (Participante) event.getComponent().getAttributes().get("selecionadoCorrente");
////			estado = participante.getCidade().getEstado();
//			operacao = EnumOperacoesCRUD.EDITAR;
//			
//			CidadeDAO cidadeDAO = new CidadeDAO();
//			cidades = cidadeDAO.listarPorEstado(estado.getId());
//			Collections.sort(cidades);
//			
//			EstadoDAO estadoDAO = new EstadoDAO();
//			estados = estadoDAO.listar("nome");
//		} catch (Exception e) {
//			Messages.addGlobalError("Erro ao carregar a página de cadastro");
//		}
//	}

	public void listar() {
		try {
			UsuarioDAO u = new UsuarioDAO();
			participantes = u.listar();
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao listar os participantes");
		}
	}
	
//	public void popularEstados() {
//		try {
//			if (estado != null) {
//				CidadeDAO cidadeDAO = new CidadeDAO();
//				cidades = cidadeDAO.listarPorEstado(estado.getId());
//			} else {
//				cidades = new ArrayList<Cidade>();
//			}
//		} catch (Exception e) {
//			Messages.addGlobalError("Erro ao listar os participantes");
//		}
//	}
//	
//
//	public void salvar() {
//
//		if (operacao.equals(EnumOperacoesCRUD.EDITAR)) {
//			try {
//				PessoaDAO pessoaDAO = new PessoaDAO();
//				pessoaDAO.editar(participante);
//				Messages.addGlobalInfo("Participante " + participante.getNome() + " editada com sucesso!");
//				participantes = pessoaDAO.listar();
//				Collections.sort(participantes);
//				operacao = EnumOperacoesCRUD.CADASTAR;
//			} catch (Exception e) {
//				Messages.addGlobalError("Ocorreu um erro, participante não foi editada");
//			}
//		} else {
//			try {
//				PessoaDAO pessoaDAO = new PessoaDAO();
//				pessoaDAO.salvar(participante);
//				Messages.addGlobalInfo("Participante " + participante.getNome() + " salva com sucesso!");
//				participantes = pessoaDAO.listar();
//				Collections.sort(participantes);
//				instanciarNovo();
//			} catch (Exception e) {
//				Messages.addGlobalError("Ocorreu um erro, participante não foi adicionado");
//			}
//		}
//
//	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}

	public EnumOperacoesCRUD getOperacao() {
		return operacao;
	}

	public void setOperacao(EnumOperacoesCRUD operacao) {
		this.operacao = operacao;
	}

}
