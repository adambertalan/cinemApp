package hu.unideb.rft.beadando.cinemapp.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
