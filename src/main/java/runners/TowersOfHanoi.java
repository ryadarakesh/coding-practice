package runners;

public class TowersOfHanoi {

    public static void main (String[] args) {
        towersOfHanoi(4, "SOURCE", "DEST", "AUX");
    }

    /*
        Refered https://www.youtube.com/watch?v=q6RicK1FCUs for easy understanding
     */

    public static void towersOfHanoi (int n, String source, String dest, String aux) {
        if (n == 1) {
            System.out.println("Move disc :"+source+" -> "+dest);
            return;
        }
        // Below explanation is with 2 discs
        // move(n-1)=1 disc from source to aux
        towersOfHanoi(n-1, source, aux, dest);
        // move the nth disc from source to dest
        System.out.println("Move disc :"+source+" -> "+dest);
        // move the (n-1) =1 disc from aux to dest
        towersOfHanoi(n-1, aux, dest, source);
    }
}
