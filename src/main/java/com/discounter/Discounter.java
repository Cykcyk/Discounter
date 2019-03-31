package main.java.com.discounter;

import java.util.ArrayList;

class Discounter {
    private Double remainingDiscount;

    Discounter() {

    }

    private Double calculateTotalPrice(ArrayList<Product> products) {
        Double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice = totalPrice + product.getPrice();
        }
        return totalPrice;
    }

    private Double calculateDiscountPercent(Double totalPrice, Double discount) {
        return discount / totalPrice * 100;
    }

    private void reduceRemainingDiscount(Double discountAcquired) {
        remainingDiscount = remainingDiscount - discountAcquired;
    }

    private void roundRemainingDiscount() {
        remainingDiscount = Math.floor(remainingDiscount * 100.00) / 100.00;

    }

    private void calculateDiscountForProducts(Double discountPercent, ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (i != products.size() - 1) {
                products.get(i).setDiscount(Math.floor(products.get(i).getPrice() * discountPercent) / 100.00);
                reduceRemainingDiscount(products.get(i).getDiscount());
            } else {
                roundRemainingDiscount();
                products.get(i).setDiscount(remainingDiscount);
            }
        }
    }

    private void setPriceWithDiscountForProducts(ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (i != products.size() - 1) {
                products.get(i).setPriceWithDiscount(Math.floor((products.get(i).getPrice() - products.get(i).getDiscount()) * 100.00) / 100.00);
            } else {
                products.get(i).setPriceWithDiscount(products.get(1).getPrice() - products.get(i).getDiscount());
            }
        }
    }

    ArrayList<Product> calculateDiscounts(ArrayList<Product> products, Double discount) {
        if (products.isEmpty()){
            throw new NullPointerException("Brak produktow na liscie");
        }
        remainingDiscount = discount;
        Double totalPrice = calculateTotalPrice(products);
        if (totalPrice < discount) {
            throw new IllegalStateException("Wartosc rabatu przekracza wartosc produktow");
        }
        Double discountPercent = calculateDiscountPercent(totalPrice, discount);
        calculateDiscountForProducts(discountPercent, products);
        setPriceWithDiscountForProducts(products);
        return products;
    }
}
