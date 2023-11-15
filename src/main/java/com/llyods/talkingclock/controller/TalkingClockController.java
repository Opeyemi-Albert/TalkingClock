package com.llyods.talkingclock.controller;

import com.llyods.talkingclock.core.constants.ApiRoute;
import com.llyods.talkingclock.dto.ResponseHandler;
import com.llyods.talkingclock.service.TalkingClockService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Opeyemi Adeoye
 * @created 10/Nov/2023
 */

@RestController
@RequestMapping(path = ApiRoute.API)
@RequiredArgsConstructor
public class TalkingClockController {

	private final TalkingClockService talkingClockService;

	@Operation(description = "Get endpoint for human-friendly time", summary = "This is an endpoint "
			+ "to get human-friendly time from the digital values", responses = {
					@ApiResponse(description = "Success", responseCode = "200"),
					@ApiResponse(description = "Bad Request", responseCode = "400") })
	@GetMapping(value = ApiRoute.DIGITAL_VALUE)
	public ResponseEntity<ResponseHandler> getTalkingClockValue(
			@PathVariable String digits) {
		return ResponseEntity.ok(ResponseHandler.builder().status(HttpStatus.OK)
				.data(talkingClockService.getTalkingClockValue(digits))
				.message("Friendly Time displayed").build());
	}

}
