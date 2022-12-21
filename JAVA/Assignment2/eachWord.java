package Assignment2;

import java.util.Scanner;

public class eachWord {
    void check(String s){
        if(s.equals("done")) return;
        System.out.println(s.charAt(0)==s.charAt(s.length()-1));
    }
    public static void main(String[] args) {
        String s="";
        eachWord ob=new eachWord();
        Scanner sc=new Scanner(System.in);
        do{
            s=sc.nextLine();
            ob.check(s);
        }while(!s.equals("done"));
    }
}