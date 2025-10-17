package com.llyods.talkingclock.solutionsToObjectives;

import com.llyods.talkingclock.service.impl.TalkingClockServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Opeyemi Adeoye
 * @created 10/Nov/2023
 */

@Configuration
@RequiredArgsConstructor
@Slf4j
public class Objective1 {

	private final TalkingClockServiceImpl talkingClockService;

	private String[] talkingTimes;

	@PostConstruct
	public void loadTalkingTimes() {
		// Store the values in a string array
		talkingTimes = new String[] { "00:00", "02:00", "13:00", "13:05", "13:10",
				"13:25", "13:30", "13:35", "12:30", "23:40" };
	}

	public void returnHumanFriendlyTexts() {

		// Display the human-Friendly Text
		for (String talkingTime : talkingTimes) {
			System.out.println(talkingTime + ": "
					+ talkingClockService.convertToHumanFriendlyText(talkingTime));
		}
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {
			try {
				returnHumanFriendlyTexts();
			}
			catch (IllegalArgumentException e) {
				log.error(e.getMessage());
			}
		};
	}

}
