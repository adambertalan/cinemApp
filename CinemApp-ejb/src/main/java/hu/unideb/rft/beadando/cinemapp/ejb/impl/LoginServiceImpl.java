package hu.unideb.rft.beadando.cinemapp.ejb.impl;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import hu.unideb.rft.beadando.cinemapp.ejb.api.LoginService;
import hu.unideb.rft.beadando.cinemapp.jpa.entity.Admin;
import hu.unideb.rft.beadando.cinemapp.jpa.repository.AdminRepository;

@Stateless
@Transactional(value = TxType.REQUIRED)
@Interceptors({ SpringBeanAutowiringInterceptor.class })
public class LoginServiceImpl implements LoginService {

	@Autowired
    private AdminRepository adminRepository;
	
	@Override
	public Boolean validate(String username, String password) {
		
		Admin admin = adminRepository.findByUsernameAndPassword(username, password);
		return admin != null;
	}

}
