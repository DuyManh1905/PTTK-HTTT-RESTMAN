package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MonAn423;


public class MonAnDAO423 {
	private String jdbcURL = "jdbc:mysql://localhost:3306/restman2?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "20162017a";


	private static final String SELECT_MONAN_BY_ID = "select * from monan423 where id =?";
	private static final String SELECT_MONAN_BY_NAME = "select * from monan423 where ten like ?";
	private static final String SELECT_ALL_MONAN = "select * from monan423";


	public MonAnDAO423() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}


	public MonAn423 selectMOnAn(int id) {
		MonAn423 monAn423 = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MONAN_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String ten = rs.getString("ten");
				float gia = Float.parseFloat(rs.getString("gia"));
				String donVi = rs.getString("donvi");
				String mota = rs.getString("mota");
				monAn423 = new MonAn423(id,ten,gia,donVi,mota);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return monAn423;
	}

	public List<MonAn423> selectAllMonAn() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<MonAn423> monAn423s = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MONAN);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String ten = rs.getString("ten");
				float gia = Float.parseFloat(rs.getString("gia"));
				String donVi = rs.getString("donvi");
				String mota = rs.getString("mota");
				monAn423s.add(new MonAn423(id, ten, gia, donVi,mota));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return monAn423s;
	}
	
	public List<MonAn423> selectAllMonAnByName(String s) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<MonAn423> monAn423s = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MONAN_BY_NAME);) {
			preparedStatement.setString(1, "%" + s + "%");
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String ten = rs.getString("ten");
				float gia = Float.parseFloat(rs.getString("gia"));
				String donVi = rs.getString("donvi");
				String mota = rs.getString("mota");
				monAn423s.add(new MonAn423(id, ten, gia, donVi,mota));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return monAn423s;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
