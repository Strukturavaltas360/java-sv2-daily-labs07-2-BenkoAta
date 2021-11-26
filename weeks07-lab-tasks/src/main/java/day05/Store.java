package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        if (isNotInFuture(p)) {
            products.add(p);
        } else {
            throw new IllegalArgumentException("Selling date is in the future!");
        }
    }

    public void writeToFile(Path dir, int month) {
        Path path = getOutputFilePath(dir, month);
        try {
            Files.write(path, getProductsWithMonth(month));
        } catch (IOException e) {
            throw new IllegalStateException("Can not write file!", e);
        }
    }

    public Path getOutputFilePath(Path dir, int month) {
        return dir.resolve(String.format("store%02d.csv", month));
    }

    private List<String> getProductsWithMonth(int month) {
        List<String> result = new ArrayList<>();
        for (Product product: products) {
            if (product.getDateOfSale().getMonth().getValue() == month) {
                result.add(product.toString());
            }
        }
        return result;
    }

    private boolean isNotInFuture(Product p) {
        LocalDate today = LocalDate.now();
        return !p.getDateOfSale().isAfter(today);
    }

    public List<Product> getProducts() {
        return products;
    }
}
