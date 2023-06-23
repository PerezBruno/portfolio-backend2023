
package com.backend.argentinaprog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.argentinaprog.entity.Usuario ;
import java.util.Optional;


@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {
    Optional<Usuario>findByUserName(String userName);
    boolean existsByUserName(String userName);
}
