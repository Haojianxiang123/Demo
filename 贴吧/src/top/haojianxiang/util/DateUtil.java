package top.haojianxiang.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 郝健祥
 * @Date 2019-11-18 21:25
 * @Description 日期格式转换工具类
 * @Version 1.0
 */
public class DateUtil {
    public static String dateFormat(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
        String format = simpleDateFormat.format(date);
        return format;
    }
}
