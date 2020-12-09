package org.excavator.boot.flightrecorder;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.metrics.jfr.FlightRecorderApplicationStartup;

@SpringBootApplication
public class FlightRecorderApplication {

	public static void main(String[] args) {
	    new SpringApplicationBuilder(FlightRecorderApplication.class)
	        .applicationStartup(new FlightRecorderApplicationStartup())
	        .run(args);
	}

}
