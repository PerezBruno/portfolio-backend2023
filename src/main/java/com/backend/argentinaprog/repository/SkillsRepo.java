
package com.backend.argentinaprog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.argentinaprog.entity.Skills;
import java.util.Optional;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillsRepo extends JpaRepository<Skills, Integer> {
    Optional<Skills>findBySkillName(String skillName);
    boolean existsBySkillName(String skillName);
}
