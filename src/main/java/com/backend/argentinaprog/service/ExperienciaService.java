
package com.backend.argentinaprog.service;

import com.backend.argentinaprog.entity.Experiencia;
import com.backend.argentinaprog.repository.ExperienciaRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienciaService {
    
    @Autowired
    ExperienciaRepo experienciaRepo;
    
    public List<Experiencia> list(){
        return experienciaRepo.findAll();
    }
    
    public Optional<Experiencia>getOne(int id){
        return experienciaRepo.findById(id);
    }
    
    public Optional<Experiencia>getByJobPosition(String jobPosition){
        return experienciaRepo.findByJobPosition(jobPosition);
    }
    
    public void save(Experiencia experiencia){
        experienciaRepo.save(experiencia);
    }
    
    public void delete(int id){
        experienciaRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return experienciaRepo.existsById(id);
    }
    
    public boolean existsByJobPosition(String jobPosition){
        return experienciaRepo.existsByJobPosition(jobPosition);
    }
}
