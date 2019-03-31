package main.java.com.discounter;

import java.util.ArrayList;

class ProductsManager {

    private Double discount;
    private ArrayList<Product> products = new ArrayList<>();

    Double getDiscount() {
        return discount;
    }

    ArrayList<Product> getProducts() {
        return products;
    }

    void setDiscount(Double discount) {
        this.discount = discount;
    }

    void insertProduct(String productName, Double productPrice) {
        products.add(new Product(productName, productPrice));
    }

    int getProductsSize() {
        return products.size();
    }

    void loadTestData() {
        Product product0 = new Product("E", 34.79);
        products.add(product0);
        Product product = new Product("A", 152.15);
        products.add(product);
        Product product2 = new Product("B", 78.45);
        products.add(product2);
        Product product3 = new Product("C", 9.47);
        products.add(product3);
        Product product4 = new Product("D", 325.14);
        products.add(product4);
        discount = 150.00;
    }

    void clear() {
        products.clear();
        discount = 0.00;
    }
}
