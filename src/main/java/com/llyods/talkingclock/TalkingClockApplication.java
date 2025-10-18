package com.llyods.talkingclock;

import java.time.LocalDateTime;
import java.util.TimeZone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class TalkingClockApplication {

  public static void main(String[] args) {
    SpringApplication.run(TalkingClockApplication.class, args);
    log.info("\n\n ============================ APPLICATION LAUNCHED ======================= \n\n");
    TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
    System.out.println(LocalDateTime.now());
  }
}
