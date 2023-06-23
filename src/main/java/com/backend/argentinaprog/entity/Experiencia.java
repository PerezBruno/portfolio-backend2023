
package com.backend.argentinaprog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
      private String jobPosition;
      private String company;
      private String dateStart;
      private String dateEnd;
      private String description;

    public Experiencia() {
    }

    public Experiencia(String jobPosition, String company, String dateStart, String dateEnd, String description) {
        this.jobPosition = jobPosition;
        this.company = company;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
      
}
