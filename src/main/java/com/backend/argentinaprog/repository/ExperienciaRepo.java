
package com.backend.argentinaprog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.argentinaprog.entity.Experiencia;
import java.util.Optional;


@Repository
public interface ExperienciaRepo extends JpaRepository<Experiencia, Integer> {
    Optional<Experiencia>findByJobPosition(String jobPosition);
    boolean existsByJobPosition(String jobPosition);
}
