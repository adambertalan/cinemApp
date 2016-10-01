package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseName extends BaseId implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
