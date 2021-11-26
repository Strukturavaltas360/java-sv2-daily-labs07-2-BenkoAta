package day05;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate dateOfSale;
    private double price;

    public Product(String name, LocalDate dateOfSale, double price) {
        this.name = name;
        this.dateOfSale = dateOfSale;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%.2f", name, dateOfSale.toString(), price);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfSale() {
        return dateOfSale;
    }

    public double getPrice() {
        return price;
    }
}
