package shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(12, "product1"));
        products.add(new Product(78, "product2"));
        products.add(new Product(34, "product3"));
        products.add(new Product(90, "product4"));
        products.add(new Product(56, "product5"));
        products.add(new Product(15, "product6"));

        System.out.printf("Неотсортированный список товаров " + products);
        System.out.printf("\n -----------");
        System.out.printf("\n Отсортированный список товаров " + getSortedListProducts(products));
        System.out.printf("\n -----------");
        System.out.printf("\n Самый дорогой товар " + getMostExpensiveProduct(products));

    }

    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public static List<Product> getSortedListProducts(List<Product> products) {
        products.sort(Comparator.comparing(Product::getCost));
        return products;
    }

    /**
     * @return самый дорогой продукт
     */
    public static Product getMostExpensiveProduct(List<Product> products) {
        return products.stream().max(Comparator.comparing(Product::getCost)).orElse(null);
    }
}

