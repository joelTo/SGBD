package fr.ihm.action;

import java.sql.SQLException;
import java.util.stream.Stream;

import fr.exception.UpdatesPizzaException;
import fr.ihm.IhmUtil;
import fr.model.CategoriePizza;
import fr.model.Pizza;

public class UpdatePizza extends Action {

	private IhmUtil ihmUtil;

	public UpdatePizza(IhmUtil e) {
		super();
		this.setDescription("Mettre a jour une pizza");
		this.ihmUtil = e;
	}

	@Override
	public void doAction() throws UpdatesPizzaException, SQLException {
		System.out.println("");
		System.out.println("Quelle pizza voulez-vous modifier (donnez son code <Alias>)? ");
		String oldCode = ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer la modification de l'Alias de votre Pizza");
		String saisieAlias = ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer la modification  du nom de votre Pizza");
		String saisieNom = ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer le Categorie de la nouvelle pizza s'il vous plait");
		Stream.of(CategoriePizza.values())
				.forEach(System.out::println); /* Lister les enum cr�� */

		String catPizza = ihmUtil.getScanner().next();

		System.out.println("Veuillez entrer la modification  du prix de votre Pizza");
		Double saisiePrix = ihmUtil.getScanner().nextDouble();

		Pizza p = new Pizza(saisieAlias, saisieNom, CategoriePizza.valueOf(catPizza), saisiePrix);
		ihmUtil.getPizzaDao().update(p, oldCode);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
