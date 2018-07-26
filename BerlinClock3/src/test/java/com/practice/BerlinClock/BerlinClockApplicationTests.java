package com.practice.BerlinClock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.BerlinClock.BerlinClockApplication;
import com.hcl.BerlinClock.Controller.BerlinClockController;
import com.hcl.BerlinClock.Controller.BerlinClockControllerImpl;
import com.hcl.BerlinClock.Service.BerlinClockServiceImpl;
import com.hcl.BerlinClock.Service.BerlinclockService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BerlinClockApplication.class)
public class BerlinClockApplicationTests {

	@InjectMocks
	BerlinClockController berlinClock = new BerlinClockControllerImpl();

	@InjectMocks
	BerlinclockService berlinClockService = new BerlinClockServiceImpl();

	// Yellow lamp should blink on/off every two seconds
	@Test
	public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
		Assert.assertEquals("Y", berlinClockService.getSeconds(0));
		Assert.assertEquals("O", berlinClockService.getSeconds(1));
		Assert.assertEquals("Y", berlinClockService.getSeconds(2));
		Assert.assertEquals("O", berlinClockService.getSeconds(3));
	}

	// Top hours should light a red lamp for every 5 hours
	@Test
	public void testTopHoursShouldLightRedLampForEvery5Hours() {
		Assert.assertEquals("OOOO", berlinClockService.getTopHours(0));
		Assert.assertEquals("RROO", berlinClockService.getTopHours(13));
		Assert.assertEquals("RRRR", berlinClockService.getTopHours(23));
		Assert.assertEquals("RRRR", berlinClockService.getTopHours(24));
	}

	// Bottom hours should have 4 lamps
	@Test
	public void testBottomHoursShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClockService.getBottomHours(5).length());
	}

	// Berlin Clock it should "result in correct seconds, hours and minutes"
	@Test
	public void testBerlinClockShouldResultInCorrectSecondsHoursAndMinutes() {
		String[] berlinTime = berlinClock.convertToBerlinTime("15:37:16");
		String[] expected = new String[] { "Y", "RRRO", "OOOO", "YYRYYRYOOOO", "YYOO" };
		Assert.assertEquals(expected.length, berlinTime.length);
		for (int index = 0; index < expected.length; index++) {
			Assert.assertEquals(expected[index], berlinTime[index]);
		}
	}

}
