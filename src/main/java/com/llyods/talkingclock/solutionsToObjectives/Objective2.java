package com.llyods.talkingclock.solutionsToObjectives;

import com.llyods.talkingclock.service.impl.TalkingClockServiceImpl;
import java.util.Scanner;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Opeyemi Adeoye
 * @created 10/Nov/2023
 */
@Slf4j
@RequiredArgsConstructor
public class Objective2 {

  public static void main(String[] args) {

    Objective2 obj = new Objective2();
    obj.takeNumericTimeInput();
  }

  public void takeNumericTimeInput() {
    // Create a Scanner object to read input from the terminal
    @Cleanup Scanner scanner = new Scanner(System.in);
    boolean exit = false;

    while (!exit) {
      // Prompt the user to enter a numeric time
      System.out.print("Enter a numeric time (HH:MM) or type 'exit' to quit: ");
      // Get input from the command line. Remove all white spaces
      String numericTime = scanner.nextLine().replaceAll("\\s", "");

      if (numericTime.equalsIgnoreCase("exit")) {
        exit = true;
      } else {
        try {
          // Call the method to convert numeric time to human-friendly text
          TalkingClockServiceImpl tcs = new TalkingClockServiceImpl();
          String humanFriendlyText = tcs.convertToHumanFriendlyText(numericTime);
          // Display the result
          System.out.println(numericTime + " " + humanFriendlyText);
        } catch (IllegalArgumentException e) {
          log.error(e.getMessage());
        }
      }
    }
  }
}
