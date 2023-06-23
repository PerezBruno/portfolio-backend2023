
package com.backend.argentinaprog.dto;

public class ExperienciaDto {
      private String jobPosition;
      private String company;
      private String dateStart;
      private String dateEnd;
      private String description;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String jobPosition, String company, String dateStart, String dateEnd, String description) {
        this.jobPosition = jobPosition;
        this.company = company;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.description = description;
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
