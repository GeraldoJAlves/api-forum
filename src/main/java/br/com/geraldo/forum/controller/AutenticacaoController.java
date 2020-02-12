package br.com.geraldo.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geraldo.forum.config.seguranca.TokenService;
import br.com.geraldo.forum.controller.dto.TokenDto;
import br.com.geraldo.forum.controller.form.UsuarioForm;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid UsuarioForm form){
		
		try {
			
			Authentication authenticate = authenticationManager.authenticate(form.converter());
			String token = tokenService.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token, "Bearer"));
		}catch (AuthenticationException e) {
			
			return ResponseEntity.badRequest().build();
		}
	}
}
