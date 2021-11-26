package day05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {
    Store store = new Store();
    Product p1 = new Product("p1", LocalDate.of(2021, 11, 25), 20.5);
    Product p2 = new Product("p2", LocalDate.of(2021, 11, 26), 20.5);
    Product p3 = new Product("p2", LocalDate.of(2021, 11, 27), 20.5);

    @TempDir
    File tempDir;

    @Test
    void addProductTest() {
        store.addProduct(p1);
        store.addProduct(p2);
        assertEquals(2, store.getProducts().size());
        assertSame(p2, store.getProducts().get(1));
    }

    @Test
    void addProductTestException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, ()-> store.addProduct(p3));
        assertEquals("Selling date is in the future!", iae.getMessage());
    }

    @Test
    void writeToFile() throws IOException {
        Path readPath = store.getOutputFilePath(tempDir.toPath(), 11);
        store.addProduct(p1);
        store.addProduct(p2);
        store.addProduct(new Product("p2", LocalDate.of(2021, 10, 27), 20.5));
        store.writeToFile(Paths.get("src/main/resources"), 11);
        List<String> lines = Files.readAllLines(readPath);
        assertEquals(2, lines.size());
        assertEquals(p1.toString(), lines.get(0));
    }
}