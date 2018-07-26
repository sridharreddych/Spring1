package com.hcl.BerlinClock.Service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class BerlinClockServiceImpl implements BerlinclockService {
	
	

	@Override
	public String getSeconds(int i) {
	
		if (i % 2 == 0) return "Y";
        else return "O";
	}

	@Override
	public String getTopHours(int i) {
		return getOnOff(4, getTopNumberOfOnSigns(i));
	}

	private String getOnOff(int lamps, int onSigns, String onSign) {
		 String out = "";
	        for (int i = 0; i < onSigns; i++) {
	            out += onSign;
	        }
	        for (int i = 0; i < (lamps - onSigns); i++) {
	            out += "O";
	        }
	        return out;
	}
	
	 private String getOnOff(int lamps, int onSigns) {
	        return getOnOff(lamps, onSigns, "R");
	    }

	private int getTopNumberOfOnSigns(int i) {
		 return (i - (i % 5)) / 5;
	}

	@Override
	public String getBottomHours(int i) {
		return getOnOff(4, i % 5);
	}

	@Override
	public String getTopMinutes(int i) {
		 return getOnOff(11, getTopNumberOfOnSigns(i), "Y").replaceAll("YYY", "YYR");
	}

	@Override
	public String getBottomMinutes(int i) {
		return getOnOff(4, i % 5, "Y");
	}

	@Override
	public String[] convertToBerlinTime(String time) {
		int[] parts = Stream.of(time.split(":"))
				.mapToInt(Integer::parseInt)
				.toArray();
		
        return new String[] {
                getSeconds(parts[2]),
                getTopHours(parts[0]),
                getBottomHours(parts[0]),
                getTopMinutes(parts[1]),
                getBottomMinutes(parts[1])
        };
	}

}
