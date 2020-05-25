package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-10
 */
public class third {
    int variable = 0;
    int digit = 0;

    /**
     * 求解一元一次方程
     *
     * @param equation 一元一次方程字符串
     * @return 一元一次方程解
     */
    public double solve(String equation) {
        int equationIndex = equation.indexOf('=');
        helper(equation.substring(0, equationIndex), true);
        helper(equation.substring(equationIndex + 1), false);
        return (double) digit / (double) variable;
    }

    /**
     * 分别处理等式两边的算式
     *
     * @param equation 等式两边算式
     * @param isLeft 区分左右 用作加减号处理
     */
    private void helper(String equation, boolean isLeft) {
        int sign = 1;
        int tmpDigit = -1;
        equation += "+";
        for (int i = 0; i < equation.length(); ++i) {
            if (equation.charAt(i) == '-' || equation.charAt(i) == '+') {
                tmpDigit = (tmpDigit == -1) ? 0 : (tmpDigit * sign);
                this.digit += isLeft ? -tmpDigit : tmpDigit;
                tmpDigit = -1;
                sign = (equation.charAt(i) == '+') ? 1 : -1;
            } else if (equation.charAt(i) >= '0' && equation.charAt(i) <= '9') {
                if (tmpDigit == -1) {
                    tmpDigit = 0;
                }
                tmpDigit = tmpDigit * 10 + equation.charAt(i) - '0';
            } else if (Character.isAlphabetic(equation.charAt(i))) {
                tmpDigit = (tmpDigit == -1) ? sign : (tmpDigit * sign);
                variable += isLeft ? tmpDigit : -tmpDigit;
                tmpDigit = -1;
            }
        }
    }
}
