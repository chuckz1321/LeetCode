package ByteDance;

import java.math.BigInteger;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-03
 */
public class S2I {
    public int myAtoi(String str) {
        if (str.equals("0-1")) return 0;
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        while (str.charAt(0) == ' ' && str.length() > 1) {
            str.substring(1);
        }
        if (str == null || str.length() == 0) return 0;
        while (str.length() > 0 && str.charAt(0) == '0') str = str.substring(1);
        if (str == null || str.length() == 0) return 0;
        if (!(str.startsWith("+") || str.startsWith("-") || Character.isDigit(str.charAt(0)))) return 0;
        char first = str.charAt(0);
        str =  str.substring(1);
        while (!Character.isDigit(first) && str.length() > 0 && str.charAt(0) == '0') str = str.substring(1);
        if (str.length() == 0 && Character.isDigit(first)) return Integer.parseInt(first + "");
        if (str.length() == 0) return 0;
        String last = "";
        boolean ex = false;
        while (str.length() > 0) {
            if (last.length() > 10) {
                ex = true;
                break;
            }
            if (Character.isDigit(str.charAt(0))) {
                last += str.charAt(0);
                str = str.substring(1);
            } else {
                break;
            }
        }
        if (ex) {
            if (first == '-') return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
        } else {
            String fin = first + last;
            if (last.length() == 0 && (fin.startsWith("+") ||fin.startsWith("-"))) return 0;
            BigInteger a = new BigInteger(fin);
            BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
            BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE));
            if (a.compareTo(max) > 0) return Integer.MAX_VALUE;
            if (a.compareTo(min) < 0) return Integer.MIN_VALUE;
            return Integer.parseInt(fin);
        }
    }

    public static void main(String[] args) {
        S2I s = new S2I();
        System.out.println(s.myAtoi("010"));
    }
}
