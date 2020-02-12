package br.com.geraldo.forum.config.seguranca;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.geraldo.forum.model.Usuario;
import br.com.geraldo.forum.repository.UsuarioRepository;

public class AutorizacaoViaToken extends OncePerRequestFilter{

	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;

	public AutorizacaoViaToken(TokenService tokenService, UsuarioRepository usuarioRepository) {
		
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperarToken(request);
		
		boolean valido = tokenService.isValid(token);
		
		if(valido) {
			autenticarUsuario(token);
		}
		
		filterChain.doFilter(request, response);
		
	}

	private void autenticarUsuario(String token) {
		
		Long id = tokenService.getIdBy(token);
		Usuario usuario = usuarioRepository.findById(id).get();
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String recuperarToken(HttpServletRequest request) {
		
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer "))
			return null;
		
		return token.substring(7,token.length());
	}
	
	

}
