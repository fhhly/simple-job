package simple.job.common.utils;

import lombok.Data;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * description: add a description
 *
 * @author 方浩
 * @version 1.0.0
 * @date 2023/06/05 10:19:42
 */
public class DateUtils {
    public static String ONLY_YEAR = "yyyy";
    public static String YEAR_MONTH = "yyyy-MM";
    public static String ONLY_DATE = "yyyy-MM-dd";
    public static String DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static String ONLY_TIME = "HH:mm:ss";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前季度第一天
     * 默认返回第一季度第一天
     *
     * @return
     */
    public static LocalDate getCurrentQuarterFirstDay() {
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        if (1 <= currentMonth && currentMonth <= 3) {
            return LocalDate.of(now.getYear(), 1, 1);
        } else if (4 <= currentMonth && currentMonth <= 6) {
            return LocalDate.of(now.getYear(), 4, 1);
        } else if (7 <= currentMonth && currentMonth <= 9) {
            return LocalDate.of(now.getYear(), 7, 1);
        } else if (10 <= currentMonth && currentMonth <= 12) {
            return LocalDate.of(now.getYear(), 10, 1);
        }
//        默认返回第一季度第一天
        return LocalDate.of(now.getYear(), 1, 1);
    }

    /**
     * 获取当前季度最后一天
     * 默认返回第一季度最后一天
     *
     * @return
     */
    public static LocalDate getCurrentQuarterEndDay() {
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        if (1 <= currentMonth && currentMonth <= 3) {
            return LocalDate.of(now.getYear(), 4, 1).minusDays(1);
        } else if (4 <= currentMonth && currentMonth <= 6) {
            return LocalDate.of(now.getYear(), 7, 1).minusDays(1);
        } else if (7 <= currentMonth && currentMonth <= 9) {
            return LocalDate.of(now.getYear(), 10, 1).minusDays(1);
        } else if (10 <= currentMonth && currentMonth <= 12) {
            return LocalDate.of(now.plusYears(1).getYear(), 1, 1).minusDays(1);
        }
//        默认返回第一季度最后一天
        return LocalDate.of(now.getYear(), 4, 1).minusDays(1);
    }

    /**
     * 获取当前年第一天
     *
     * @return
     */
    public static LocalDate getCurrentYearFirstDay() {
        return LocalDate.now().withDayOfYear(1);
    }

    /**
     * 获取当前年最后一天
     *
     * @return
     */
    public static LocalDate getCurrentYearEndDay() {
        return LocalDate.now().withDayOfYear(1).plusYears(1).minusDays(1);
    }

    /**
     * 获取当前周第一天
     *
     * @return
     */
    public static LocalDate getCurrentWeekFirstDay() {
        return LocalDate.now().minusDays(LocalDate.now().getDayOfWeek().getValue() - 1);
    }

    /**
     * 获取当前周最后一天
     *
     * @return
     */
    public static LocalDate getCurrentWeekEndDay() {
        return LocalDate.now().plusDays(7 - LocalDate.now().getDayOfWeek().getValue());
    }

    public static String formatString(String pendingData) {
        Date afterParseDate;
        try {
            SimpleDateFormat onlyDateFormat = new SimpleDateFormat(DATE_TIME);
            afterParseDate = onlyDateFormat.parse(pendingData);
            return onlyDateFormat.format(afterParseDate);
        } catch (Exception e) {
            try {
                SimpleDateFormat onlyDateFormat = new SimpleDateFormat(ONLY_DATE);
                afterParseDate = onlyDateFormat.parse(pendingData);
                return onlyDateFormat.format(afterParseDate);
            } catch (Exception e1) {
                try {
                    SimpleDateFormat onlyDateFormat = new SimpleDateFormat(YEAR_MONTH);
                    afterParseDate = onlyDateFormat.parse(pendingData);
                    return onlyDateFormat.format(afterParseDate);
                } catch (Exception e3) {
                    try {
                        SimpleDateFormat onlyDateFormat = new SimpleDateFormat(ONLY_YEAR);
                        afterParseDate = onlyDateFormat.parse(pendingData);
                        return onlyDateFormat.format(afterParseDate);
                    } catch (Exception e2) {
                        return "";
                    }
                }
            }
        }
    }


    public static String strToDateFunction(String dateStr) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME);
            simpleDateFormat.parse(dateStr);
            return "TO_DATE('" + dateStr + "', 'yyyy-mm-dd hh24:mi:ss')";
        } catch (Exception e) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ONLY_DATE);
                simpleDateFormat.parse(dateStr);
                return "TO_DATE('" + dateStr + "', 'yyyy-mm-dd hh24:mi:ss')";
            } catch (Exception e1) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEAR_MONTH);
                    simpleDateFormat.parse(dateStr);
                    return "TO_DATE('" + dateStr + "', 'yyyy-mm-dd hh24:mi:ss')";
                } catch (Exception e3) {
                    return new StringBuilder().append("'").append(dateStr).append("'").toString();
                }
            }
        }
    }


    public static LocalDate dateToLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime dateToLocalDateTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date localDateTimeToDate(LocalDateTime date){
        return Date.from(date.atZone( ZoneId.systemDefault()).toInstant());
    }

    /**
     * 判断日期是否都在同一天
     * @author 方浩
     * @date 2022/8/18 11:44
     * @version 1.0.0
     * @param dates 日期数组
     * @return true 均在同一天 false 有不在同一天的日期
     */
    public static boolean isSameDay(Date... dates) {
        if (dates.length <= 1){
            return true;
        }
        if (!ObjectUtils.allNotNull(dates)){
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(dates[0]);
        for (int i = 1; i < dates.length; i++) {
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(dates[i]);
            if (!isSameDay(cal1, cal2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSameDay(Calendar cal1, Calendar cal2) {
        return cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取日期的年月日返回用-隔开 例如2022-08-18
     * @author 方浩
     * @date 2022/8/18 11:43
     * @version 1.0.0
     * @param date 日期
     * @return 日期的年月日返回用-隔开 例如2022-08-18
     */
    public static String getYearMonthDay(Date date) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(cal1.get(Calendar.YEAR)).append("-").append(cal1.get(Calendar.MONTH)).append("-").append(cal1.get(Calendar.DATE)).toString();
    }

    /**
     * 格式化日期为yyyy-MM-dd HH:mm:ss格式字符串
     * @author 方浩
     * @date 2022/8/19 10:30
     * @version 1.0.0
     * @param date 日期
     */
    public static String dateToString(Date date){
        return dateToString(date, dateTimeFormatter);
    }

    public static String dateToString(Date date, DateTimeFormatter formatter){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return formatter.format(localDateTime);
    }

    public static String dateToString(Date date, String formatter){
        DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern(formatter);
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return simpleDateFormat.format(localDateTime);
    }

    public static boolean isEmpty(String object) {
        if (object == null) {
            object = "";
        }
        return object.length() == 0;
    }

    public static String formatDate(String date) {
        if (date != null) {
            date = date.replace("/", "").replace(":", "").replace(" ", "").replace("-", "");
        } else {
            date = "";
        }
        return date;
    }

    /**
     * 计算一天除去某个时间段还剩余的时间
     * @author 小浩
     * @param  timeSlots 多个时间段集合
     * @return  Long 剩余的时间
     * @date 2022/8/20 17:29
     */
    public static int getRemainTime(List<TimeSlot> timeSlots){
        long oneDaySecond = 86400L;
        for (TimeSlot timeSlot : timeSlots) {
            Duration between = Duration.between(dateToLocalDateTime(timeSlot.beginTime), dateToLocalDateTime(timeSlot.endTime));
            oneDaySecond -= between.getSeconds();
        }
        return BigDecimal.valueOf(oneDaySecond).divide(BigDecimal.valueOf(60), BigDecimal.ROUND_HALF_UP).intValue();
    }

    public static int getRemainTime(Date beginDate, List<TimeSlot> timeSlots){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        long oneDaySecond = Duration.between(dateToLocalDateTime(beginDate), dateToLocalDateTime(calendar.getTime())).getSeconds();
        for (TimeSlot timeSlot : timeSlots) {
            Duration between = Duration.between(dateToLocalDateTime(timeSlot.beginTime), dateToLocalDateTime(timeSlot.endTime));
            oneDaySecond -= between.getSeconds();
        }
        return BigDecimal.valueOf(oneDaySecond).divide(BigDecimal.valueOf(60), BigDecimal.ROUND_HALF_UP).intValue();
    }

    /**
     * 获取时间段的总时间
     * @author 方浩
     * @date 2022/8/24 9:51
     * @version 1.0.0
     * @param timeSlots 时间段
     * @return int 小时
     */
    public static int getTimeSlotsTime(List<TimeSlot> timeSlots){
        int totalSecond = 0;
        for (TimeSlot timeSlot : timeSlots) {
            Duration between = Duration.between(dateToLocalDateTime(timeSlot.beginTime), dateToLocalDateTime(timeSlot.endTime));
            totalSecond += between.getSeconds();
        }
        return BigDecimal.valueOf(totalSecond).divide(BigDecimal.valueOf(60), BigDecimal.ROUND_HALF_UP).intValue();
    }

    @Data
    public static class TimeSlot{
        private Date beginTime;

        private Date endTime;
    }

    public static Date strToDate(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(time);
    }

    public static Date strToDate(String time, String format) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(time);
    }

    /**
     * 获取两个日期相隔的天数
     * @author 小浩
     * @param beginDate 开始日期
     * @param endDate 结束日期
     * @return 相隔天数
     * @date 2022/8/20 22:22
     */
    public static int daysBetween(Date beginDate, Date endDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(beginDate);
        long start = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long end = calendar.getTimeInMillis();
        return BigDecimal.valueOf(Math.abs(end-start)).divide(BigDecimal.valueOf(1000*3600*24), BigDecimal.ROUND_HALF_UP).intValue();
    }

    /**
     * 获取当前日期是周几
     * @author 小浩
     * @param
     * @return
     * @date 2022/8/21 10:53
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
}
