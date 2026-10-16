package com.act21.rule.engine.dsl.expression.runtime;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class HelperFunctions {

	public static String convertToString(Object obj) {
		if (obj instanceof Long) {
			return String.valueOf(obj);
		}
		if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj).toPlainString();
		}
		if (obj instanceof String) {
			return (String) obj;
		}
		return null;
	}

	public static BigDecimal add(BigDecimal o1, BigDecimal o2) {
		return o1.add(o2);
	}

	public static Long add(Long o1, Long o2) {
		return o1 + o2;
	}

	public static String add(String o1, String o2) {
		return o1 + o2;
	}

	public static BigInteger add(BigInteger o1, BigInteger o2) {
		return o1.add(o2);
	}

	public static BigDecimal subtract(BigDecimal o1, BigDecimal o2) {
		return o1.subtract(o2);
	}

	public static Long subtract(Long o1, Long o2) {
		return o1 - o2;
	}

	public static BigInteger subtract(BigInteger o1, BigInteger o2) {
		return o1.subtract(o2);
	}

	public static Long modulo(Long o1, Long o2) {
		return o1 % o2;
	}

	public static BigInteger modulo(BigInteger o1, BigInteger o2) {
		return o1.remainder(o2);
	}

	public static BigDecimal multiply(BigDecimal o1, BigDecimal o2) {
		return o1.multiply(o2);
	}

	public static Long multiply(Long o1, Long o2) {
		return o1 * o2;
	}

	public static BigInteger multiply(BigInteger o1, BigInteger o2) {
		return o1.multiply(o2);
	}

	public static BigDecimal divide(BigDecimal o1, BigDecimal o2) {
		return o1.divide(o2, 20, RoundingMode.HALF_UP);
	}

	public static BigDecimal divide(Long o1, Long o2) {
		return divide(BigDecimal.valueOf(o1), BigDecimal.valueOf(o2));
	}

	public static BigDecimal divide(BigInteger o1, BigInteger o2) {
		return divide(new BigDecimal(o1), new BigDecimal(o2));
	}

	public static Integer convertToInt(Object obj) {
		if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj).intValue();
		}
		if (obj instanceof String) {
			return Integer.parseInt((String) obj);
		}
		if (obj instanceof Long) {
			return (Integer) obj;
		}

		return null;
	}

	public static BigDecimal convertToBigDecimal(Object obj) {
		if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj);
		}
		if (obj instanceof String) {
			return new BigDecimal((String) obj);
		}
		if (obj instanceof Long) {
			return new BigDecimal(obj.toString());
		}
		return null;
	}

	public static Date convertToDate(String dateStr) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException("Unable to parse string into Date");
		}
	}

	public static BigDecimal negate(BigDecimal val) {
		return val.negate();
	}

	public static BigInteger negate(BigInteger val) {
		return val.negate();
	}

	public static Long negate(Long val) {
		return -val;
	}

	public static Integer negate(Integer val) {
		return -val;
	}

	public static <T extends Comparable<T>> boolean greater(T o1, T o2) {
		return compareTo(o1, o2) > 0;
	}

	public static <T extends Comparable<T>> boolean smaller(T o1, T o2) {
		return compareTo(o1, o2) < 0;
	}

	public static <T extends Comparable<T>> boolean greaterEqual(T o1, T o2) {
		return compareTo(o1, o2) >= 0;
	}

	public static <T extends Comparable<T>> boolean smallerEqual(T o1, T o2) {
		return compareTo(o1, o2) <= 0;
	}

	public static <T extends Comparable<T>> Integer compareTo(T o1, T o2) {
		if (o1 == o2) {
			return 0;
		}
		if (o1 instanceof BigDecimal && o2 instanceof Long) {
			BigDecimal decimalObj = (BigDecimal) o1;
			Long longObj = (Long) o2;
			return decimalObj.compareTo(convertToBigDecimal(longObj));
		}
		if (o1 instanceof Long && o2 instanceof BigDecimal) {
			Long longObj = (Long) o1;
			BigDecimal decimalObj = ((BigDecimal) o2);
			return convertToBigDecimal(longObj).compareTo(decimalObj);
		}
		return o1.compareTo(o2);
	}

	public static boolean equals(Object o1, Object o2) {
		if (o1 == o2) {
			return true;
		}
		if (o1 instanceof BigDecimal && o2 instanceof BigDecimal) {
			return compareTo((BigDecimal) o1, (BigDecimal) o2) == 0;
		}
		return Objects.equals(o1, o2);
	}

	public static boolean notEquals(Object o1, Object o2) {
		if (o1 instanceof BigDecimal && o2 instanceof BigDecimal) {
			return ((BigDecimal) o1).compareTo((BigDecimal) o2) != 0;
		}
		return !equals(o1, o2);
	}

	public static boolean equalsIgnoreCase(String o1, String o2) {
		return o1.equalsIgnoreCase(o2);
	}

	public static boolean in(Object param, Object... possibleValues) {
		if (param == null || possibleValues == null) {
			return false;
		}

		for (Object v : possibleValues) {
			if (param.equals(v))
				return true;
		}
		return false;
	}

	public static <T> List<T> addAll(List<T> list, T... values) {
		if (values != null && values.length > 0) {
			Collections.addAll(list, values);
		}
		return list;
	}

	/** Append a list-valued output; a function may already have modified and returned the target. */
	public static <T> List<T> appendList(List<T> target, List<? extends T> values) {
		if (target == null) {
			target = new ArrayList<>();
		}
		if (values != null && target != values) {
			target.addAll(values);
		}
		return target;
	}

	public static boolean contains(String val, String... candidates) {
		if (val == null || candidates == null) {
			return false;
		}

		for (String c : candidates) {
			if (val.toLowerCase().contains(c.toLowerCase())) {
				return true;
			}
		}

		return false;
	}

	public static <T extends Comparable<T>> T min(T... args) {
		if (args == null || args.length == 0) {
			throw new IllegalArgumentException("At least one argument is required");
		}

		T min = args[0];
		for (T arg : args) {
			Objects.requireNonNull(arg, "Null values are not supported");
			min = compareTo(arg, min) < 0 ? arg : min;
		}
		return min;
	}

	public static <T extends Comparable<T>> T max(T... args) {
		if (args == null || args.length == 0) {
			throw new IllegalArgumentException("At least one argument is required");
		}

		T max = args[0];
		for (T arg : args) {
			Objects.requireNonNull(arg, "Null values are not supported");
			max = compareTo(arg, max) > 0 ? arg : max;

		}
		return max;
	}

	public static <T extends Number> BigDecimal avg(T... args) {
		if (args == null || args.length == 0) {
			return BigDecimal.ZERO;
		}
		BigDecimal sum = BigDecimal.ZERO;
		for (T number : args) {
			if (number == null) {
				continue;
			}
			sum = sum.add(convertToBigDecimal(number));
		}
		return sum.divide(BigDecimal.valueOf(args.length), 2, RoundingMode.HALF_UP);
	}

	public static Long diffDays(Date date1, Date date2) {
		LocalDate d1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate d2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return ChronoUnit.DAYS.between(d2, d1);
	}

}
