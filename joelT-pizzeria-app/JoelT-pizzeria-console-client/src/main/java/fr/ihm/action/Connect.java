package fr.ihm.action;

import org.apache.commons.codec.digest.DigestUtils;

import fr.ihm.IhmUtilClient;

public class Connect extends ActionClient {
	private IhmUtilClient ihmUtilClient;

	public Connect(IhmUtilClient ihm) {
		super();
		this.setDescription("Se connecter");
		this.ihmUtilClient = ihm;

	}

	@Override
	public void doAction() {
		System.out.println("");
		System.out.println("Veuillez entrer votre email :");
		String email = ihmUtilClient.getScanner().next();
		System.out.println("Veuillez entrer votre mot de passe :");
		String motDePasse = DigestUtils.md5Hex(ihmUtilClient.getScanner().next());
		ihmUtilClient.getClientDao().connection(email, motDePasse);
	}

	@Override
	public void describeAction() {

	}

}
