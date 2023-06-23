
package com.backend.argentinaprog.controller;

import com.backend.argentinaprog.dto.Mensaje;
import com.backend.argentinaprog.dto.SkillsDto;
import com.backend.argentinaprog.service.SkillsService;
import com.backend.argentinaprog.entity.Skills;
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
@RequestMapping("/skills/")
@CrossOrigin(origins = "https://brunoleandroperezcv.web.app")
public class SkillsController {
    
    @Autowired
    SkillsService skillsService;
    
    
    @GetMapping("/list")
    public ResponseEntity<List<Skills>>list(){
        List<Skills> list = skillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills>getById(@PathVariable ("id") int id){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        Skills skills = skillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK );
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create (@RequestBody SkillsDto skillsDto){
        if(skillsService.existsBySkillName(skillsDto.getSkillName()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Skills skills = new Skills(
          skillsDto.getSkillName(),
          skillsDto.getSkillValue(),
          skillsDto.getDescription(),
          skillsDto.getUrlIcon(),
          skillsDto.getColor()
          );
        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill creada con éxito"), HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update (@PathVariable("id")int id, @RequestBody SkillsDto skillsDto){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        if(skillsService.existsBySkillName(skillsDto.getSkillName())&& skillsService.getBySkillName(skillsDto.getSkillName()).get().getId() !=id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        
        Skills skills = skillsService.getOne(id).get();
        
        skills.setSkillName(skillsDto.getSkillName());
        skills.setSkillValue(skillsDto.getSkillValue());
        skills.setDescription(skillsDto.getDescription());
        skills.setUrlIcon(skillsDto.getUrlIcon());
        skills.setColor(skillsDto.getColor());
        
        skillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill actualizada con éxito"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!skillsService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"), HttpStatus.NOT_FOUND);
        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);

    }
    
    
}
