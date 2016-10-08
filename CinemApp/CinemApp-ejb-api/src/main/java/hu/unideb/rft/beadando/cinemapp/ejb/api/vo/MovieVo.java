package hu.unideb.rft.beadando.cinemapp.ejb.api.vo;

import java.io.Serializable;

public class MovieVo implements Serializable{
    
    private Long id;
    private String name;
    private Integer rating;
    private Integer ageLimit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }
    
    
}
