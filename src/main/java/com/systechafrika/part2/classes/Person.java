package com.systechafrika.part2.classes;

import java.util.logging.Logger;

public class Person {

   private static final Logger LOGGER = Logger.getLogger(Person.class.getName());
   String skinColor;
   int age;
   String department;

   public void startEating() {

      LOGGER.info("Eating");
   }

   public void startRunning() {

      LOGGER.info("you are now running");
   }
}
