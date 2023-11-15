package com.llyods.talkingclock.service;

import java.util.Map;

/**
 * @author Opeyemi Adeoye
 * @created 10/Nov/2023
 */

public interface TalkingClockService {

	Map<String, String> getTalkingClockValue(String clockDigits);

}
