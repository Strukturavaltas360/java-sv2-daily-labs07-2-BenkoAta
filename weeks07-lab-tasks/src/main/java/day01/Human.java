package day01;

import java.time.LocalDate;

public class Human {
    private String name;
    private int yearOfBirth;

    public Human(String name, int yearOfBirth) {
        validateYearOfBirth(yearOfBirth);
        validateName(name);
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    private void validateYearOfBirth(int yearOfBirth) {
        int actualYear = LocalDate.now().getYear();
        if (actualYear - yearOfBirth > 120) {
            throw new IllegalArgumentException("Hiba: 120 évesnél öregebb nem megengedett!");
        }
    }

    private void validateName(String name) {
        if (name.trim().indexOf(' ') < 0) {
            throw new IllegalArgumentException("Hiba: a névnek legalább két részből kell állnia!");
        }
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
