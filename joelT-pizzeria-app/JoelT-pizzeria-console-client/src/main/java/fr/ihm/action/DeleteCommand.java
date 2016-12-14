package fr.ihm.action;

import fr.ihm.IhmUtilClient;

public class DeleteCommand extends ActionClient {
	private IhmUtilClient ihmUtilClient;

	public DeleteCommand(IhmUtilClient ihmUtilClient) {
		super();
		this.ihmUtilClient = ihmUtilClient;
		this.setDescription("Suppression d'un client");

	}

	@Override
	public void doAction() {
		System.out.println("Donnez le numero de commande à annuler");
		String idCommanndTodelete = ihmUtilClient.getScanner().next();
		ihmUtilClient.getClientDao().delete();
	}

	@Override
	public void describeAction() {
		// TODO Auto-generated method stub

	}

}
