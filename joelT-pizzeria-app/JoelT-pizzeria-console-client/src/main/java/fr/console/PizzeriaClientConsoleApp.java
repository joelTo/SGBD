package fr.console;

import fr.dao.ClientDaoConsoleJPA;
import fr.dao.ClientDaoFactory;
import fr.model.Client;
import fr.model.NomComplet;

public class PizzeriaClientConsoleApp {

	public static void main(String[] args) {
		ClientDaoFactory test = new ClientDaoConsoleJPA();
		test.signIn(new Client(new NomComplet("TOR", "Joel"), "joel@gmail.com", "123456"));

	}

}
