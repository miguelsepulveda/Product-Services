package cl.aligare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aligare.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}
