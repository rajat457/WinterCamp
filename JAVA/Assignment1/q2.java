package Assignment1;//WAP to show object cloning in java using cloneable and copy constructor both.

class Test {
    int x, y;
    Test()
    {
        x = 10;
        y = 20;
    }
}

public class q2 {
    public static void main(String[] args)
    {
        Test ob1 = new Test();

        System.out.println(ob1.x + " " + ob1.y);

        // Creating a new reference variable ob2
        // pointing to same address as ob1

        // Any change made in ob2 will
        // be reflected in ob1
        ob1.x = 100;

        System.out.println(ob1.x + " " + ob1.y);
        System.out.println(ob1.x + " " + ob1.y);
    }
}
