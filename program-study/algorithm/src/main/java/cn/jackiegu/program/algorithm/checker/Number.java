package cn.jackiegu.program.algorithm.checker;

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

    public boolean lessAndEquals(Number o) {
        return this.num <= o.num;
    }

    public boolean more(Number o) {
        return this.num > o.num;
    }

    public boolean moreAndEquals(Number o) {
        return this.num >= o.num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Number) {
            return this.num == ((Number) o).num;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        char[] charArr = String.valueOf(this.num).toCharArray();
        int hash = 0;
        for(char c : charArr) {
            hash = hash * 131 + c;
        }
        return hash;
    }

    @Override
    public String toString() {
        return Integer.toHexString(hashCode()) + ":" + this.num;
    }
}
