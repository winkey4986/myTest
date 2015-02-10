package com.myTest.webServiceTest;

/**
 * Created by winkey on 15-1-22.
 */
public class CalculateService {
    /** */
    /**
     * 加法运算
     *
     * @param x 被加数
     * @param y 加数
     * @return x与y的和
     */

    public float plus(float x, float y) {

        return x + y;

    }

    /** */
    /**
     * 减法运算
     *
     * @param x 被减数
     * @param y 减数
     * @return x与y之差
     */

    public float minus(float x, float y) {

        return x - y;

    }

    /** */
    /**
     * 乘法运算
     *
     * @param x 被乘数
     * @param y 乘数
     * @return x与y的乘积
     */

    public float multiply(float x, float y) {

        return x * y;

    }

    /** */
    /**
     * 除法运算
     *
     * @param x 被除数
     * @param y 除数
     * @return x与y的商
     */

    public float divide(float x, float y) {

        return x / y;

    }
}
