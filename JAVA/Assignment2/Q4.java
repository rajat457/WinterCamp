package Assignment2;

import java.util.Scanner;

interface Furniture {
    void stressTest();
    void fireTest();
}

abstract class Chair implements Furniture {
    public abstract String chairType();

}
abstract class Table implements Furniture {
    public abstract String tableType();
}

class MetalChair extends Chair {
    @Override
    public void stressTest() {
        System.out.println("Passed Stress Test");
    }

    @Override
    public void fireTest() {
        System.out.println("Passed Fire Test");
    }

    @Override
    public String chairType() {
        return "This is a metal Chair";
    }
}

class MetalTable extends Table {
    @Override
    public void stressTest() {

        System.out.println("Passed Stress Test");
    }

    @Override
    public void fireTest() {
        System.out.println("Passed Fire Test");
    }

    @Override
    public String tableType() {
        return "This is a metal Table";
    }
}


class WoodenTable extends Table {
    @Override
    public void stressTest() {
        System.out.println("Failed Stress Test");
    }

    @Override
    public void fireTest() {
        System.out.println("Failed Fire Test");
    }

    @Override
    public String tableType() {
        return "This is a wooden Table";
    }
}


class WoodenChair extends Chair {
    @Override
    public void stressTest() {
        System.out.println("Failed Stress Test");
    }

    @Override
    public void fireTest() {
        System.out.println("Failed Fire Test");
    }

    @Override
    public String chairType() {
        return "This is a wooden Chair";
    }
}

public class Q4 {
    public static void main(String[] args){
        System.out.println("Table Type:");
        Table table = null;
        Scanner input =  new Scanner(System.in);
        String str = input.next();
        if(str.equals("wooden")){
            table = new WoodenTable();


        }   else if (str.equals("metal")){
            table = new MetalTable();


        }

        assert table != null;
        System.out.println(table.tableType());
        table.stressTest();
        table.fireTest();

        System.out.println("\nChair type:");
        Chair chair = null;
        Scanner input1 =  new Scanner(System.in);
        String str1 = input1.next();
        if(str1.equals("wooden")){
            chair = new WoodenChair();


        }   else if (str1.equals("metal")){
            chair = new MetalChair();


        }

        assert chair != null;
        System.out.println(chair.chairType());
        chair.stressTest();
        chair.fireTest();
    }
}