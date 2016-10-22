package hu.unideb.rft.beadando.cinemapp.jpa.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Cupon extends BaseName {

	@Enumerated(EnumType.STRING)
    private CuponType type;
    
    private boolean used;
    
    private Timestamp startOfValidity;
    
    private Timestamp endOfValidity;

    public CuponType getType() {
        return type;
    }

    public void setType(CuponType type) {
        this.type = type;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

	public Timestamp getStartOfValidity() {
		return startOfValidity;
	}

	public void setStartOfValidity(Timestamp startOfValidity) {
		this.startOfValidity = startOfValidity;
	}

	public Timestamp getEndOfValidity() {
		return endOfValidity;
	}

	public void setEndOfValidity(Timestamp endOfValidity) {
		this.endOfValidity = endOfValidity;
	}
}
