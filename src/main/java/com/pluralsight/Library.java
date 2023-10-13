package com.pluralsight;

import javax.lang.model.element.NestingKind;
import java.util.Arrays;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        String[] books = {
                "Midnight Milkshakes", "Ache.", "The Knife of Never Letting Go", "everyday",
                "another day", "someday", "I'm Glad My Mom Died", "Lord of the Flies",
                "Romeo and Juliet", "Planes for Dummies", "Trains for Dummies",
                "Boats for Dummies", "Cars for Dummies", "Buses for Dummies",
                "Tanks for Dummies", "Jets for Dummies", "Bikes for Dummies",
                "Skateboards for Dummies", "Scooters for Dummies", "Tractors for Dummies"};

        Book [] bookArray = new Book[books.length];
        for (int i = 0; i < books.length; i++){
            bookArray[i] = new Book(i, "isbn" + i, books[i], false, "");
        }
        Scanner myScanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Show available books");
            System.out.println("2. Show checked out books");
            System.out.println("3. Check out a book");
            System.out.println("4. Check in a book");
            System.out.println("5. Exit");

            int choice = myScanner.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Available books:");
                    for (Book book : bookArray){
                        if (!book.isCheckedOut()){
                            System.out.println(book.getTitle());
                        }
                    }
                    break;

                case 2:
                    System.out.println("Checked out books:");
                    for (Book book : bookArray){
                        if (book.isCheckedOut()){
                            System.out.println(book.getTitle());
                        }
                    }
                    break;

                case 3:
                    System.out.println("Enter the tile of the book you want to check out: ");
                    String titleName = myScanner.next();

                    for (Book book : bookArray){
                        if (book.getTitle().toLowerCase().equals(titleName)){
                            book.setCheckedOut(true);
                            System.out.println("You've checked out: " + book.getTitle());
                        }
                    }
                    break;

                case 4:
                    for (Book book : bookArray){
                        if (book.isCheckedOut()){
                            System.out.println("What book do you want to check in?: ");
                            String checkinIn = myScanner.next();
                            if (checkinIn.equals(book.getTitle())){
                                book.checkIn();
                                System.out.println("Your book is checked in.");
                            }
                        }
                    }
                    break;
                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}