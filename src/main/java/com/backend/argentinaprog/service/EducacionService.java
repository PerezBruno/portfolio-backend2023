
package com.backend.argentinaprog.service;

import com.backend.argentinaprog.entity.Educacion;
import com.backend.argentinaprog.repository.EducacionRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EducacionService {
    
    @Autowired
    EducacionRepo educacionRepo;
    
    public List<Educacion> list(){
        return educacionRepo.findAll();
    }
    
    public Optional<Educacion>getOne(int id){
        return educacionRepo.findById(id);
    }
    
    public Optional<Educacion>getByTitle(String title){
        return educacionRepo.findByTitle(title);
    }
    
    public void save(Educacion educacion){
        educacionRepo.save(educacion);
    }
    
    public void delete(int id){
        educacionRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educacionRepo.existsById(id);
    }
    
    public boolean existsByTitle(String title){
        return educacionRepo.existsByTitle(title);
    }
    
}
