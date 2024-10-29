package firststage;

import java.util.Scanner;

public class Clothes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();
        long d = sc.nextInt();

        min(a,b,c,d);
    }

    public static void min(long a, long b, long c, long d) {
        long m1, m2, m3, m4, m5, m6, m7, m8;
        long n1, n2, n3, n4, n5, n6, n7, n8;


        m1 = a + b;
        n1 = 1;
        long sum1 = m1 + n1;

        m2 = 1;
        n2 = a + b;
        long sum2 = m2 + n2;

        m3 = Math.max(a,b) + 1;
        n3 = 1;
        long sum3 = m3 + n3;

        m4 = 1;
        n4 = Math.max(c,d) + 1;
        long sum4 = m4 + n4;

        m5 = b + 1;
        n5 = d + 1;
        long sum5 = m5 + n5;

        m6 = a + 1;
        n6 = c + 1;
        long sum6 = m6 + n6;


        if (a != 0 && b != 0 && c != 0 && d != 0) {
            if (sum1 <= sum2 && sum1 <= sum3 && sum1 <= sum4 && sum1 <= sum5 && sum1 <= sum6) {
                System.out.println(m1 + " " + n1);
            } else if (sum2 <= sum1 && sum2 <= sum3 && sum2 <= sum4 && sum2 <= sum5 && sum2 <= sum6) {
                System.out.println(m2 + " " + n2);
            } else if (sum3 <= sum1 && sum3 <= sum2 && sum3 <= sum4 && sum3 <= sum5 && sum3 <= sum6) {
                System.out.println(m3 + " " + n3);
            } else if (sum4 <= sum1 && sum4 <= sum2 && sum4 <= sum3 && sum4 <= sum5 && sum4 <= sum6) {
                System.out.println(m4 + " " + n4);
            } else if (sum5 <= sum1 && sum5 <= sum2 && sum5 <= sum3 && sum5 <= sum4 && sum5 <= sum6) {
                System.out.println(m5 + " " + n5);
            } else if (sum6 <= sum1 && sum6 <= sum2 && sum6 <= sum3 && sum6 <= sum4 && sum6 <= sum5) {
                System.out.println(m6 + " " + n6);
            }
        }

        if (a == 0 && c ==0 || b == 0 && d ==0) {
            System.out.println(1 + " " + 1);
        } else if (a == 0) {
            System.out.println(1 + " " + (c + 1));
        } else if (b == 0) {
            System.out.println(1 + " " + (d + 1));
        } else if (c == 0) {
            System.out.println((a + 1) + " " + 1);
        } else if (d == 0) {
            System.out.println((b + 1) + " " + 1);
        }
    }
}
