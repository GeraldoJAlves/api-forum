package br.com.geraldo.forum.config.seguranca;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.geraldo.forum.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}")
	private String expiration;

	@Value("${forum.jwt.secret}")
	private String secret;

	public String gerarToken(Authentication authenticate) {

		Usuario logado = (Usuario) authenticate.getPrincipal();

		Date hoje = new Date();
		System.out.println(expiration);
		Date expiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

		return Jwts.builder().setIssuer("Api Forum").setSubject(logado.getId().toString()).setIssuedAt(hoje)
				.setExpiration(expiracao).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public boolean isValid(String token) {

		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
	
	public Long getIdBy(String token) {
		Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return Long.parseLong(body.getSubject());
	}

}
