package fr.ihm;

import java.util.Scanner;

import fr.dao.ClientDaoFactory;


public class IhmUtilClient {

	private Scanner scanner;
	private  ClientDaoFactory clientdoa;
	
	public IhmUtilClient(Scanner scanner, ClientDaoFactory clientdao) {
		super();
		this.scanner = scanner;
		this.clientdoa=clientdao;
	}

	public Scanner getScanner() {
		return this.scanner;
	}

	public ClientDaoFactory getClientDao() {
		return this.clientdoa;
	}

}
