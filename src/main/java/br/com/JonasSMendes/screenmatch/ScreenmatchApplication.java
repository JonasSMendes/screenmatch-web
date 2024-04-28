package br.com.JonasSMendes.screenmatch;

import br.com.JonasSMendes.model.DadosSerie;
import br.com.JonasSMendes.service.ConsumoApi;
import br.com.JonasSMendes.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=5774020");
		System.out.println(json);

		var conversor = new ConverteDados();
		DadosSerie dados = conversor.obterdados(json,DadosSerie.class);
		System.out.println(dados);
	}

}