
package com.backend.argentinaprog.controller;

import com.backend.argentinaprog.dto.ExperienciaDto;
import com.backend.argentinaprog.dto.Mensaje;
import com.backend.argentinaprog.entity.Experiencia;
import com.backend.argentinaprog.service.ExperienciaService;
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
@RequestMapping("/experience/")
@CrossOrigin(origins = "https://brunoleandroperezcv.web.app")
public class ExperienciaController {
    
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experiencia>>list(){
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody ExperienciaDto experienciaDto){
        if(experienciaService.existsByJobPosition(experienciaDto.getJobPosition()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Experiencia experiencia = new Experiencia(
          experienciaDto.getJobPosition(),
          experienciaDto.getCompany(),
          experienciaDto.getDateStart(),
          experienciaDto.getDateEnd(),
          experienciaDto.getDescription()
          );
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia creada con éxito"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id")int id, @RequestBody ExperienciaDto experienciaDto){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(experienciaService.existsByJobPosition(experienciaDto.getJobPosition())&& experienciaService.getByJobPosition(experienciaDto.getJobPosition()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        
        experiencia.setJobPosition(experienciaDto.getJobPosition());
        experiencia.setCompany(experienciaDto.getCompany());
        experiencia.setDateStart(experienciaDto.getDateStart());
        experiencia.setDateEnd(experienciaDto.getDateEnd());
        experiencia.setDescription(experienciaDto.getDescription());
        
        experienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada con éxito"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        experienciaService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);

    }
    
    
}
