package pampushko.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@Slf4j
@SpringBootApplication
@EnableAutoConfiguration
public class Bot1Application
{
	
	public static void main(String[] args)
	{
		SpringApplication.run(Bot1Application.class, args);
		ApiContextInitializer.init();
	}
}
