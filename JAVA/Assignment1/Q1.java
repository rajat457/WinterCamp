package Assignment1;//WAP to sorting string without using string Methods.

public class Q1 {
    public static void main(String[] args) {
        String str = "rajat";
        System.out.println("Before Sorting:" + str);
        int j;
        char temp;
        char[] chars = str.toCharArray();
        for(int i=0; i < chars.length; i++) {
            for(j=0; j < chars.length; j++) {
                if(chars[j] > chars[i]) {
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        System.out.println("After Sorting:");
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }
}