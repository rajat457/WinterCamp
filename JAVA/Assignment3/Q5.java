package Assignment3;

import static java.lang.Math.min;
import java.util.Scanner;
public class Q5 {
    public static int abs(int x) {
        if(x<0)
            x=x*-1;
        return x;
    }

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sr.nextInt();
        }

        int X = sr.nextInt(); int Y = sr.nextInt();
        int min_dist = 10000000;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[i] == X && arr[j] == Y)
                    min_dist = min(min_dist , abs(i-j));
                if(arr[i] == Y && arr[j] == X)
                    min_dist = min(min_dist , abs(i-j));
            }
        }
        System.out.println(min_dist);
    }
}