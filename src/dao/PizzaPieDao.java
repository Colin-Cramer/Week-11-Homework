package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PizzaPie;

public class PizzaPieDao {

	private Connection connection;
	private ToppingsDao toppingsDao;
	private final String GET_PIZZAPIE_QUERY = "SELECT * FROM pizza_pie";
	private final String GET_PIZZAPIE_BY_ID_QUERY = "SELECT * FROM pizza_pie WHERE id = ?";
	private final String CREATE_NEW_PIZZAPIE_QUERY = "INSERT INTO pizza_pie(name) VALUES(?)";
	private final String UPDATE_PIZZAPIE_QUERY_BY_ID = "UPDATE pizza_pie SET name = ? WHERE id = ?";
	private final String DELETE_PIZZAPIE_BY_ID_QUERY = "DELETE FROM pizza_pie WHERE id = ?";
	
	public PizzaPieDao() {
		connection = DBConnection.getConnection();
		toppingsDao = new ToppingsDao();
	}
	
	public List<PizzaPie> getPizzaPie() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_PIZZAPIE_QUERY).executeQuery();
		List<PizzaPie> pizzaPie = new ArrayList<PizzaPie>();
		
		while (rs.next()) {
			pizzaPie.add(populatePizzaPie(rs.getInt(1), rs.getString(2)));
		}
		return pizzaPie;
	}
	
	public PizzaPie getPizzaPieById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PIZZAPIE_BY_ID_QUERY);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePizzaPie(rs.getInt(1), rs.getString(2));
	}
	
	public void createNewPizzaPie(String pizzaPieName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PIZZAPIE_QUERY);
		ps.setString(1, pizzaPieName);
		ps.executeUpdate();
	}
	
	public void updatePizzaPieById(int id, String pizzaPieName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_PIZZAPIE_QUERY_BY_ID);
		ps.setString(1, pizzaPieName);
		ps.executeUpdate();
	}
	
	public void deletePizzaPieById(int id) throws SQLException {
		toppingsDao.deleteToppingsByPizzaPieId(id);
		PreparedStatement ps = connection.prepareStatement(DELETE_PIZZAPIE_BY_ID_QUERY);
		ps.setInt(1,  id);
		ps.executeUpdate();
	}
	
	private PizzaPie populatePizzaPie(int id, String name) throws SQLException {
		return new PizzaPie(id, name, toppingsDao.getToppingsByPizzaPieId(id));
	}

	
}
