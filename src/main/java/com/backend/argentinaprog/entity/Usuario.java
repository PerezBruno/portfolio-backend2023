
package com.backend.argentinaprog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
  
        private String userName;
        private String userLastname;
        private String title;
        private String phone;
        private String email;
        private String email2;
        private String description;
        private String pagGithub;
        private String pagLinkedin;

    public Usuario() {
    }

    public Usuario(String userName, String userLastname, String title, String phone, String email, String email2, String description, String pagGithub, String pagLinkedin) {
        this.userName = userName;
        this.userLastname = userLastname;
        this.title = title;
        this.phone = phone;
        this.email = email;
        this.email2 = email2;
        this.description = description;
        this.pagGithub = pagGithub;
        this.pagLinkedin = pagLinkedin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPagGithub() {
        return pagGithub;
    }

    public void setPagGithub(String pagGithub) {
        this.pagGithub = pagGithub;
    }

    public String getPagLinkedin() {
        return pagLinkedin;
    }

    public void setPagLinkedin(String pagLinkedin) {
        this.pagLinkedin = pagLinkedin;
    }
    
        
}
