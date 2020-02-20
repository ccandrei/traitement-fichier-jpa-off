package entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUIT")
public class Produits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Categories categorie;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Marques marque;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "GRADE")
	private String grade;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Prod_ing", joinColumns = @JoinColumn(name = "Prod_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Ing_id", referencedColumnName = "id"))
	private List<Ingredients> ingredients = new ArrayList<>();
	// decoupage[29]
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Prod_addit", joinColumns = @JoinColumn(name = "Prod_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Addi_id", referencedColumnName = "id"))
	private List<Additifs> additifs = new ArrayList<>();
	// decoupage[28]
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Prod_allerg", joinColumns = @JoinColumn(name = "Prod_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "Allerg_id", referencedColumnName = "id"))
	private List<Allergenes> allergenes = new ArrayList<>();

	public Produits(String[] decoupage) {
		categorie = new Categories(decoupage[0]);
		marque = new Marques(decoupage[1]);
		nom = decoupage[2];
		grade = decoupage[3];
		
		// traitement decoupage[5] en liste d'ingredients
		String[] listeIng = decoupage[5].split(",");
		for (String i : listeIng) {
			ingredients.add(new Ingredients(i));
		}
		
		if (decoupage.length>=30) {
		String[] listAddit = decoupage[29].split(",");
		for (String addi : listAddit) {
			additifs.add(new Additifs(addi));} 
		} 
		if (decoupage.length>=30) {	
		String[] listAllerg = decoupage[28].split(",");
		for (String allerg : listAllerg) {
			allergenes.add(new Allergenes(allerg));
		}
		}
			
		}
		//categorie|marque|nom|nutritionGradeFr|ingredients|energie100g|graisse100g|sucres100g|fibres100g|proteines100g|sel100g|vitA100g|vitD100g|vitE100g|vitK100g|vitC100g|vitB1100g|vitB2100g|vitPP100g|vitB6100g|vitB9100g|vitB12100g|calcium100g|magnesium100g|iron100g|fer100g|betaCarotene100g|presenceHuilePalme|allergenes|additifs|
		
	}

