package com.hvdomingues.DinnerApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Essa anotação faz com que o Spring use sua configuração default,
 * ele irá apenas ler e interpretar as anotações do mesmo pacote e dos subPacotes.
 * Não esquecer disso, passei o dia todo tentando descobrir o erro, que foi deixar essa classe no pacote
 * "*.DinnerApp.application" 
*/
@SpringBootApplication
public class DinnerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinnerAppApplication.class, args);



	}

}
