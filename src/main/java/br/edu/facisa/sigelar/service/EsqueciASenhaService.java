package br.edu.facisa.sigelar.service;

import java.io.Serializable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.edu.facisa.sigelar.dao.UsuarioDAO;
import br.edu.facisa.sigelar.domain.Usuario;

@Path("esqueci_senha")
public class EsqueciASenhaService implements Serializable {

	private static final long serialVersionUID = 8408200690871501014L;

	@GET
	@Path("{email}")
	public String sendEmail(@PathParam("email") String email) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorEmail(email);

		if (usuario != null) {
			try {
				System.out.println(usuario.getNome());
				usuario.setPassword(geraSenha());
				sendEmail(usuario);
				usuarioDAO.merge(usuario);
				return "Ok";
			} catch (EmailException e) {
				return null;
			}

		}
		return null; 
	}

	private String geraSenha() {
		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g" + "",
				"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B",
				"C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
				"X", "Y", "Z" };

		String senha = "";

		for (int x = 0; x < 6; x++) {
			int j = (int) (Math.random() * carct.length);
			senha += carct[j];
		}

		return senha;
	}

	@SuppressWarnings("deprecation")
	public void sendEmail(Usuario user) throws EmailException {

		SimpleEmail email = new SimpleEmail();
		// Utilize o hostname do seu provedor de email
		System.out.println("alterando hostname...");
		email.setHostName("smtp.gmail.com");
		// Quando a porta utilizada não é a padrão (gmail = 465)
		email.setSmtpPort(465);
		// Adicione os destinatários
		email.addTo(user.getEmail(), user.getNome());
		// Configure o seu email do qual enviará
		email.setFrom("suporte.sigelar@gmail.com", "Sistema SIGELAR");
		// Adicione um assunto
		email.setSubject("Recuperação de senha - SIGELAR - ");
		// Adicione a mensagem do email
		email.setMsg("Olá, " + user.getNome() + ".\n\nVocê solicitou reset da sua senha de usuário do sistema SIGELAR"
				+ "\n\nSua nova senha é: " + user.getPassword() + "\n\nAtenciosamente.\nEquipe SIGELAR.");
		// Para autenticar no servidor é necessário chamar os dois métodos
		// abaixo
		System.out.println("autenticando...");
		email.setSSL(true);
		email.setAuthentication("suporte.sigelar@gmail.com", "sigelar123");
		System.out.println("enviando...");
		email.send();
		System.out.println("Email enviado!");
	}

}
