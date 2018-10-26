package com.wjy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/*
 * 日期工具类
 */
public class DateUtil {

	/**
	 * 获取本天某时
	 * 
	 * @param hour
	 *            时
	 * @return
	 * @throws Exception
	 */
	public static Date getHourByHour(int hour) throws Exception {

		if (hour < 0 || hour > 24) {
			throw new Exception("时有误！！！");
		}

		return DateTime.parse(DateTime.now().toString("yyyy-MM-dd")).hourOfDay().setCopy(hour).toDate();

	}

	/**
	 * 获取本周某天
	 * 
	 * @param day
	 *            星期
	 * @return
	 * @throws Exception
	 */
	public static Date getWeekByWeek(int day) throws Exception {

		if (day < 1 || day > 7) {
			throw new Exception("周有误！！！");
		}

		return DateTime.parse(DateTime.now().toString("yyyy-MM-dd")).dayOfWeek().setCopy(day).toDate();

	}

	/**
	 * 获取之前的日期
	 * 
	 * @param years
	 * @param months
	 * @param weeks
	 * @param days
	 * @param hours
	 * @param minutes
	 * @param millis
	 * @return
	 */
	public static Date getAfterDate(int years, int months, int weeks, int days, int hours, int minutes, int millis) {

		return DateTime.now().plusYears(years).plusMonths(months).plusWeeks(weeks).plusDays(days).plusHours(hours)
				.plusMinutes(minutes).plusMillis(millis).toDate();

	}

	/**
	 * 获取之后的日期
	 * 
	 * @param years
	 * @param months
	 * @param weeks
	 * @param days
	 * @param hours
	 * @param minutes
	 * @param millis
	 * @return
	 */
	public static Date getBeforeDate(int years, int months, int weeks, int days, int hours, int minutes, int millis) {

		return DateTime.now().minusYears(years).minusMonths(months).minusWeeks(weeks).minusDays(days).minusHours(hours)
				.minusMinutes(minutes).minusMillis(millis).toDate();

	}

	/**
	 * 获取间隔天数
	 * 
	 * @param dateString1
	 * @param dateString2
	 * @return
	 * @throws Exception
	 */
	public static int getDays(String dateString1, String dateString2) throws Exception {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Period period = new Period(simpleDateFormat.parse(dateString1).getTime(),
				simpleDateFormat.parse(dateString2).getTime(), PeriodType.days());

		return period.getDays();

	}

	/**
	 * 获取状态
	 * 
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public static String getPeriod(String dateString) throws Exception {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = simpleDateFormat.parse(dateString);

		DateTime dateTime = new DateTime(date);

		long startInstant = date.getTime();
		long endInstant = DateTime.now().getMillis();

		if (startInstant > endInstant) {
			throw new Exception("时间有误！！！");
		}

		Period period = new Period(startInstant, endInstant);

		int periodYears = period.getYears();
		int periodMonths = period.getMonths();
		int periodWeeks = period.getWeeks();
		int periodDays = period.getDays();
		int periodHours = period.getHours();
		int periodMinutes = period.getMinutes();
		int periodSeconds = period.getSeconds();

		String msg;

		if (periodYears != 0 || periodMonths != 0 || periodWeeks != 0 || periodDays > 2) {

			msg = dateTime.toString("yyyy-MM-dd");

		} else if (periodDays == 2) {

			msg = "前天";

		} else if (periodDays == 1) {

			msg = "昨天";

		} else if (periodHours != 0) {

			msg = periodHours + "时前";

		} else if (periodMinutes != 0) {

			msg = periodMinutes + "分前";

		} else if (periodSeconds != 0 && periodSeconds > 10) {

			msg = periodSeconds + "秒前";

		} else {

			msg = "刚刚";

		}

		return msg;

	}

	// public static String getPeriod(String dateString) throws Exception {
	//
	// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd
	// HH:mm:ss");
	//
	// Date date = simpleDateFormat.parse(dateString);
	//
	// long startInstant = date.getTime();
	// long endInstant = DateTime.now().getMillis();
	//
	// if (startInstant > endInstant) {
	// throw new Exception("时间有误！！！");
	// }
	//
	// Period period = new Period(startInstant, endInstant);
	//
	// int periodYears = period.getYears();
	// int periodMonths = period.getMonths();
	// int periodWeeks = period.getWeeks();
	// int periodDays = period.getDays();
	// int periodHours = period.getHours();
	// int periodMinutes = period.getMinutes();
	// int periodSeconds = period.getSeconds();
	//
	// String msg;
	//
	// if (periodYears != 0) {
	//
	// msg = periodYears + "年前";
	//
	// } else if (periodMonths != 0) {
	//
	// msg = periodMonths + "月前";
	//
	// } else if (periodWeeks != 0) {
	//
	// msg = periodWeeks + "周前";
	//
	// } else if (periodDays != 0) {
	//
	// msg = periodDays + "天前";
	//
	// } else if (periodHours != 0) {
	//
	// msg = periodHours + "时前";
	//
	// } else if (periodMinutes != 0) {
	//
	// msg = periodMinutes + "分前";
	//
	// } else if (periodSeconds != 0) {
	//
	// msg = periodSeconds + "秒前";
	//
	// } else {
	//
	// msg = "刚刚";
	//
	// }
	//
	// return msg;
	//
	// }

}
