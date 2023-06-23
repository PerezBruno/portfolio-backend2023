
package com.backend.argentinaprog.repository;

import com.backend.argentinaprog.entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Integer> {
    Optional<Educacion>findByTitle(String title);
    boolean existsByTitle(String title);
}
