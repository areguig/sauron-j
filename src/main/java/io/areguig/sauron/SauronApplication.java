package io.areguig.sauron;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.system.ApplicationPidFileWriter;

@SpringBootApplication
public class SauronApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder()
				.bannerMode(Banner.Mode.CONSOLE)
				.sources(SauronApplication.class)
				.listeners(new ApplicationPidFileWriter())
				.run(args);

		;
	}
}
