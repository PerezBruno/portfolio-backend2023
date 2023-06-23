
package com.backend.argentinaprog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    
      private String urlImage;
      private String alt;
      private String title;
      private String description;
      private String urlProyecto;

    public Proyectos() {
    }

    public Proyectos(String urlImage, String alt, String title, String description, String urlProyecto) {
        this.urlImage = urlImage;
        this.alt = alt;
        this.title = title;
        this.description = description;
        this.urlProyecto = urlProyecto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
