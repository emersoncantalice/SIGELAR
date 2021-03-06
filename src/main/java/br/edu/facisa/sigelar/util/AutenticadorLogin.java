package br.edu.facisa.sigelar.util;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.facisa.sigelar.dao.UsuarioDAO;
import br.edu.facisa.sigelar.domain.RegraAcesso;
import br.edu.facisa.sigelar.domain.Usuario;

@Named
public class AutenticadorLogin implements AuthenticationProvider {

	UsuarioDAO usuarioDAO;

	public AutenticadorLogin() {
		super();
		usuarioDAO = new UsuarioDAO();
	}

	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		Usuario user = this.usuarioDAO.buscaPorLoginESenha(username, password);

		if (user != null) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			
			for (RegraAcesso userRole : user.getRegras()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getDescricao()));
			}
			
			UserDetails userDetails = new User(username, password, grantedAuthorities);
			
			return new UsernamePasswordAuthenticationToken(userDetails, password, grantedAuthorities);
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(final Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
