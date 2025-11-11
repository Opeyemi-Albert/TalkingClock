package com.llyods.talkingclock.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.http.HttpStatus;

/**
 * @author Opeyemi Adeoye
 * @since 2023-11-10
 */
@Builder
public class ResponseHandler {

  @JsonProperty("status")
  private HttpStatus status;

  @JsonProperty("data")
  private Object data;

  @JsonProperty("message")
  private String message;
}
