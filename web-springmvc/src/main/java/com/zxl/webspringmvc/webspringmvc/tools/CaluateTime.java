package com.zxl.webspringmvc.webspringmvc.tools;


import java.sql.Date;
import java.util.Calendar;


public class CaluateTime {
    // 根据当前日期和年龄计算出生日期
    public static Date calculateBirthday(int age) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int birthYear = currentYear - age;

        // 设置出生日期，这里假设出生月份和日期为1月1日
        // 如果有具体的月份和日期，可以替换这里的1和1
        calendar.set(birthYear, Calendar.JANUARY, 1);
        java.util.Date utilDate = calendar.getTime();
        long time = utilDate.getTime();
        Date date = new Date(time);
        return date ;
    }

}
