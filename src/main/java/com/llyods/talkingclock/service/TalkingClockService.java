package com.llyods.talkingclock.service;

import java.util.Map;

/**
 * @author Opeyemi Adeoye
 * @since 2023-11-10
 */
public interface TalkingClockService {

  Map<String, String> getTalkingClockValue(String clockDigits);
}
