package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: ArnoFrost
 * @Date: 2020/6/2 20:27
 * @Version 1.0
 */
public class TestData {
    public static void main(String[] args) {
        String s = "06:00";
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date);
    }
}
