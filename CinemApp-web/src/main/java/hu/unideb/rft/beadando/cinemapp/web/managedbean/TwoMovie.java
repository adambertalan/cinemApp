package hu.unideb.rft.beadando.cinemapp.web.managedbean;

import hu.unideb.rft.beadando.cinemapp.jpa.entity.Movie;

public class TwoMovie {

    private Movie movie1;
    private Movie movie2;

    public TwoMovie(Movie movie1, Movie movie2) {
        this.movie1 = movie1;
        if (movie2 == null) {
            this.movie2 = movie1;
        } else {
            this.movie2 = movie2;
        }
        System.out.println(this.movie1.getMovieCode()+" "+this.movie2.getMovieCode());
    }

    public Movie getMovie1() {
        return movie1;
    }

    public void setMovie1(Movie movie1) {
        this.movie1 = movie1;
    }

    public Movie getMovie2() {
        return movie2;
    }

    public void setMovie2(Movie movie2) {
        this.movie2 = movie2;
    }

}
