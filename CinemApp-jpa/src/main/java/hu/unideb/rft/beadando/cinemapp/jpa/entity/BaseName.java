package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseName extends BaseId {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
