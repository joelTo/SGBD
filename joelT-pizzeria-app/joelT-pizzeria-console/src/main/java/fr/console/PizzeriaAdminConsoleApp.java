package fr.console;

import java.sql.SQLException;

import fr.dao.PizzaDaoBaseDeDonneeJDBC;
import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.CategoriePizza;
import fr.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static Boolean Arret = false;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, SavePizzaException, DeletePizzaException, UpdatesPizzaException {
		// initPizzas();
		// printMenu();

		// IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new
		// PizzaDaoTableau());
		// IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new
		// PizzaDaoFichier());
		// MainMenu Core = new MainMenu(ihmUtil);

		/*****************************************************/
		/**
		 * Test pour voir si les dépendances des librairies sont respectees
		 */
		/*
		 * Pizza p1 = new Pizza(); p1.setCode("MAR"); Pizza p2 = new Pizza();
		 * p2.setCode("MAR");
		 * 
		 * System.out.println("p1=p2  ?" + p1.equals(p2)); /
		 *****************************************************/

		/*
		 * ResourceBundle bunble = ResourceBundle.getBundle("application");
		 * String doaConfig = bunble.getString("dao.impl"); PizzaDaoFactory
		 * doaFactory = (PizzaDaoFactory)
		 * Class.forName(doaConfig).newInstance();
		 */

		/**
		 * Pour le lancement
		 */
		/*
		 * IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), doaFactory);
		 * MainMenu Core = new MainMenu(ihmUtil);
		 */

		// PizzaDaoFichier test = new PizzaDaoFichier();
		// System.out.println(test.findAll());

		PizzaDaoBaseDeDonneeJDBC test = new PizzaDaoBaseDeDonneeJDBC();
		System.out.println(test.findAll());
		// test.save(new Pizza("PEP", "Pépéroni", CategoriePizza.VIANDE,
		// 12.50));
		test.update(new Pizza("IND3", "indienne3", CategoriePizza.POISSON, 14.30), "IND2");
		/*
		 * while (Arret == false) { Core.displayMenu(); try {
		 * Core.parseAndExec(); } catch (NumberFormatException e) {
		 * 
		 * e.printStackTrace(); } catch (SavePizzaException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch
		 * (DeletePizzaException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (UpdatesPizzaException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } }
		 */
	}
}