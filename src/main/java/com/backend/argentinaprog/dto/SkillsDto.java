
package com.backend.argentinaprog.dto;


public class SkillsDto {
    
    
    private String skillName ;
    private String skillValue;
    private String description;
    private String urlIcon;
    private String color;

    public SkillsDto() {
    }

    public SkillsDto(String skillName, String skillValue, String description, String urlIcon, String color) {
        this.skillName = skillName;
        this.skillValue = skillValue;
        this.description = description;
        this.urlIcon = urlIcon;
        this.color = color;
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
