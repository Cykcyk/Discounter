package main.java.com.discounter;

class Product {

    private String name;
    private Double price;
    private Double discount;
    private Double priceWithDiscount;

    Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    Double getPrice() {
        return price;
    }

    Double getDiscount() {
        return discount;
    }

    void setDiscount(Double discount) {
        this.discount = discount;
    }

    Double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    void setPriceWithDiscount(Double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
