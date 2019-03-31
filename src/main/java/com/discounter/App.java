package main.java.com.discounter;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private InputValidator inputValidator;
    private ProductsManager productsManager;
    private Discounter discounter;
    private Scanner scanner;
    private boolean quit = false;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private App() {
        productsManager = new ProductsManager();
        discounter = new Discounter();
        inputValidator = new InputValidator();
        scanner = new Scanner(System.in);

    }

    private void run() {
        while (!quit) {
            System.out.println("1. Wczytaj  dane testowe\n" +
                    "2. Wprowadz produkty\n" +
                    "3. Wprowadz rabat\n" +
                    "4. Oblicz znizki\n" +
                    "5. Wyjscie");
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    productsManager.loadTestData();
                    break;

                case 2:
                    getProductFromUser();
                    break;

                case 3:
                    getDiscountFromUser();
                    break;

                case 4:
                    try {
                        ArrayList<Product> productsWithDiscounts = discounter.calculateDiscounts(productsManager.getProducts(), productsManager.getDiscount());
                        printProducts(productsWithDiscounts);
                        productsManager.clear();
                    } catch (IllegalStateException | NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    quit = true;
                    break;

                default:
                    System.out.println("Wybierz jedna z dostepnych opcji");
                    break;
            }
        }
    }

    private void getProductFromUser() {
        if (!inputValidator.isSmallerThanMaxProductsNumber(productsManager.getProductsSize())) {
            System.out.println("Wprowadzono juz 5 produktow");
        } else {
            System.out.println("Wprowadz nazwe produktu");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            String price = getAmount("Wprowadz cene produktu");
            productsManager.insertProduct(name, Double.valueOf(price));
        }
    }

    private String getAmount(String inputText) {
        while (true) {
            System.out.println(inputText);
            String amount = scanner.nextLine();
            if (!inputValidator.isPrecisionEqualTwo(amount)) {
                System.out.println("Wprowadz liczbe z dokladnoscia do dwoch miejsc po przecinku");
            } else {
                return amount;
            }
        }
    }

    private void getDiscountFromUser() {
        String discount = getAmount("Wprowadz wartosc rabatu");
        productsManager.setDiscount(Double.valueOf(discount));
    }

    private void printProducts(ArrayList<Product> products) {
        for (Product product : products) {
            System.out.println(product.getName() + " " + product.getPriceWithDiscount());
        }
    }
}

