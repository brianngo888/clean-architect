package main.java.com.ngocnq2.highthroughput;

@SpringBootApplication
public class HighThroughputApplication {

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(HighThroughputApplication.class);
    app.setWebApplicationType(WebApplicationType.REACTIVE);
    app.run(args);
  }
}