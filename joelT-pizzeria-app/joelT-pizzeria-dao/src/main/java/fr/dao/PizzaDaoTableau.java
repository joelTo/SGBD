package fr.dao;

import java.util.ArrayList;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

public class PizzaDaoTableau implements PizzaDaoFactory {

	private ArrayList<Pizza> pizzas = new ArrayList<Pizza>() {
		{
			add(new Pizza(0, "PEP", "Pépéroni", CategoriePizza.VIANDE, 12.50));
			add(new Pizza(1, "MAR", "Margherita", CategoriePizza.VIANDE, 14.00));
			add(new Pizza(2, "REI", "La Reine", CategoriePizza.VIANDE, 11.50));
			add(new Pizza(3, "FRO", "La 4 fromages", CategoriePizza.SANS_VIANDE, 12.00));
			add(new Pizza(4, "CAN", "La cannibale", CategoriePizza.VIANDE, 12.50));
			add(new Pizza(5, "SAV", "La savoyarde", CategoriePizza.VIANDE, 13.00));
			add(new Pizza(6, "IND", "L’indienne", CategoriePizza.POISSON, 14.00));
			add(new Pizza(7, "ORI", "L’orientale", CategoriePizza.VIANDE, 13.50));
		}
	};

	@Override
	public ArrayList<Pizza> findAll() {
		return pizzas;
	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException {
		if (isValid(newPizza)) {
			throw new SavePizzaException();
		}
		pizzas.add(new Pizza(pizzas.size(), newPizza.getCode(), newPizza.getNom(), newPizza.getCatPizza(),
				newPizza.getPrix()));
	}

	private boolean isValid(Pizza newPizza) {
		return newPizza.getCode().isEmpty() && newPizza.getNom().isEmpty() && newPizza.getPrix() != 0;
	}

	public void delete(String code) throws DeletePizzaException {
		if (codeIsValide(code)) {
			throw new DeletePizzaException();
		}
		Pizza piz = pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst().get();
		pizzas.remove(piz);
	}

	private boolean codeIsValide(String code) {
		System.out.println(pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst().isPresent());
		return !pizzas.stream().filter(p -> p.getCode().equals(code)).findFirst().isPresent();
	}

	public void update(Pizza pizzaUdate, String oldCode) throws UpdatesPizzaException {

		if (isExisting(pizzaUdate, oldCode)) {
			throw new UpdatesPizzaException();
		}

		Pizza piz = pizzas.stream().filter(p -> p.getCode().equals(oldCode)).findFirst().get();
		Pizza pizzaModifiee = new Pizza(piz.getId(), pizzaUdate.getCode(), pizzaUdate.getNom(),
				pizzaUdate.getCatPizza(), pizzaUdate.getPrix());
		pizzas.set(piz.getId(), pizzaModifiee);

	}

	private boolean isExisting(Pizza pizzaUdate, String oldCode) {
		if (pizzas.stream().filter(p -> p.getCode().equals(oldCode)).findFirst().isPresent()) {
			// mise en place du logger à faire LOG.("Probleme le code entrez
			// n'existe pas ")
			return false;
		}
		return (pizzaUdate.getCode().isEmpty() && pizzaUdate.getNom().isEmpty() && pizzaUdate.getPrix() != 0);
	}

}