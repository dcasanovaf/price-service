package com.casanova.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Price application.
 */
@SpringBootApplication(scanBasePackages = "com.casanova.price")
public class PriceApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(PriceApplication.class, args);
  }

}
