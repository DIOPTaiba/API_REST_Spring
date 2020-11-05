package sn.simplon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sn.simplon.entities.Pharmacie;
import sn.simplon.pharmaciedao.IPharmacie;

@SpringBootApplication
public class GestionPharmacieApiSpringApplication implements CommandLineRunner {

	@Autowired
	private IPharmacie pharmaciedao;
	public static void main(String[] args) {
		SpringApplication.run(GestionPharmacieApiSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Pharmacie pharmacie = new Pharmacie();
		pharmacie.setNom("Pharmacie Salam");
		pharmacie.setQuartier("Khar Yalla");
		pharmacie.setVille("Grand Yoff");
		pharmacie.setEtat(1);

		//pharmaciedao.save(pharmacie);

		pharmaciedao.findAll().forEach(c -> System.out.println(c.getNom()));

	}
}
