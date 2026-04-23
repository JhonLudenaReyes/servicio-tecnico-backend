package com.webservices.serviciotecnico.web.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webservices.serviciotecnico.persistence.dao.UsuarioDaoRepository;
import com.webservices.serviciotecnico.persistence.model.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioDaoRepository usuarioDaoRepository;

    public UserDetailsServiceImpl(UsuarioDaoRepository usuarioDaoRepository) {
        this.usuarioDaoRepository = usuarioDaoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDaoRepository.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new User(
                usuario.getUsuario(),
                usuario.getContrasenia(),
                usuario.getEstado().equals("A"),
                true, true, true,
                usuario.getRoles().stream()
                        .map(rol -> new SimpleGrantedAuthority("ROLE_" + rol.getRol()))
                        .collect(Collectors.toList())
        );
    }
}
