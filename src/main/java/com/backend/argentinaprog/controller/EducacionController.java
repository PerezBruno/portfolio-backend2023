
package com.backend.argentinaprog.controller;

import com.backend.argentinaprog.dto.EducacionDto;
import com.backend.argentinaprog.dto.Mensaje;
import com.backend.argentinaprog.entity.Educacion;
import com.backend.argentinaprog.service.EducacionService;
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
@RequestMapping("/service/")
@CrossOrigin(origins = "https://brunoleandroperezcv.web.app")
public class EducacionController {
    
    @Autowired
    EducacionService educacionService;
    
    
    @GetMapping("/list")
    public ResponseEntity<List<Educacion>>list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion>getById(@PathVariable ("id") int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK );
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody EducacionDto educacionDto){
        if(educacionService.existsByTitle(educacionDto.getTitle()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Educacion educacion = new Educacion(
          educacionDto.getTitle(),
          educacionDto.getSchool(),
          educacionDto.getDescription(),
          educacionDto.getDateStart(),
          educacionDto.getDateEnd(),
          educacionDto.getTools()

          );
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educación creada con éxito"), HttpStatus.OK);
    }
    
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id")int id, @RequestBody EducacionDto educacionDto){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(educacionService.existsByTitle(educacionDto.getTitle())&& educacionService.getByTitle(educacionDto.getTitle()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        
        Educacion educacion = educacionService.getOne(id).get();
        
        educacion.setTitle(educacionDto.getTitle());
        educacion.setSchool(educacionDto.getSchool());
        educacion.setDescription(educacionDto.getDescription());
        educacion.setDateStart(educacionDto.getDateStart());
        educacion.setDateEnd(educacionDto.getDateEnd());
        educacion.setTools(educacionDto.getTools());

        
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educación actualizada con éxito"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);

    }
    
}
