package fr.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.Pizza;

public class PizzaDaoFichier implements PizzaDaoFactory {
	private File file = new File("PizzaFiles");

	@Override
	public ArrayList<Pizza> findAll() {
		List<String> codeList = listCodesPizza();
		codeList.stream().forEach(codeFile -> readFile(codeFile));
		return null;
	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Pizza pizzaUdate, String oldCode) throws UpdatesPizzaException {
		// TODO Auto-generated method stub

	}

	// ****************************************************//
	// ****************************************************//
	/**
	 ** Liste la liste nom des fichiers <Pizza > au sein du dossier PizzaFiles **
	 * 
	 * @return Liste des fichiers
	 */
	private List<String> listCodesPizza() {
		String[] paths = file.list();
		List<String> stringList = new ArrayList<String>(Arrays.asList(paths));
		return stringList;
	}

	private void readFile(String codeFile) {
		String fileName = "PizzaFiles/" + codeFile;
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			// stream.map(t -> test.add(t));
			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
