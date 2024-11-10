package com.lotissacayan.roomservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.lotissacayan.roomservice","com.lotissacayan.bookingservice"})
public class RoomServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(RoomServiceApplication.class, args);
	}

}
