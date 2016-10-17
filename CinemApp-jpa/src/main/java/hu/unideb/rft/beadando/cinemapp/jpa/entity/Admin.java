package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.Entity;

@Entity
public class Admin extends BaseName {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
