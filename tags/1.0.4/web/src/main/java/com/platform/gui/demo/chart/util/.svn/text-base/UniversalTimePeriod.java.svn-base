package com.platform.gui.demo.chart.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.jfree.chart.axis.DateTickUnit;
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Second;
import org.jfree.data.time.Year;

public final class UniversalTimePeriod extends RegularTimePeriod implements Serializable {
	private RegularTimePeriod startPeriod = null;

	private RegularTimePeriod endPeriod = null;

	private TimeZone timeZone;

	private int timeCount;

	private int timeUnit;

	public UniversalTimePeriod(Date startTime, int timeCount, int timeUnit) {
		this(startTime.getTime(), timeCount, timeUnit, RegularTimePeriod.DEFAULT_TIME_ZONE);
	}

	public UniversalTimePeriod(long startTime, int timeCount, int timeUnit) {
		this(startTime, timeCount, timeUnit, RegularTimePeriod.DEFAULT_TIME_ZONE);
	}

	public UniversalTimePeriod(long startTime, int timeCount, int timeUnit, TimeZone timeZone) {
		this.timeZone = timeZone;
		this.timeCount = timeCount;
		this.timeUnit = timeUnit;

		switch (this.timeUnit) {
		case DateTickUnit.MILLISECOND:
			this.startPeriod = new Millisecond(new Date(startTime), this.timeZone);
			break;

		case DateTickUnit.SECOND:
			this.startPeriod = new Second(new Date(startTime), this.timeZone);
			break;

		case DateTickUnit.MINUTE:
			this.startPeriod = new Minute(new Date(startTime), this.timeZone);
			break;

		case DateTickUnit.HOUR:
			this.startPeriod = new Hour(new Date(startTime), this.timeZone);
			break;

		case DateTickUnit.DAY:
			this.startPeriod = new Day(new Date(startTime), this.timeZone);
			break;

		case DateTickUnit.MONTH:
			this.startPeriod = new Month(new Date(startTime), this.timeZone);
			break;

		case DateTickUnit.YEAR:
			this.startPeriod = new Year(new Date(startTime), this.timeZone);
			break;
		}

		this.endPeriod = this.startPeriod;
		for (int k = 1; k < this.timeCount; k++) {
			this.endPeriod = this.endPeriod.next();
		}
	}

	public RegularTimePeriod next() {
		return new UniversalTimePeriod(this.endPeriod.next().getFirstMillisecond(), this.timeCount,
				this.timeUnit, this.timeZone);
	}

	public RegularTimePeriod previous() {
		RegularTimePeriod firstPeriod = this.startPeriod;
		for (int k = 0; k < this.timeCount; k++) {
			firstPeriod = firstPeriod.previous();
		}
		return new UniversalTimePeriod(firstPeriod.getFirstMillisecond(), this.timeCount,
				this.timeUnit, this.timeZone);
	}

	public long getSerialIndex() {
		return (long) this.startPeriod.getSerialIndex() / this.timeCount;
	}

	public long getFirstMillisecond(Calendar cal) {
		return this.startPeriod.getFirstMillisecond(cal);
	}

	public long getFirstMillisecond() {
		return this.startPeriod.getFirstMillisecond();
	}

	public long getFirstMillisecond(TimeZone zone) {
		return super.getFirstMillisecond(zone);
	}

	public long getLastMillisecond() {
		return this.endPeriod.getLastMillisecond();
	}

	public long getLastMillisecond(Calendar cal) {
		return this.endPeriod.getLastMillisecond(cal);
	}

	public long getLastMillisecond(TimeZone zone) {
		return this.endPeriod.getLastMillisecond(zone);
	}

	public long getMiddleMillisecond() {
		long firstMillis = this.startPeriod.getFirstMillisecond();
		long lastMillis = this.endPeriod.getLastMillisecond();
		System.out.println("MIDDLE:" + new Date((firstMillis + lastMillis) / 2));
		return (firstMillis + lastMillis) / 2;
	}

	public long getMiddleMillisecond(Calendar cal) {
		long firstMillis = this.startPeriod.getFirstMillisecond(cal);
		long lastMillis = this.endPeriod.getLastMillisecond(cal);
		System.out.println("MIDDLE:" + new Date((firstMillis + lastMillis) / 2));
		return (firstMillis + lastMillis) / 2;
	}

	public long getMiddleMillisecond(TimeZone zone) {
		long firstMillis = this.startPeriod.getFirstMillisecond(zone);
		long lastMillis = this.endPeriod.getLastMillisecond(zone);
		System.out.println("MIDDLE:" + new Date((firstMillis + lastMillis) / 2));
		return (firstMillis + lastMillis) / 2;
	}

	public int compareTo(Object obj) {
		int result;
		
		// Instance of regularTimePeriod
		if (obj instanceof RegularTimePeriod) {
			RegularTimePeriod period = (RegularTimePeriod) obj;
			if (this.getFirstMillisecond() == period.getFirstMillisecond()
					&& this.getLastMillisecond() == period.getLastMillisecond()) {
				result = 0;
			}
			else if (this.getFirstMillisecond() > period.getLastMillisecond()) {
				result = 1;
			}
			else {
				result = -1;
			}
		}

		// Compare to a non-TimePeriod object
		else {
			result = -1;
		}

		return result;
	}

	public boolean equals(Object obj) {
		boolean result;

		// Compare to another UniversalTimePeriod object
		if (obj instanceof RegularTimePeriod) {
			RegularTimePeriod period = (RegularTimePeriod) obj;
			if (this.getFirstMillisecond() == period.getFirstMillisecond()
					&& this.getLastMillisecond() == period.getLastMillisecond()) {
				result = true;
			}
			else {
				result = false;
			}
		}

		// Compare to a non-TimePeriod object
		else {
			result = false;
		}

		return result;
	}

	public int hashCode() {
		return 17 + 37 * (this.startPeriod.hashCode() + this.endPeriod.hashCode()
				+ this.timeZone.hashCode() + this.timeCount + this.timeUnit);
	}
}
