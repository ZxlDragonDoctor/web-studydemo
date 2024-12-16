package com.zxl.webspringmvc.webspringmvc.tools;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自增
 */
public class SequenceGenerator {
    //TODO:缺点：每次项目重启又要从0开始自增，导致添加不上去已占id的数据
    private static final AtomicInteger seq = new AtomicInteger(0);


    //自增方法
    public static int getNextSequence() {
        return seq.incrementAndGet();
    }
}
