package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Toppings;

public class ToppingsDao {
	
	private Connection connection;
	private final String GET_TOPPINGS_BY_PIZZAPIE_ID_QUERY = "SELECT * FROM toppings WHERE pizza_pie_id = ?";
	private final String DELETE_TOPPINGS_BY_PIZZAPIE_ID_QUERY = "DELETE FROM toppings WHERE pizza_pie_id = ?";
	private final String CREATE_NEW_TOPPING_QUERY = "INSERT INTO toppings(crust, sauce, cheese, meat, vegetable,"
			+ " pizza_pie_id) VALUES(?,?,?,?,?,?)";
	private final String UPDATE_TOPPINGS_BY_ID_QUERY = "UPDATE toppings SET crust = ?, sauce = ?, cheese = ?, meat = ?, vegetable = ?,"
			+ " pizza_pie_id = ? WHERE id = ?";
	private final String DELETE_TOPPINGS_BY_ID_QUERY = "DELETE FROM toppings WHERE id = ?";
	
	public ToppingsDao() {
		connection = DBConnection.getConnection();
	}

	public List<Toppings> getToppingsByPizzaPieId(int toppingsId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_TOPPINGS_BY_PIZZAPIE_ID_QUERY);
		ps.setInt(1, toppingsId);
		ResultSet rs = ps.executeQuery();
		List<Toppings> toppings = new ArrayList<Toppings>();
		
		while (rs.next()) {
			toppings.add(new Toppings(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
					rs.getString(5), rs.getString(6)));
		}
		return toppings;
	}
	
	public void createNewTopping(String crust, String sauce, String cheese, String meat,
			String vegetable, int pizzaPieId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_TOPPING_QUERY);
		ps.setString(1, crust);
		ps.setString(2, sauce);
		ps.setString(3, cheese);
		ps.setString(4, meat);
		ps.setString(5, vegetable);
		ps.setInt(6, pizzaPieId);
		ps.executeUpdate();
		
	}
	
	public void deleteToppingsByPizzaPieId(int pizzaPieId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TOPPINGS_BY_PIZZAPIE_ID_QUERY);
		ps.setInt(1, pizzaPieId);
		ps.executeUpdate();
	}
	
	public void deleteToppingsById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_TOPPINGS_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

	public void updateToppingsById(String crust, String sauce, String cheese, String meat,
			String vegetable, int pizzaPieId, int toppingsId) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_TOPPINGS_BY_ID_QUERY);
		ps.setString(1, crust);
		ps.setString(2, sauce);
		ps.setString(3, cheese);
		ps.setString(4, meat);
		ps.setString(5, vegetable);
		ps.setInt(6, pizzaPieId);
		ps.setInt(7, toppingsId);
		ps.executeUpdate();
		
	}
	
}