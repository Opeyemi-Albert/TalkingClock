package com.llyods.talkingclock.service.impl;

import com.llyods.talkingclock.core.constants.MessageConstants;
import com.llyods.talkingclock.core.exceptions.BadRequestException;
import com.llyods.talkingclock.model.Direction;
import com.llyods.talkingclock.service.TalkingClockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.llyods.talkingclock.core.constants.Config.*;

/**
 * @author Opeyemi Adeoye
 * @created 10/Nov/2023
 */

@Service
@Slf4j
public class TalkingClockServiceImpl implements TalkingClockService {

	@Override
	public Map<String, String> getTalkingClockValue(String clockDigits) {

		Map<String, String> resultMap = new HashMap<>();

		if (clockDigits != null) {
			String humanFriendlyText = convertToHumanFriendlyText(clockDigits);
			resultMap.put(clockDigits, humanFriendlyText);
		}
		return resultMap;
	}

	public String convertToHumanFriendlyText(String time) {

		if (!time.contains(DELIMITER)) {
			throw new IllegalArgumentException(MessageConstants.WRONG_TIME_FORMAT);
		}

		String[] partTime = time.split(DELIMITER);
		int extractedHour = Integer.parseInt(partTime[0]);
		int minute = Integer.parseInt((partTime[1]));

		validateTime(extractedHour, minute);

		extractedHour = (extractedHour > ROTATION) ? extractedHour - ROTATION
				: extractedHour;

		// Handling edge case
		if (extractedHour == 12) {
			extractedHour = 0;
		}

		if (minute == 0) {
			return String.format("%s o'clock ", HOUR_WORDS[extractedHour]);
		}
		else {
			String clockDirection = (minute <= HALF_PAST_MINUTE)
					? String.valueOf(Direction.past) : String.valueOf(Direction.to);
			return String.format("%s %s %s ", MINUTE_WORDS[minute / MINUTE_SEQUENCE],
					clockDirection, HOUR_WORDS[extractedHour + (minute <= 30 ? 0 : 1)]);
		}
	}

	public void validateTime(int hour, int minute) {
		if (hour < 0 || hour > 23) {
			throw new BadRequestException(MessageConstants.HOUR_NOT_VALID);
		}
		if (minute < 0 || minute > 59) {
			throw new BadRequestException(MessageConstants.MINUTE_NOT_VALID);
		}
	}

}
