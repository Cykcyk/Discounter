package main.java.com.discounter;

class InputValidator {

    boolean isSmallerThanMaxProductsNumber(int productsSize) {
        return productsSize < 5;
    }

    boolean isPrecisionEqualTwo(String price) {
        try {
            Double.parseDouble(price);
        } catch (NumberFormatException e) {
            return false;
        }
        if (price.contains("\\.")) {
            String[] splitPrice = price.split("\\.");
            return splitPrice[1].length() <= 2;
        }
        return true;
    }

    boolean isPositive(String amount) {
        return Double.parseDouble(amount) < 0;
    }
}
