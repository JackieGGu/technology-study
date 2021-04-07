package cn.jackiegu.algorithm.study.sort;

/**
 * 数字封装类
 *
 * @author JackieGu
 * @date 2021/4/1
 */
public class Number {

    private final int num;

    public Number(int num) {
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }

    public boolean less(Number o) {
        return this.num < o.num;
    }

    public boolean more(Number o) {
        return this.num > o.num;
    }

    public boolean equals(Number o) {
        return this.num == o.num;
    }

    @Override
    public String toString() {
        return Integer.toHexString(hashCode()) + ":" + this.num;
    }
}
