package fr.dao;

import java.sql.SQLException;
import java.util.List;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.Client;
import fr.model.Pizza;

public interface ClientDaoFactory {

	List<Pizza> findCommand();

	void save(String newPizza, Integer nbPizza);

	void delete(String pizzaToDelete, Integer nbPizza) ;

	void update(String pizzaUdate, Integer nbPizza) ;
	
	// Mettre cette option [Optional]
    void signIn(Client pers);
	
	void connection(String email, String password);

}
