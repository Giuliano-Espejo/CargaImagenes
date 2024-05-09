package com.giulianoespejo.Diagrama.buen.sabor;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

@SpringBootApplication
public class main {

	public static void main(String[] args) {
		SpringApplication.run(main.class, args);
	}

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(main.class);


	@Bean
	public CommandLineRunner schedulingRunner() {
		return args -> {
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					String url = "https://buensaborback.onrender.com/empresa";
					RestTemplate restTemplate = new RestTemplate();
					ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
					if (response.getStatusCode().is2xxSuccessful()) {
						logger.info("GET a {} exitoso", url);
					} else {
						logger.info("GET a {} fallido", url);
					}
				}
			};

			// Programa la tarea para ejecutarse cada 2 horas (7200 segundos)
			timer.schedule(task, 0, 150 * 1000);
		};
	}
}
