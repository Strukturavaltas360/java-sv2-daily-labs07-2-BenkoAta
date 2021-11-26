package day05;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void toStringTest() {
        Product p1 = new Product("p1", LocalDate.of(2021, 11, 26), 11.3);
        assertEquals("p1;2021-11-26;11,30", p1.toString());
    }

}