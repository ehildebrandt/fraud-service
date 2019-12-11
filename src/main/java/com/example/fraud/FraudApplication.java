package com.example.fraud;

import com.example.fraud.internal.InternalChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding({FraudChannels.class, InternalChannels.class})
@SpringBootApplication
public class FraudApplication {

	public static void main(String[] args) {
		SpringApplication.run(FraudApplication.class, args);
	}

}
