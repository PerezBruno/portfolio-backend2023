
package com.backend.argentinaprog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Skills {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String skillName ;
    private String skillValue;
    private String description;
    private String urlIcon;
    private String color;
    
    
    
    public Skills() {
    }

    public Skills(String skillName, String skillValue, String description, String urlIcon, String color) {
        this.skillName = skillName;
        this.skillValue = skillValue;
        this.description = description;
        this.urlIcon = urlIcon;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillValue() {
        return skillValue;
    }

    public void setSkillValue(String skillValue) {
        this.skillValue = skillValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlIcon() {
        return urlIcon;
    }

    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
