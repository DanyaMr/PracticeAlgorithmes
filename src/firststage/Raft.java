package firststage;

import java.util.Scanner;

public class Raft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(sidecheck(x1, y1, x2, y2, x, y));

    }

    public static String sidecheck(int x1, int y1, int x2, int y2, int x, int y) {

        if (x > x1 && x < x2) {
            if (y > y2) {
                return("N");
            } else {
                return("S");
            }
        }
        if (y > y1 && y < y2) {
            if (x > x2) {
                return("E");
            } else {
                return("W");
            }
        }
        if (x >= x2 && y >= y2) {
            return ("NE");
        }
        if (x >= x2) {
            return ("SE");
        }
        if (y <= y1) {
            return ("SW");
        }
        return ("NW");
    }

}
