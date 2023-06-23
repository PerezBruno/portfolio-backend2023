
package com.backend.argentinaprog.service;

import com.backend.argentinaprog.entity.Proyectos;
import com.backend.argentinaprog.repository.ProyectosRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProyectosService {
    
    @Autowired
    ProyectosRepo proyectosRepo;
    
    public List<Proyectos> list(){
        return proyectosRepo.findAll();
    }
    
    public Optional<Proyectos>getOne(int id){
        return proyectosRepo.findById(id);
    }
    
    public Optional<Proyectos>getByTitle(String title){
        return proyectosRepo.findByTitle(title);
    }
    
    public void save(Proyectos proyectos){
        proyectosRepo.save(proyectos);
    }
    
    public void delete(int id){
        proyectosRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectosRepo.existsById(id);
    }
    
    public boolean existsByTitle(String title){
        return proyectosRepo.existsByTitle(title);
    }
          
}
