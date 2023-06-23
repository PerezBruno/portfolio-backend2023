
package com.backend.argentinaprog.controller;

import com.backend.argentinaprog.dto.Mensaje;
import com.backend.argentinaprog.dto.UsuarioDto;
import com.backend.argentinaprog.entity.Usuario;
import com.backend.argentinaprog.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
@CrossOrigin(origins = "https://brunoleandroperezcv.web.app")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Usuario>>list(){
        List<Usuario> list = usuarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Usuario>getById(@PathVariable("id") int id){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioService.getOne(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK );
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody UsuarioDto usuarioDto){
        if(usuarioService.existsByUserName(usuarioDto.getUserName()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Usuario usuario = new Usuario(
          usuarioDto.getUserName(),
          usuarioDto.getUserLastname(),
          usuarioDto.getTitle(),
          usuarioDto.getPhone(),
          usuarioDto.getEmail(),
          usuarioDto.getEmail2(),
          usuarioDto.getDescription(),
          usuarioDto.getPagGithub(),
          usuarioDto.getPagLinkedin()
          );
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario creado con éxito"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id")int id, @RequestBody UsuarioDto usuarioDto){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(usuarioService.existsByUserName(usuarioDto.getUserName())&& usuarioService.getByUserName(usuarioDto.getUserName()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        
        Usuario usuario = usuarioService.getOne(id).get();
        
        usuario.setUserName(usuarioDto.getUserName());
        usuario.setUserLastname(usuarioDto.getUserLastname());
        usuario.setTitle(usuarioDto.getTitle());
        usuario.setPhone(usuarioDto.getPhone());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setEmail2(usuarioDto.getEmail2());
        usuario.setDescription(usuarioDto.getDescription());
        usuario.setPagGithub(usuarioDto.getPagGithub());
        usuario.setPagLinkedin(usuarioDto.getPagLinkedin());

        
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario actualizado con éxito"), HttpStatus.OK);
    }
    
   // @DeleteMapping("/delete/{id}")
   // public ResponseEntity<?> delete(@PathVariable("id")int id){
  //      if(!usuarioService.existsById(id))
   //         return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
   //     usuarioService.delete(id);
   //     return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);

   // }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") int id){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        usuarioService.delete(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }
}
