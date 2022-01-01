package searchAndSort;

public class RecursiveAlgos {

    public static int fac(int n) {
        if (n<2) {
            return 1;
        }else{
            return n * fac(n-1) ;
        }
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();

        if (len<2){
            return true;
        }else{
            char first = s.charAt(0);
            char last  = s.charAt(len-1);
            String mid = s.substring(1, len-1);
            return (first==last) && isPalindrome(mid);
        }
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * pow(x, n - 1);
        }
    }

    public static int sum(int n) {
        if (n < 2) {
            return n;
        }else{
            return n + sum(n - 1);
        }
    }

}
