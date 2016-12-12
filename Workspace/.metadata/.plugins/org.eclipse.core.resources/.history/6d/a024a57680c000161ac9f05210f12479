package fr.ihm.action;

import java.util.logging.Logger;

import org.apache.commons.codec.digest.DigestUtils;

import fr.ihm.IhmUtilClient;
import fr.model.Client;
import fr.model.NomComplet;

public class InscriptionClient extends ActionClient{
	private IhmUtilClient ihmUtilCleint;

	public  InscriptionClient(IhmUtilClient ihm) {
		super();
		this.setDescription("S'inscrire");
		this.ihmUtilCleint=ihm;
	}
	@Override
	public void doAction() {
		System.out.println("");
		System.out.println("Veuillez entrer votre Nom :");
		String nom = ihmUtilCleint.getScanner().next();
		System.out.println("Veuillez entrer votre Prenom :");
		String prenom = ihmUtilCleint.getScanner().next();
		System.out.println("Veuillez entrer votre email :");
		String email = ihmUtilCleint.getScanner().next();
		System.out.println("Veuillez entrer votre mot de passe :");
		String motDePasse = DigestUtils.md5Hex(ihmUtilCleint.getScanner().next());
		ihmUtilCleint.getClientDao().signIn(new Client(new NomComplet(nom,prenom),email,motDePasse));
		
		

	}

	@Override
	public void describeAction() {
		 Logger.getLogger(this.getDescription()); 
		 System.out.println(this.getDescription());

	}


}
