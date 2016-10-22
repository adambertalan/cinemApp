package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Admin;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface AdminRepository extends JpaRepository<Admin,Long> {

	public Admin findByUsernameAndPassword(String username, String password);
}
