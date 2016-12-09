package fr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import fr.exception.DeletePizzaException;
import fr.exception.PizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.Pizza;

public class PizzaDaoBaseDeDonneeJDBC implements PizzaDaoFactory {
	private String url;
	private String user;
	private String password;

	public PizzaDaoBaseDeDonneeJDBC() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		ResourceBundle bunble = ResourceBundle.getBundle("jdbc");
		url = bunble.getString("url.jdbc");
		user = bunble.getString("user.jdbc");
		password = bunble.getString("password.jdbc");
	}

	interface IRunSql<T> {
		T exec(Statement st) throws SQLException;
	}

	interface IRunSqlPrep<T> {
		T exec(Connection conn) throws SQLException;
	}

	public <T> T execute(IRunSql<T> run) {
		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement();) {

			return run.exec(statement);

		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoBaseDeDonneeJDBC.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}
	}

	public <T> T executePrep(IRunSqlPrep<T> run) {
		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement();) {

			return run.exec(connection);
		} catch (SQLException e) {
			Logger.getLogger(PizzaDaoBaseDeDonneeJDBC.class.getName()).severe(e.getMessage());
			throw new PizzaException(e);
		}

	}

	@Override
	public List<Pizza> findAll() throws SQLException {
		// Connection connection =
		// Statement statement = connection.createStatement();
		// connection.setAutoCommit(false);
		// ResultSet resultats = statement.executeQuery("SELECT * FROM pizzas");
		// while (resultats.next()) {
		// Integer id = resultats.getInt("id");
		// String alias = resultats.getString("reference");
		// String name = resultats.getString("libelle");
		// Double price = resultats.getDouble("prix");
		// String categoriePizza = resultats.getString("categorie");
		// pizzas.add(new Pizza(id, alias, name,
		// CategoriePizza.valueOf(categoriePizza), price));
		// }
		// statement.close();
		//
		// return pizzas;
		return null;
	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException, SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		System.out.println();

		int nbPizzaInsere = statement
				.executeUpdate("INSERT INTO pizzas(id,libelle,reference,prix,url_image,categorie) VALUES("
						+ newPizza.getId() + ",'" + newPizza.getNom() + "','" + newPizza.getCode() + "',"
						+ newPizza.getPrix() + ",'/','" + newPizza.getCatPizza() + "')");

		System.out.println(nbPizzaInsere + " pizza inséré");
		statement.close();
	}

	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {
		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement()) {
			System.out.println();
			int nbPizzaInsere = statement
					.executeUpdate("DELETE FROM pizzas WHERE reference = '" + pizzaToDelete + "';");
			System.out.println(nbPizzaInsere + " pizza supprimé");

		} catch (SQLException e) {
			throw new DeletePizzaException(e);
		}

	}

	@Override
	public void update(Pizza pizzaUdate, String oldCode) throws UpdatesPizzaException, SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		int nbPizzaInsere = statement.executeUpdate("UPDATE pizzas SET  libelle = '" + pizzaUdate.getNom()
				+ "', reference = '" + pizzaUdate.getCode() + "', prix = '" + pizzaUdate.getPrix() + "', categorie = '"
				+ pizzaUdate.getCatPizza() + "' WHERE reference = '" + oldCode + "'");

		System.out.println(nbPizzaInsere + " pizza mise a jour");
		statement.close();
	}
	//
	// public void insertionPizza3() throws SQLException {
	// List<Pizza> pizza = new ArrayList<Pizza>();
	// pizza.add(new Pizza(0, "PEP", "Pépéroni", CategoriePizza.VIANDE, 12.50));
	// pizza.add(new Pizza(1, "MAR", "Margherita", CategoriePizza.VIANDE,
	// 14.00));
	// pizza.add(new Pizza(2, "REI", "La Reine", CategoriePizza.VIANDE, 11.50));
	// pizza.add(new Pizza(3, "FRO", "La 4 fromages",
	// CategoriePizza.SANS_VIANDE, 12.00));
	// pizza.add(new Pizza(4, "CAN", "La cannibale", CategoriePizza.VIANDE,
	// 12.50));
	// pizza.add(new Pizza(5, "SAV", "La savoyarde", CategoriePizza.VIANDE,
	// 13.00));
	//
	// Connection connection = DriverManager.getConnection(url, user, password);
	// Statement statement = connection.createStatement();
	// connection.setAutoCommit(false);
	//
	// List<List<Pizza>> partition = ListUtils.partition(pizza, 3);
	// System.out.println(partition.size());
	// partition.stream().forEach(listPizza -> {
	// for (Pizza piz : listPizza) {
	// Connection conn;
	// PreparedStatement addPizzaSt = conn
	// .prepareStatement("INSERT INTO
	// pizzas(id,libelle,reference,prix,categorie) VALUES (?,?,?,?)");
	// addPizzaSt.setInt(1, piz.getId());
	// addPizzaSt.setString(2, piz.getNom());
	// addPizzaSt.setString(3, piz.getCode());
	// addPizzaSt.setDouble(4, piz.getPrix());
	// addPizzaSt.setString(5, piz.getCatPizza().name());
	// }
	// connection.commit();
	//
	// });
	// catch (SQLException e) {
	// connection.rollback();
	// Logger.getLogger(PizzaDaoBaseDeDonneeJDBC.class.getName()).severe(e.getMessage());
	// throw new PizzaException(e);
	// }
	// }
}
