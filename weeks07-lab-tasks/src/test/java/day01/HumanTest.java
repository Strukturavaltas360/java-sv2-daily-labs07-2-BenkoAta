package day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void createTestWrongName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new Human("Cecília", 1997));
        assertEquals("Hiba: a névnek legalább két részből kell állnia!", exception.getMessage());
    }

    @Test
    void createTestWrongYearOfBirth() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> new Human("Müller Cecília", 1846));
        assertEquals("Hiba: 120 évesnél öregebb nem megengedett!", exception.getMessage());
    }

    @Test
    void createTest() {
        Human human = new Human("Kelemen Emma", 1985);
        assertEquals("Kelemen Emma", human.getName());
        assertEquals(1985, human.getYearOfBirth());
    }

}