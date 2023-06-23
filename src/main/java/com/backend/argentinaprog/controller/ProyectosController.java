
package com.backend.argentinaprog.controller;

import com.backend.argentinaprog.dto.Mensaje;
import com.backend.argentinaprog.dto.ProyectosDto;
import com.backend.argentinaprog.entity.Proyectos;
import com.backend.argentinaprog.service.ProyectosService;
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
@RequestMapping("/proyects/")
@CrossOrigin(origins = "https://brunoleandroperezcv.web.app")
public class ProyectosController {
    
        @Autowired
        ProyectosService proyectosService;
        
        @GetMapping("/list")
    public ResponseEntity<List<Proyectos>>list(){
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos>getById(@PathVariable ("id") int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK );
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody ProyectosDto proyectosDto){
        if(proyectosService.existsByTitle(proyectosDto.getTitle ()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Proyectos proyectos = new Proyectos(
          proyectosDto.getUrlImage(),
          proyectosDto.getAlt(),
          proyectosDto.getTitle(),
          proyectosDto.getDescription(),
          proyectosDto.getUrlProyecto()

          );
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto creado con éxito"), HttpStatus.OK);
    }
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id")int id, @RequestBody ProyectosDto proyectosDto){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(proyectosService.existsByTitle(proyectosDto.getTitle())&& proyectosService.getByTitle(proyectosDto.getTitle()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        
        Proyectos proyectos = proyectosService.getOne(id).get();
        
        proyectos.setUrlImage(proyectosDto.getUrlImage());
        proyectos.setAlt(proyectosDto.getAlt());
        proyectos.setTitle(proyectosDto.getTitle());
        proyectos.setDescription(proyectosDto.getDescription());
        proyectos.setUrlProyecto(proyectosDto.getUrlProyecto());
        
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado con éxito"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);

    }
}
