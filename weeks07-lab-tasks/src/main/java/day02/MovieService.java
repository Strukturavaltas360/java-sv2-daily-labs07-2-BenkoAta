package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    List<Movie> movies = new ArrayList<>();

    public MovieService(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line: lines) {
                movies.add(readMovie(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private Movie readMovie(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        String title = scanner.next();
        int year = scanner.nextInt();
        String director = scanner.next();
        return new Movie(title, year, director);
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
