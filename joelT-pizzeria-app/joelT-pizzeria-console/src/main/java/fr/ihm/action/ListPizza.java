package fr.ihm.action;

import java.sql.SQLException;
import java.util.stream.Stream;

import fr.ihm.IhmUtil;

public class ListPizza extends Action {

	private IhmUtil ihmUtil;

	public ListPizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("Lister les pizzas");
	}

	@Override
	public void doAction() throws SQLException {
		System.out.println("*****************");
		System.out.println("LISTE DES PIZZAS ");
		System.out.println("*****************");

		Stream.of(this.ihmUtil.getPizzaDao().findAll()).forEach(System.out::println);
		System.out.println(
				"*******************************************************************************************************");
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
