package applicationstart;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.io.FileUtils;

import dao.ProduitsDAO;
import entites.Produits;

public class IntegrationOpenFoodFacts {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("open-food-facts-jpa");
		
		ProduitsDAO dao = new ProduitsDAO(emf);

		File file = new File("C:/acc/WorkSpace/STS/traitement-fichier-jpa-off/open-food-facts.csv");
		
		
		List<String> lignes;
		try {
			lignes = FileUtils.readLines(file, "UTF-8");
			for (String ligne : lignes) {
				String[] decoupage = ligne.split("\\|");

				Produits p = new Produits(decoupage);
				dao.insert(p);

				System.out.println(ligne);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}