
package com.backend.argentinaprog.service;

import com.backend.argentinaprog.entity.Usuario;
import com.backend.argentinaprog.repository.UsuarioRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepo usuarioRepo;
    
        public List<Usuario> list(){
        return usuarioRepo.findAll();
    }
    
    public Optional<Usuario>getOne(int id){
        return usuarioRepo.findById(id);
    }
    
    public Optional<Usuario>getByUserName(String userName){
        return usuarioRepo.findByUserName(userName);
    }
    
    public void save(Usuario usuario){
        usuarioRepo.save(usuario);
    }
    
    public void delete(int id){
        usuarioRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return usuarioRepo.existsById(id);
    }
    
    public boolean existsByUserName(String userName){
        return usuarioRepo.existsByUserName(userName);
    }
        
}
