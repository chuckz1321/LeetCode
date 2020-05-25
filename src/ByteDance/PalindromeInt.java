package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-03-04
 */
public class PalindromeInt {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x;
        int help = 1;
        while (tmp >= 10) {
            help *= 10;
            tmp /= 10;
        }
        while (x > 0) {
            if (x / help != x % 10) return false;
            x = (x % help) / 10;
            help /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeInt p = new PalindromeInt();
        System.out.println(p.isPalindrome(1000021));
    }
}
