package com.llyods.talkingclock;

import com.llyods.talkingclock.core.constants.ApiRoute;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Opeyemi Adeoye
 * @created 13/Nov/2023
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TalkingClockControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldGetTheHumanFriendlyVersionOfTheDigitalClock() throws Exception {
		String digitalClock = "/12:30";

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get(ApiRoute.API + digitalClock))
				.andExpect(status().isOk()).andDo(print()).andReturn();

		assertNotNull(result.getResponse().getContentAsString());
	}

	@Test
	public void shouldNotGetTheHumanFriendlyVersionOfTheDigitalClock() throws Exception {
		String digitalClock = "/1230";

		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get(ApiRoute.API + digitalClock))
				.andExpect(status().isBadRequest()).andDo(print()).andReturn();

		assertNotNull(result.getResponse().getContentAsString());

	}

}
