/*
Błażej Kozikowski nr albumu 9705
Algorytmy i struktury danych - Lista
 */


package com.company;

import java.util.*;

class ShoppingList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        ShoppingList shoppingList = new ShoppingList();

        while(shouldContinue) {
            System.out.println("Wybierz opcję");
            System.out.println("1. Utwórz listę zakupów");
            System.out.println("2. Wyświetl listę zakupów");
            System.out.println("3. Dodaj artykuł");
            System.out.println("4. Usuń artykuł");
            System.out.println("5. Sortowanie listy zakupów");
            System.out.println("6. Wyjście");

            int userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1 -> shoppingList.MaxNumber();
                case 2 -> shoppingList.displayProducts();
                case 3 -> shoppingList.addProducts();
                case 4 -> shoppingList.removeProducts();
                case 5 -> shoppingList.sorts();
                case 6 -> shouldContinue=false;
                default -> System.out.println("Wybierz liczbę 1-6\n");
            }
        }
    }

    private List<String> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    int maxNumber;

    public void MaxNumber() {
        System.out.println("Max liczba produktów na liście zakupów: ");
        maxNumber = scanner.nextInt();
    }

    public void addProducts() {
        if(products.size() >= maxNumber) {
            System.out.println("Lista jest pełna. Usuń niepotrzebny artykuł aby dodać nowy produkt. \n");
            return;
        } else {
            System.out.println("Wpisz produkt: ");
            String name = scanner.next();
            products.add(name);
        }
    }

    public void displayProducts() {
        System.out.println("Lista składa się z " + products.size() + " pozycji");
        for (String product : products) {
            System.out.println(product);
        }
        System.out.println();
    }

    public void removeProducts() {
        System.out.println("Wybierz produkt który chcesz usunąć z listy zakupów: ");
        for (int i=0; i< products.size(); i++) {
            System.out.println(i+1 +" " + products.get(i));
        }
        int choice = scanner.nextInt();
        if(choice > products.size()) {
            System.out.println("Nieprawidlowe dane");
        } else {
            System.out.println("Usunięto artykuł: " + products.get(choice-1) +"\n");
            products.remove(choice-1);
        }
    }

    public void sorts() {
        System.out.println("Sortowanie w kolejności alfabetycznej ->");
        Collections.sort(products);
        displayProducts();
    }
}
