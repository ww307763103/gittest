package com.example.security;

import com.example.security.model.GamePlayer;
import com.example.security.model.GamePlayerPoxy;
import com.example.security.model.IGamePlayer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author DELL
 * @since 1.0.0
 */
public class Test {
    @org.junit.Test
    public void test() throws Exception {
        /*GamePlayerPoxy zhangsan = new GamePlayerPoxy("zhangsan");
        zhangsan.killBoss();
        zhangsan.upgrade();*/

        /*GamePlayer zhangsan1 = new GamePlayer("zhangsan");
        zhangsan1.killBoss();
        zhangsan1.upgrade();*/
        /*IGamePlayer poxy = zhangsan1.getPoxy();
        poxy.killBoss();
        poxy.upgrade();*/

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        new ConcurrentHashMap<>();
        /*calendar.add(Calendar.DATE, -1);
        Date time2 = calendar.getTime();
        System.out.println(time.before(time2));
        System.out.println(time.after(time2));
        String format = simpleDateFormat.format(time);
        String format1 = simpleDateFormat.format(time2);
        System.out.println(format);
        System.out.println(format1);*/

    }
}