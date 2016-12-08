package fr.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.exception.SavePizzaException;
import fr.model.Pizza;

public class TraitementFichiers {
	private File file = new File("PizzaFiles");

	public void printlistFile() {
		List<String> code = listCodesPizza();
		for (String path : code) {
			System.out.println(path);
		}
	}

	/**
	 * Retourne une liste de nom de fichier des pizzas. Ce sont donc les noms
	 * des pizzas
	 * 
	 * @return List type ArrayList
	 */
	private List<String> listCodesPizza() {
		String[] paths = file.list();
		List<String> stringList = new ArrayList<String>(Arrays.asList(paths));
		return stringList;
	}

	public void saveFile(Pizza pizza) throws SavePizzaException, IOException {
		if (isPresent(pizza)) {
			/**
			 * Pour dire que le code de cette pizza existe deja
			 */
			throw new SavePizzaException();
		}
		writePizza(pizza);
	}

	/**
	 * Ecriture dans un fichier texte sources :
	 * http://www.ukonline.be/programmation/java/tutoriel/chapitre12/page4.php
	 * 
	 * @param pizza
	 * @throws IOException
	 */
	private void writePizza(Pizza pizza) throws IOException {
		// Path f = Paths.get(file + "/" + pizza.getCode() + ".txt");
		File f = new File(file + "/" + pizza.getCode() + ".txt");
		String pizzaString = pizza.getNom() + ";" + pizza.getPrix() + ";" + pizza.getCatPizza();
		FileWriter fw = new FileWriter(pizzaString);
		fw.close();

	}

	/**
	 * Test de la presence d'un nom identique de code de pizza dans le fichier
	 * de base "PizzasFiles"
	 * 
	 * @param pizza
	 * @return
	 */
	private boolean isPresent(Pizza pizza) {
		return listCodesPizza().stream().filter(t -> t.equals(pizza.getCode())).findFirst().isPresent();
	}

	/**
	 * Renvoi le nombre de fichier dans le dossier de base des pizzas
	 * "PizzasFiles"
	 * 
	 * @return
	 */
	private Integer pizzaNumber() {
		String[] paths = file.list();
		return paths.length;
	}
}
