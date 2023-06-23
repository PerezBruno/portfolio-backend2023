
package com.backend.argentinaprog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY) 
  private int id;
  
      private String title;
      private String school;
      private String description;
      private String dateStart;
      private String dateEnd;
      private String tools;

    public Educacion() {
    }

    public Educacion(String title, String school, String description, String dateStart, String dateEnd, String tools) {
        this.title = title;
        this.school = school;
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.tools = tools;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }
      
      
}
