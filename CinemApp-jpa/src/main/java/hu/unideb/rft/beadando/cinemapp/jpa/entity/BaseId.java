package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class BaseId {
    
    @Id
    @SequenceGenerator(name="id_seq",
    					sequenceName="id_seq",
    					allocationSize=1,initialValue=100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="id_seq")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
