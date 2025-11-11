package com.llyods.talkingclock.core.constants;

/**
 * @author Opeyemi Adeoye
 * @since 2023-11-10
 */
public class Config {

  public static final String DELIMITER = ":";

  public static final int ROTATION = 12;

  public static final int HALF_PAST_MINUTE = 34;

  public static final int MINUTE_SEQUENCE = 5;

  public static final String[] HOUR_WORDS = {
    "Twelve", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
    "Eleven", "Twelve"
  };

  public static final String[] MINUTE_WORDS = {
    "",
    "Five",
    "Ten",
    "Fifteen",
    "Twenty",
    "Twenty five",
    "Half",
    "Twenty five",
    "Twenty",
    "Fifteen",
    "Ten",
    "Five"
  };
}
