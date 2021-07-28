package ServerRSocketSpring.controller;

import ServerRSocketSpring.model.Movie;
import ServerRSocketSpring.repository.MovieRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @MessageMapping("request-response")
    Mono<Movie> getMovieByName(Movie movie) {
        return movieRepository.findById(movie.getId());
    }

    @MessageMapping("request-stream")
    Flux<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @MessageMapping("fire-forget")
    Mono<Void> addMovie(Movie movie) {
        movieRepository.save(movie);
        return Mono.empty();
    }

}
