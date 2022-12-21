package Assignment2;

import java.util.*;

class Book {
    String title;
    boolean checkoutflag;
    int numrate;
    double avgrating;
    Book(String t){
        this.title=t;
        this.checkoutflag =false;
        this.avgrating =0.0;
        this.numrate=0;
    }
    void check(){
        this.checkoutflag =true;
    }
    void returner(){
        this.checkoutflag =false;
    }
    void rate(int rating){
        this.avgrating =(this.avgrating*this.numrate+rating)/++this.numrate;
    }
}

class BookStore {
    Assignment2.Book[] books =new Assignment2.Book[10];
    int booknum =-1;
    void addBook(String s){
        this.books[++this.booknum]=new Assignment2.Book(s);
    }
    void checkOut(String s){
        for(Assignment2.Book v:this.books){
            if(v!=null) {
                if (v.title.equals(s)) {
                    if (!v.checkoutflag) {
                        v.check();
                        System.out.println("Rented out");
                    } else {
                        System.out.println("Cannot be rented");
                    }
                    return;
                }
            }
        }
        System.out.println("Does not exist");
    }
    void returnBook(String s){
        for(Assignment2.Book v:this.books){
            if(v!=null) {
                if (v.title.equals(s)) {
                    v.returner();
                    System.out.println("Returned");
                }
            }
        }
    }
    void receiveRating(String s, int r){
        for(Assignment2.Book v:this.books){
            if(v!=null) {
                if (v.title.equals(s)) {
                    v.rate(r);
                }
            }
        }
    }
    void listInventory(){
        int flag=0;
        for(Assignment2.Book v:this.books){
            if(v!=null&& !v.checkoutflag) {
                flag=1;
                System.out.print(v.title);
                if(v.avgrating>0) System.out.print(" | Rated: "+v.avgrating+"stars");
                System.out.println();
            }
        }
        if(flag==0) System.out.println("NO BOOKS AVAILABLE");
    }
}

public class Library {
    void Launch(){
        Assignment2.BookStore store=new Assignment2.BookStore();
        Scanner sc=new Scanner(System.in);
        int option,rate;
        String t="";
        store.addBook("The Tempesr");
        store.addBook("Merchant Of Venis");
        store.addBook("Romeo & Juliet");
        while(true) {
            System.out.println("""
                    
                    Menu:
                    1.ADD NEW BOOK
                    2.CHECKOUT A BOOK
                    3.RETURN A BOOK
                    4.RATE A BOOK
                    5.VIEW INVENTORY
                    6.EXIT""");
            option = sc.nextInt();
            if(option<=4&&option>=1){
                sc.nextLine();
                System.out.println("Enter Book title: ");
                t = sc.nextLine();
            }
            switch (option) {
                case 1 -> {
                    store.addBook(t);
                    System.out.println("Added");
                }
                case 2 -> store.checkOut(t);
                case 3 -> store.returnBook(t);
                case 4 -> {
                    System.out.println("Enter rating out of 5 stars: ");
                    rate = sc.nextInt();
                    store.receiveRating(t, rate);
                }
                case 5 -> store.listInventory();
                case 6 -> System.exit(0);
                default -> System.out.println("Try Again");
            }
        }
    }
    public static void main(String[] args) {
        Assignment2.Library start=new Assignment2.Library();
        start.Launch();
    }
}