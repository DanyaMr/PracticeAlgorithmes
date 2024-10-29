package firststage;

import java.util.Scanner;

public class LetterBoard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            int b = 0;
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                board[i][b] = String.valueOf(c);
                b += 1;
            }
        }

        String[][] newBoard = changeBoardToLetter(board);

        System.out.println(FindLetter(newBoard));

    }

    public static String[][] changeBoardToLetter(String[][] board) {

        String[][] newBoard = new String[board.length][board[0].length];

        int count = 0;

        for (int j = 0; j < board[0].length; j++) {
            newBoard[0][j] = board[0][j];
        }

        for (int i = 1; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(board[i - 1][j])) {
                    count += 1;
                }
            }
            if (count == board[i].length) {
                for (int k = 0; k < board[i].length; k++) {
                    newBoard[i][k] = "0";
                }
            } else {
                for (int k = 0; k < board[i].length; k++) {
                    newBoard[i][k] = board[i][k];
                }
            }
            count = 0;
        }

        String[][] newBoard2 = new String[board.length][board[0].length];

        for (int j = 0; j < board.length; j++) {
            newBoard2[j][0] = newBoard[j][0];
        }

        for (int i = 1; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {
                if (newBoard[j][i].equals(newBoard[j][i - 1])) {
                    count += 1;
                }
            }
            if (count == board.length) {
                for (int k = 0; k < board.length; k++) {
                    newBoard2[k][i] = "0";
                }
            } else {
                for (int k = 0; k < board.length; k++) {
                    newBoard2[k][i] = newBoard[k][i];
                }
            }
            count = 0;
        }

        int countX = 0;
        int countY = 0;

        for (int k = 0; k < board.length; k++) {
            if (newBoard2[0][k].equals("0")) {
                countX += 1;
            }
        }
        for (int k = 0; k < board.length; k++) {
            if (newBoard2[k][0].equals("0")) {
                countY += 1;
            }
        }

        String[][] newBoard3 = new String[newBoard2.length - countY][newBoard2[0].length - countX];

        countX = 0;
        countY = 0;
        for (int j = 0; j < newBoard2.length; j++) {
            if (stringOfZero(newBoard2, j)) {
                countY += 1;
                continue;
            }
            for (int k = 0; k < newBoard2[0].length; k++) {
                if (!(newBoard2[j][k].equals("0"))) {
                    newBoard3[j - countY][k - countX] = newBoard2[j][k];
                } else {
                    countX += 1;
                }
            }
            countX = 0;
        }

        return newBoard3;
    }

    public static boolean stringOfZero(String[][] s, int i) {
        int counter = 0;
        for (int j = 0; j < s[i].length; j++) {
            if (s[i][j].equals("0")) {
                counter += 1;
            }
        }
        if (counter == s[i].length) {
            return true;
        }
        return false;
    }

    public static String FindLetter(String[][] board) {
        boolean flag = false;
        int k = 0;
        int l = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("#")) {
                    flag = true;
                    k = i;
                    l = j;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        if (!flag) {
            return "X";
        }

        int countBadDiods = 0;
        int countSidePoints = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("#")) {
                    if (j - 1 >= 0) {
                        if (board[i][j - 1].equals(".")) {
                            countSidePoints += 1;
                        } else {
                            countSidePoints = 0;
                            continue;
                        }
                    } else {
                        countSidePoints += 1;
                    }
                    if (board[0].length > j + 1) {
                        if (board[i][j + 1].equals(".")) {
                            countSidePoints += 1;
                        } else {
                            countSidePoints = 0;
                            continue;
                        }

                    } else {
                        countSidePoints += 1;
                    }
                    if (i - 1 >= 0) {
                        if (board[i - 1][j].equals(".")) {
                            countSidePoints += 1;
                        } else {
                            countSidePoints = 0;
                            continue;
                        }
                    } else {
                        countSidePoints += 1;
                    }
                    if (board.length > i + 1) {
                        if (board[i + 1][j].equals(".")) {
                            countSidePoints += 1;
                        } else {
                            countSidePoints = 0;
                            continue;
                        }
                    } else {
                        countSidePoints += 1;
                    }
                }
                if (countSidePoints == 4) {
                    countBadDiods +=1;
                }
                countSidePoints = 0;
            }
        }

        if (countBadDiods >= 2) {
            return "X";
        }

        int countTurnedOnDiods = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].equals("#")) {
                    countTurnedOnDiods += 1;
                }
            }
        }

        if (countTurnedOnDiods == 1 && countBadDiods == 1) {
            return "I";
        }


        if (board.length >= k + 2 && board[0].length >= l + 2 && board[k + 1][l].equals("#") && board[k + 1][l + 1].equals("#") && countTurnedOnDiods == 3 && board.length >= k + 2 && board[0].length >= l + 2) {
            return "L";
        }

        if (board.length >= k + 3 && board[0].length >= l + 2 && board[k][l + 1].equals("#")  && board[k + 2][l + 1].equals("#") && board[k + 2][l].equals("#") && board[k + 1][l].equals("#") && countTurnedOnDiods == 5) {
            return "C";
        }

        if (board.length >= k + 3 && board[0].length >= l + 3 && board[k][l + 1].equals("#") && board[k][l + 2].equals("#") && board[k + 1][l + 2].equals("#") && board[k + 2][l + 2].equals("#") && board[k + 2][l + 1].equals("#") && board[k + 2][l].equals("#") && board[k + 1][l].equals("#") && countTurnedOnDiods == 8) {
            return "O";
        }

        if (board.length >= k + 3  && board[0].length >= l + 3 && board[k + 1][l].equals("#") && board[k + 2][l].equals("#") && board[k + 1][l + 1].equals("#") && board[k][l + 2].equals("#") && board[k + 1][l + 2].equals("#") && board[k + 2][l + 2].equals("#") && countTurnedOnDiods == 7){
            return "H";
        }

        if (board.length >= k + 4 && board[0].length >= l + 3 && board[k][l + 1].equals("#") && board[k][l + 2].equals("#") && board[k + 1][l + 2].equals("#") && board[k + 2][l + 2].equals("#") && board[k + 2][l + 1].equals("#") && board[k + 2][l].equals("#") && board[k + 1][l].equals("#") && board[k + 3][l].equals("#") && countTurnedOnDiods == 9) {
            return "P";
        }

        return "X";
    }
}