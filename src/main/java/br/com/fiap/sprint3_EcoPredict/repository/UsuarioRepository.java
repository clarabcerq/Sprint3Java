package br.com.fiap.sprint3_EcoPredict.repository;

import br.com.fiap.sprint3_EcoPredict.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
