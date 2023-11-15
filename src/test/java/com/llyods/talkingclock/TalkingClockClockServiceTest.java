package com.llyods.talkingclock;

import com.llyods.talkingclock.core.exceptions.BadRequestException;
import com.llyods.talkingclock.service.Impl.TalkingClockServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Opeyemi Adeoye
 * @created 13/Nov/2023
 */

@ExtendWith(MockitoExtension.class)
class TalkingClockClockServiceTest {

	@InjectMocks
	private TalkingClockServiceImpl talkingClockService;

	private static final String INVALID_TIME_FORMAT = "1230";

	private static final String OUT_OF_RANGE_HOUR = "24:00";

	private static final String OUT_OF_RANGE_MINUTE = "12:60";

	private static final String FRIENDLY_TEXT = "One o'clock ";

	@Test
	public void testGetTalkingClockValueMethodWithValidInputs() {
		String clockDigits = "01:00";

		Map<String, String> result = talkingClockService
				.getTalkingClockValue(clockDigits);

		assertEquals(1, result.size());
		assertEquals(FRIENDLY_TEXT, result.get(clockDigits));
	}

	@Test
	public void testGetTalkingClockValueMethodWithInValidInputs() {

		assertThrows(IllegalArgumentException.class, () -> {
			talkingClockService.getTalkingClockValue(INVALID_TIME_FORMAT);
		});

	}

	@Test
	void testConvertToHumanFriendlyTextMethodWithValidInput() {

		// Test valid input
		assertEquals("Half past Twelve ",
				talkingClockService.convertToHumanFriendlyText("12:30"));
		assertEquals("One o'clock ",
				talkingClockService.convertToHumanFriendlyText("01:00"));
		assertEquals("Ten to Twelve ",
				talkingClockService.convertToHumanFriendlyText("11:50"));
	}

	@Test
	void testConvertToHumanFriendlyTextMethodWitInvalidInput() {

		// Test with an invalid time format
		assertThrows(IllegalArgumentException.class, () -> {
			talkingClockService.convertToHumanFriendlyText(INVALID_TIME_FORMAT);
		});
	}

	@Test
	void testConvertToHumanFriendlyTextMethodWitOutOfRangeHourInput() {

		// Test with an invalid hour format
		try {
			talkingClockService.convertToHumanFriendlyText(OUT_OF_RANGE_HOUR);
		}
		catch (BadRequestException e) {
			assertEquals("Invalid hour. Hour should be between 0 and 23.",
					e.getMessage());
		}
	}

	@Test
	void testConvertToHumanFriendlyTextMethodWitOutOfRangeMinuteInput() {

		// Test with an invalid minute format
		assertThrows(BadRequestException.class, () -> {
			talkingClockService.convertToHumanFriendlyText(OUT_OF_RANGE_MINUTE);
		});
	}

}
