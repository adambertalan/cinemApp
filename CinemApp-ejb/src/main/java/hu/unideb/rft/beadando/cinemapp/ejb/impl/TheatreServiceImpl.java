package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.TheatreService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Theatre;


import hu.unideb.rft.beadando.cinemapp.jpa.repository.TheatreRepository;



@Stateless
@Transactional(value = Transactional.TxType.REQUIRED)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    @Override
    public List<Theatre> findAllTheatres() {
        List<Theatre> allTheatre = theatreRepository.findAll();
        return allTheatre;
    }

    @Override
    public Theatre findById(Long theatreId) {
        return theatreRepository.findOne(theatreId);
    }

    public TheatreRepository getTheatreRepository() {
        return theatreRepository;
    }

    public void setTheatreRepository(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

}
