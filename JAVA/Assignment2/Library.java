package Assignment2;

import java.util.Scanner;

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
    Book[] books =new Book[10];
    int booknum =-1;
    void addBook(String s){
        this.books[++this.booknum]=new Book(s);
    }
    void checkOut(String s){
        for(Book v:this.books){
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
        for(Book v:this.books){
            if(v!=null) {
                if (v.title.equals(s)) {
                    v.returner();
                    System.out.println("Returned");
                }
            }
        }
    }
    void receiveRating(String s, int r){
        for(Book v:this.books){
            if(v!=null) {
                if (v.title.equals(s)) {
                    v.rate(r);
                }
            }
        }
    }
    void listInventory(){
        int flag=0;
        for(Book v:this.books){
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
        BookStore store=new BookStore();
        Scanner sc=new Scanner(System.in);
        int option,rate;
        String t="";
        store.addBook("The Tempesr");
        store.addBook("Merchant Of Venis");
        store.addBook("Romeo & Juliet");
        while(true) {
            System.out.println("Menu:\t1.ADD NEW BOOK\t2.CHECKOUT A BOOK\t3.RETURN A BOOK\t4.RATE A BOOK\t5.VIEW INVENTORY\t6.EXIT\t");
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
        Library start=new Library();
        start.Launch();
    }
}