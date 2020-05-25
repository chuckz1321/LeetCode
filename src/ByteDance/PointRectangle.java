package ByteDance;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 功能描述
 *
 * @author z00533892
 * @since 2020-04-10
 */
class PointRectangle {

    LinkedList<Integer> xValue;
    LinkedList<Integer> yValue;
    int square;

    /**
     * 初始化
     */
    public PointRectangle() {
        xValue = new LinkedList<>();
        yValue = new LinkedList<>();
        square = -1;
    }

    /**
     * 加入一个节点
     *
     * @param x 横坐标
     * @param y 纵坐标
     */
    public void push(int x, int y) {
        xValue.add(x);
        yValue.add(y);
        calculate();
    }

    /**
     * 删除一个节点
     *
     * @return 成功0 失败-1
     */
    public int pop() {
        if (xValue.size() > 0) {
            xValue.removeFirst();
            yValue.removeFirst();
            calculate();
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 获取面积
     *
     * @return 获取覆盖的最小面积
     */
    public int get() {
        return square;
    }

    private void calculate() {
        if (xValue.size() <= 1) {
            square = -1;
            return;
        }
        int xMax = Integer.MIN_VALUE;
        int xMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        for (int i = 0; i < xValue.size(); i++) {
            int xTemp = xValue.get(i);
            if (xTemp > xMax) {
                xMax = xTemp;
            }
            if (xTemp < xMin) {
                xMin = xTemp;
            }
        }
        for (int i = 0; i < yValue.size(); i++) {
            int yTemp = yValue.get(i);
            if (yTemp > yMax) {
                yMax = yTemp;
            }
            if (yTemp < yMin) {
                yMin = yTemp;
            }
        }
        if (xMax == xMin || yMax == yMin) {
            square = -1;
        } else {
            square = Math.abs((xMax - xMin) * (yMax - yMin));
        }
    }
}
