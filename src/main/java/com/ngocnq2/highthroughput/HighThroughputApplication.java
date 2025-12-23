package com.ngocnq2.highthroughput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HighThroughputApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(HighThroughputApplication.class);
    app.setWebApplicationType(WebApplicationType.REACTIVE);
    app.run(args);
  }
}