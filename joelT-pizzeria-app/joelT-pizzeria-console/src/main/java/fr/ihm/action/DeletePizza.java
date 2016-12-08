package fr.ihm.action;

import java.sql.SQLException;

import fr.exception.DeletePizzaException;
import fr.ihm.IhmUtil;

public class DeletePizza extends Action {

	private IhmUtil ihmUtil;

	public DeletePizza(IhmUtil e) {
		super();
		this.setDescription("Supprimer une pizza");
		this.ihmUtil = e;
	}

	@Override
	public void doAction() throws DeletePizzaException, SQLException {
		System.out.println("");
		System.out.println("Veuillez entrerle code <Alias de pizza a supprimer, s'il vous plait");
		String pizzaToDelete = ihmUtil.getScanner().next();
		ihmUtil.getPizzaDao().delete(pizzaToDelete);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
