package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.PizzaPieDao;
import dao.ToppingsDao;
import entity.PizzaPie;
import entity.Toppings;

public class Menu {
	
	private PizzaPieDao pizzaPieDao = new PizzaPieDao();
	private ToppingsDao toppingsDao = new ToppingsDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display All Pizzas",
			"Display a Pizza",
			"Create a Pizza",
			"Update a Pizza",
			"Delete a Pizza",
			"Create a Set of Pizza Toppings",
			"Update a Set of Pizza Toppings",
			"Delete a Set of Pizza Toppings");

	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if (selection.equals("1")) {
					displayPizzaPies();
				} else if (selection.equals("2")) {
					displayPizzaPie();
				} else if (selection.equals("3")) {
					createPizzaPie();
				} else if (selection.equals("4")) {	
					updatePizzaPie();
				} else if (selection.equals("5")) {
					deletePizzaPie();
				} else if (selection.equals("6")) {
					createToppings();
				} else if (selection.equals("7")) {
					updateToppings();
				} else if (selection.equals("8")) {
					deleteToppings();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press enter to coninue...");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}

	private void printMenu() {
		System.out.println("Select an Option:\n-------------------------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayPizzaPies() throws SQLException {
		List<PizzaPie> pizzaPie = pizzaPieDao.getPizzaPie();
		for (PizzaPie pizza : pizzaPie) {
			System.out.println(pizza.getPizzaPieId() + ": " + pizza.getName());
		}
	}
																
	private void displayPizzaPie() throws SQLException {
		System.out.println("Enter Pizza ID: ");
		int id = Integer.parseInt(scanner.nextLine());
		PizzaPie pizzaPie = pizzaPieDao.getPizzaPieById(id);
		System.out.println(pizzaPie.getPizzaPieId() + ": " + pizzaPie.getName());
		for (Toppings topping : pizzaPie.getToppings()) {
			System.out.println("\tPizza ID: " + topping.getToppingsId() + " - Crust Type: " + topping.getCrust()
			+ " - Sauce: " + topping.getSauce() +" - Cheese: " + topping.getCheese() + " - Meat Topping: " 
					+ topping.getMeat() + " - Vegetable Topping: " + topping.getVegetable());
		}
	}
	
	private void createPizzaPie() throws SQLException {
		System.out.println("Enter Pizza Name: ");
		String pizzaPieName = scanner.nextLine();
		pizzaPieDao.createNewPizzaPie(pizzaPieName);
	}
	
	private void updatePizzaPie() throws SQLException {
		System.out.println("Enter the New Pizza Name: ");
		String pizzaPieName = scanner.nextLine();
		System.out.println("Enter the Pizza ID to Modify: ");
		int id = Integer.parseInt(scanner.nextLine());
		pizzaPieDao.updatePizzaPieById(pizzaPieName, id);
	}
	
	private void deletePizzaPie() throws SQLException {
		System.out.println("Enter Pizza ID to Delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		pizzaPieDao.deletePizzaPieById(id);
	}
	
	private void createToppings() throws SQLException {
		System.out.println("Enter The Type of Crust You Would Like: ");
		String crust = scanner.nextLine();
		System.out.println("Enter The Type of Sauce You Would Like: ");
		String sauce = scanner.nextLine();
		System.out.println("Enter The Type of Cheese You Would Like: ");
		String cheese = scanner.nextLine();
		System.out.println("Enter The Type of Meat You Would Like: ");
		String meat = scanner.nextLine();
		System.out.println("Enter The Type of Vegetable You Would Like: ");
		String vegetable = scanner.nextLine();
		System.out.println("Enter The Pizza ID of These Toppings: ");
		int pizzaPieId = Integer.parseInt(scanner.nextLine());
		toppingsDao.createNewTopping(crust, sauce, cheese, meat, vegetable, pizzaPieId);
	}
	
	private void updateToppings() throws SQLException {
		System.out.println("Enter The Type of Crust You Would Like: ");
		String crust = scanner.nextLine();
		System.out.println("Enter The Type of Sauce You Would Like: ");
		String sauce = scanner.nextLine();
		System.out.println("Enter The Type of Cheese You Would Like: ");
		String cheese = scanner.nextLine();
		System.out.println("Enter The Type of Meat You Would Like: ");
		String meat = scanner.nextLine();
		System.out.println("Enter The Type of Vegetable You Would Like: ");
		String vegetable = scanner.nextLine();
		System.out.println("Enter The Pizza ID This Will Belong To: ");
		int pizzaPieId = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter The Toppings ID To Update: ");
		int toppingsId = Integer.parseInt(scanner.nextLine());
		toppingsDao.updateToppingsById(crust, sauce, cheese, meat, vegetable, pizzaPieId, toppingsId);
	}
	
	private void deleteToppings() throws SQLException {
		System.out.println("Enter Topping ID To Delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		toppingsDao.deleteToppingsById(id);
	}
}
