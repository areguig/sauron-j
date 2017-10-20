package io.areguig.sauron.server;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SauronServerApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder()
				.bannerMode(Banner.Mode.CONSOLE)
				.sources(SauronServerApplication.class)
				.listeners(new ApplicationPidFileWriter())
				.run(args);

		;
	}
}
