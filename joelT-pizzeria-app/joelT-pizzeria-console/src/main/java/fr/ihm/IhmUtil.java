package fr.ihm;

import java.util.Scanner;

import fr.dao.PizzaDaoFactory;

public class IhmUtil {

	private Scanner scanner;
	private PizzaDaoFactory pizzaDao;
	// private Logger log = Logger.getLogger();

	public IhmUtil(Scanner scanner, PizzaDaoFactory pizzaDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public PizzaDaoFactory getPizzaDao() {
		return this.pizzaDao;
	}

}
