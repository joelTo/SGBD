package fr.ihm.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.ihm.IhmUtil;
import fr.model.CategoriePizza;
import fr.model.Pizza;

public class ListPizzaGroupeCategorie extends Action {

	private IhmUtil ihmUtil;

	public ListPizzaGroupeCategorie(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("Liste les pizza par groupe categorie");
	}

	@Override
	public void doAction() throws SQLException {
		System.out.println("Affichage des pizzas par categories");
		Map<CategoriePizza, List<Pizza>> map = this.ihmUtil.getPizzaDao().findAll().stream()
				.collect(Collectors.groupingBy(pizza -> pizza.getCatPizza()));
		map.entrySet().stream().forEach(System.out::println);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}
}
