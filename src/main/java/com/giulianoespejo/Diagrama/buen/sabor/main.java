package com.giulianoespejo.Diagrama.buen.sabor;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


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
					String host = "cargaimagenes.onrender.com"; // Solo el nombre del host, sin el protocolo
					try {
						InetAddress inetAddress = InetAddress.getByName(host);
						boolean reachable = inetAddress.isReachable(5000); // Timeout de 5 segundos
						if (reachable) {
							logger.error("Ping a {}", host);
							System.out.println("Ping a " + host + " exitoso.");
						} else {
							System.out.println("No se pudo hacer ping a " + host + ".");
						}
					} catch (UnknownHostException e) {
						System.out.println("Host desconocido: " + e.getMessage());
					} catch (IOException e) {
						System.out.println("Error de IO: " + e.getMessage());
					}
				}
			};

			// Programa la tarea para ejecutarse cada 2 horas (7200 segundos)
			timer.schedule(task, 0, 7200 * 1000);
		};
	}

}
