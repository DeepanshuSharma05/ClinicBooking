package com.deepanshu.clinicbooking;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicBookingApplication.class, args);


        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        dotenv.entries().forEach((entry) -> System.setProperty(
                entry.getKey(), entry.getValue()
        ));
    }





}
