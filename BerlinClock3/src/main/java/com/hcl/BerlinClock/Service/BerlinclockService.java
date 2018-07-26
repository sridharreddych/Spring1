package com.hcl.BerlinClock.Service;

public interface BerlinclockService {

	String getSeconds(int i);

	String getTopHours(int i);

	String getBottomHours(int i);

	String getTopMinutes(int i);

	String getBottomMinutes(int i);

	String[] convertToBerlinTime(String string);

}
