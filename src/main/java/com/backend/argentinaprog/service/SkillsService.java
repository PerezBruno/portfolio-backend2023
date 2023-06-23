
package com.backend.argentinaprog.service;

import com.backend.argentinaprog.repository.SkillsRepo;
import com.backend.argentinaprog.entity.Skills;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {
    
    @Autowired
    SkillsRepo skillsRepo;
    
    public List<Skills> list(){
        return skillsRepo.findAll();
    }
    
    public Optional<Skills>getOne(int id){
        return skillsRepo.findById(id);
    }
    
    public Optional<Skills>getBySkillName(String skillName){
        return skillsRepo.findBySkillName(skillName);
    }
    
    public void save(Skills skills){
        skillsRepo.save(skills);
    }
    
    public void delete(int id){
        skillsRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return skillsRepo.existsById(id);
    }
    
    public boolean existsBySkillName(String skillName){
        return skillsRepo.existsBySkillName(skillName);
    }
            
    
}
