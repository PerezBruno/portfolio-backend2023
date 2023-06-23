
package com.backend.argentinaprog.dto;

public class ProyectosDto {
      private String urlImage;
      private String alt;
      private String title;
      private String description;
      private String urlProyecto;

    public ProyectosDto() {
    }

    public ProyectosDto(String urlImage, String alt, String title, String description, String urlProyecto) {
        this.urlImage = urlImage;
        this.alt = alt;
        this.title = title;
        this.description = description;
        this.urlProyecto = urlProyecto;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlProyecto() {
        return urlProyecto;
    }

    public void setUrlProyecto(String urlProyecto) {
        this.urlProyecto = urlProyecto;
    }
      
      
    
}
