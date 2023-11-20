//Shop: Класс, представляющий магазин. У каждого магазина есть список продуктов, которые он предлагает.

package model;

import java.util.List;

public class Shop {
    // Список продуктов в магазине
    private final List<Product> productsShop;

    // При создании магазина нужно передать ему список продуктов
    public Shop(List<Product> productsShop) {
        this.productsShop = productsShop;
    }

    // Метод для получения текущего списка продуктов
    public List<Product> getProductsShop() {
        return productsShop;
    }
}