package com.llyods.talkingclock.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponseDto {

	private int statusCode;

	private String status;

	private String message;

	private long timeStamp;

}
