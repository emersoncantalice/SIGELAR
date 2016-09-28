package br.edu.facisa.sigelar.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

				usuarioDAO.merge(usuario);
			}
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao carregar a página inicial");
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
