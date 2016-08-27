package br.edu.facisa.sigelar.bean;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.edu.facisa.sigelar.dao.UsuarioDAO;
import br.edu.facisa.sigelar.domain.Usuario;

@ManagedBean
@SessionScoped
public class BeanMenuPrincipal implements Serializable {

	private static final long serialVersionUID = 5140878195944068208L;

	private String nomeUsuario;
	private String ultimoAcesso;
	private String hostname;
	private String ip;
	private int idPage;
	private Usuario usuario;

	@PostConstruct
	public void carregaInformacoesBasicas() {

		try {
			if (nomeUsuario == null || nomeUsuario.isEmpty()) {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuario = new Usuario();
				User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				String name = user.getUsername();
				usuario = usuarioDAO.buscarPorUsername(name);
				usuario.setDataUltimoAcesso(usuario.getDataAcessoAtual());
				usuario.setDataAcessoAtual(new Date());
				SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

				ultimoAcesso = formata.format(usuario.getDataUltimoAcesso());
				nomeUsuario = usuario.getNome().substring(0, usuario.getNome().indexOf(" "));

				InetAddress addr = null;
				addr = InetAddress.getLocalHost();

				hostname = addr.getHostName();
				ip = addr.getHostAddress();
				usuarioDAO.merge(usuario);
			}
		} catch (UnknownHostException e) {
			Messages.addGlobalError("Erro ao carregar a página inicial");
		}
	}
	
	public void searchPage() throws IOException {
		switch (idPage) {
		// Teste merge eclipse
		case 1:
			Faces.redirect("pages/funcionario/ParticipanteCRUD.xhtml");
			break;
		case 2:
			Faces.redirect("dashboard/DashBoard.xhtml");
			break;
		default:
			Messages.addGlobalError("Página não encontrada");
		}
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getUltimoAcesso() {
		return ultimoAcesso;
	}

	public void setUltimoAcesso(String ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getIdPage() {
		return idPage;
	}

	public void setIdPage(int idPage) {
		this.idPage = idPage;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
