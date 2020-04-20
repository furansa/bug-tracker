package me.furansa.desconstruindo.bugtracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BugtrackerApplication {
	@Value("${app.name}")
    private static String appName;

    @Value("${app.version}")
	private static String appVersion;

	private static final Logger logger = LoggerFactory.getLogger(BugtrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BugtrackerApplication.class, args);

		logger.info("Starting: " + appName + " version: " + appVersion);
	}
}