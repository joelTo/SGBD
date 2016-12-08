package fr.ihm;

import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.ihm.action.Action;
import fr.ihm.action.AddPizza;
import fr.ihm.action.DeletePizza;
import fr.ihm.action.ExitMenu;
import fr.ihm.action.ListPizza;
import fr.ihm.action.ListPizzaGroupeCategorie;
import fr.ihm.action.ListPizzaTarifEleve;
import fr.ihm.action.UpdatePizza;

public class MainMenu {
	private Map<Integer, Action> map = new TreeMap<Integer, Action>();
	private IhmUtil ihmUtil;

	public MainMenu(IhmUtil ihmUtil) {

		map.put(1, new ListPizza(ihmUtil));
		map.put(2, new AddPizza(ihmUtil));
		map.put(3, new UpdatePizza(ihmUtil));
		map.put(4, new DeletePizza(ihmUtil));
		map.put(5, new ListPizzaGroupeCategorie(ihmUtil));
		map.put(6, new ListPizzaTarifEleve(ihmUtil));
		map.put(99, new ExitMenu());
		this.ihmUtil = ihmUtil;
	}

	public void displayMenu() {
		map.forEach((i, a) -> System.out.println(i + " " + a.getDescription()));
	}

	public void parseAndExec() throws NumberFormatException, SavePizzaException, DeletePizzaException,
			UpdatesPizzaException, SQLException {
		String input = ihmUtil.getScanner().next();
		this.map.get(Integer.parseInt(input)).doAction();

	}
}
