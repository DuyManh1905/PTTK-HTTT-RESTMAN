package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.HoaDon423;
import model.KhachHang423;
import model.TKKhachHang423;

public class TKKhachHangDAO423 {

	private String jdbcURL = "jdbc:mysql://localhost:3306/restman2?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "20162017a";

	private static final String GET_KH_BY_ID = "select * from khachhang423 where id =?";

	private static final String GET_KH_BY_DATE = "SELECT khachhang423.id AS IDKhachHang, khachhang423.username AS UsernameKhachHang, khachhang423.ten AS TenKhachHang, SUM(hoadon423.tongTien) AS TongTienDaMua "
			+ "FROM khachhang423 " + "INNER JOIN bandat423 ON khachhang423.id = bandat423.id_khachhang "
			+ "INNER JOIN hoadon423 ON bandat423.id_hoadon = hoadon423.id "
			+ "WHERE hoadon423.thoiGian >= ? AND hoadon423.thoiGian <= ? "
			+ "GROUP BY khachhang423.id, khachhang423.username";

	private static final String GET_DS_HD_BY_KH_AND_DATE = "SELECT hoadon423.* " + "FROM hoadon423 "
			+ "INNER JOIN bandat423 ON hoadon423.id = bandat423.id_hoadon "
			+ "WHERE bandat423.id_khachhang = ? AND hoadon423.thoiGian >= ? AND hoadon423.thoiGian <= ?";

	public TKKhachHangDAO423() {
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

	public KhachHang423 selectKhachHang(int id) {
		KhachHang423 khachHang423 = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_KH_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String ten = rs.getString("ten");
				String username = rs.getString("username");
				khachHang423 = new KhachHang423(id, username, "", ten, "", "", "", "");

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return khachHang423;
	}

	public List<TKKhachHang423> getListKhByDate(String start, String end) {
		List<TKKhachHang423> list = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_KH_BY_DATE);) {
			preparedStatement.setString(1, start); // Set thời gian bắt đầu
			preparedStatement.setString(2, end); // Set thời gian kết thúc
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("IDKhachHang");
				String username = rs.getString("UsernameKhachHang");
				String ten = rs.getString("TenKhachHang");
				float tongTien = rs.getFloat("TongTienDaMua");

				list.add(new TKKhachHang423(id, username, "0", ten, "0", "0", "0", "0", tongTien));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return list;
	}

	public List<HoaDon423> getDSHDByKHAndDate(int id_kh, String start, String end) {
		List<HoaDon423> list = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_DS_HD_BY_KH_AND_DATE);) {
			preparedStatement.setInt(1, id_kh);
			preparedStatement.setString(2, start);
			preparedStatement.setString(3, end);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String thoiGian = rs.getString("thoiGian");
				float tongTien = rs.getFloat("tongTien");
				list.add(new HoaDon423(id, thoiGian, tongTien));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return list;
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
