package com.example.web5craper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

public class TimeConverter {
    public static Date convertTime(String time_got) throws ParseException {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime now = ZonedDateTime.now(zoneId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if (time_got.matches("\\d{4}-\\d{2}-\\d{2}")) {
            date = sdf.parse(time_got);
        } else if (time_got.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
            date = sdf.parse(time_got.split(" ")[0]);
        } else if (time_got.contains("小时前") || time_got.contains("分钟前")) {
            date = sdf.parse(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else if (time_got.startsWith("昨天")) {
            date = sdf.parse(now.minus(1, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else if (time_got.contains("天前")) {
            int days = Integer.parseInt(time_got.replace("天前", ""));
            date = sdf.parse(now.minus(days, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else if (time_got.contains("年") && time_got.contains("月")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日").withZone(zoneId);
            LocalDate localDate = LocalDate.parse(time_got, formatter);
            date = sdf.parse(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        } else if (time_got.contains("月") && time_got.contains("日")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M月d日").withZone(zoneId);
            TemporalAccessor accessor = formatter.parse(time_got);
            int month = accessor.get(ChronoField.MONTH_OF_YEAR);
            int day = accessor.get(ChronoField.DAY_OF_MONTH);
            LocalDate localDate = LocalDate.of(now.getYear(), month, day);
            if (localDate.isAfter(now.toLocalDate())) {
                localDate = localDate.withYear(now.getYear() - 1);
            }
            date = sdf.parse(localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        return date;
    }

    public static LocalDate convertToLocalDate(String time_got) throws ParseException {
        Date date = convertTime(time_got);
        if (date == null) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
