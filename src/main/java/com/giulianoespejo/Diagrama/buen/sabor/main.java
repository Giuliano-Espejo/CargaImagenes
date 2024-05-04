package com.giulianoespejo.Diagrama.buen.sabor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class main {

	public static void main(String[] args) {
		SpringApplication.run(main.class, args);
	}

	@Bean
	public CommandLineRunner schedulingRunner() {
		return args -> {
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					String url = "https://example.com"; // Cambia esto por la URL que desees hacer ping
					try {
						InetAddress inetAddress = InetAddress.getByName(url);
						boolean reachable = inetAddress.isReachable(5000); // Timeout de 5 segundos
						if (reachable) {
							System.out.println("Ping a " + url + " exitoso.");
						} else {
							System.out.println("No se pudo hacer ping a " + url + ".");
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
