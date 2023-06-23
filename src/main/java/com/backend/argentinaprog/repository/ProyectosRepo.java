
package com.backend.argentinaprog.repository;

import com.backend.argentinaprog.entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepo extends JpaRepository<Proyectos, Integer> {
    Optional<Proyectos>findByTitle(String title);
    boolean existsByTitle(String title);
}