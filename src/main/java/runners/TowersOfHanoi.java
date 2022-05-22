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
            System.out.println("Move disc :"+n +"  "+source+" -> "+dest);
            return;
        }
        towersOfHanoi(n-1, source, aux, dest);
        System.out.println("Move disc :"+n +"  "+source+" -> "+dest);
        towersOfHanoi(n-1, aux, dest, source);
    }
}
