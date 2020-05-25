package ByteDance;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-05-25
 */

public class RandomTen {
    public int rand7(){
        return 0;
    }

    public int rand10() {
        int sum = (rand7() - 1) * 7 + rand7();
        while (sum > 10) {
            sum = (rand7() - 1) * 7 + rand7();
        }
        return sum;
    }
}
