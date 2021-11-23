package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    @Test
    void createTest() {
        Path path = Paths.get("src/main/resources/movies.csv");
        MovieService movieService = new MovieService(path);
        assertEquals(5, movieService.getMovies().size());
        assertEquals("Jurassic park", movieService.getMovies().get(0).getTitle());
        assertEquals(1993, movieService.getMovies().get(0).getYearOfProduction());
        assertEquals("Steven Spielberg", movieService.getMovies().get(0).getDirector());
        assertEquals("Jaws", movieService.getMovies().get(4).getTitle());
    }

    @Test
    void createTestException() {
        Path path = Paths.get("src/main/resources/mov.csv");
        assertThrows(IllegalStateException.class, () -> new MovieService(path));
    }

}