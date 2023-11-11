package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BanDat423;
import model.Combo423;
import model.ComboDat423;
import model.HoaDon423;
import model.KhachHang423;
import model.MonAn423;
import model.MonAnDat423;
import model.NhanVienBanHang423;

public class HoaDonDAO423 {

	private String jdbcURL = "jdbc:mysql://localhost:3306/restman2?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "20162017a";

	private static final String GET_DS_MONANDAT_BYHDID = "SELECT monandat423.id_monan, monandat423.soLuong FROM monandat423 "
			+ "INNER JOIN hoadon423 ON monandat423.id_bandat = hoadon423.id " + "WHERE hoadon423.id = ?";

	private static final String GET_DS_COMBODAT_BYHDID = "SELECT combodat423.id_combo, combodat423.soLuong FROM combodat423 "
			+ "INNER JOIN hoadon423 ON combodat423.id_bandat = hoadon423.id " + "WHERE hoadon423.id = ?";

	private static final String GET_MONAN_BYID = "select * from monan423 where id =?";
	private static final String GET_COMBO_BYID = "select * from combo423 where id =?";

	private static final String GET_HD_BY_ID = "SELECT hoadon423.id AS idHoaDon, hoadon423.thoiGian, hoadon423.id_nhanvienbanhang, hoadon423.tongTien "
			+ "FROM hoadon423 " + "WHERE hoadon423.id = ?";
//
//	static final String GET_CHI_TIET_HD = "SELECT " + "hd.id AS 'ID hóa đơn', " + "hd.thoiGian AS 'Ngày', "
//			+ "nv.ten AS 'Tên nhân viên', " + "bd.id AS 'ID bàn đặt', " + "ma.ten AS 'Tên món ăn', "
//			+ "mad.soLuong AS 'Số lượng món ăn', " + "c.tenCombo AS 'Tên combo', " + "cd.soLuong AS 'Số lượng combo', "
//			+ "SUM(COALESCE(ma.gia * mad.soLuong, 0) + COALESCE(c.giaBan * cd.soLuong, 0)) AS 'Tổng tiền hóa đơn' "
//			+ "FROM " + "hoadon423 hd " + "JOIN " + "bandat423 bd ON hd.id_bandat = bd.id " + "JOIN "
//			+ "nhanvienbanhang423 nv ON hd.id_nvbh = nv.id " + "LEFT JOIN "
//			+ "monandat423 mad ON bd.id = mad.id_bandat " + "LEFT JOIN " + "monan423 ma ON mad.id_monan = ma.id "
//			+ "LEFT JOIN " + "combodat423 cd ON bd.id = cd.id_bandat " + "LEFT JOIN "
//			+ "combo423 c ON cd.id_combo = c.id " + "WHERE " + "hd.id = ? " + "GROUP BY "
//			+ "hd.id, hd.thoiGian, nv.ten, bd.id, ma.ten, mad.soLuong, c.tenCombo, cd.soLuong";

	private static final String GET_NVBH_BYID = "select * from nhanvienbanhang423 where id =?";
	private static final String GET_BANDAT_BYID = "select * from bandat423 where id =?";
	private static final String GET_KH_BYID = "select * from khachhang423 where id =?";

	public HoaDonDAO423() {
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

	public HoaDon423 getHDById(int id) {
		HoaDon423 hoaDon423 = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_HD_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idHoaDon = rs.getInt("idHoaDon");
                String thoiGian = rs.getString("thoiGian");
                int idNhanVien= rs.getInt("id_nhanvienbanhang");
                float tongTien = rs.getFloat("tongTien");

				hoaDon423 = new HoaDon423(idHoaDon, thoiGian, getNVBHByID(idNhanVien), tongTien);

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println();
		return hoaDon423;
	}
	//

	public MonAn423 getMonAnById(int id) {
		MonAn423 monAn423 = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_MONAN_BYID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String ten = rs.getString("ten");
				float gia = rs.getFloat("gia");
				monAn423 = new MonAn423(ten, gia);

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println();
		return monAn423;
	}

	public Combo423 getComboById(int id) {
		Combo423 combo423 = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_COMBO_BYID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String ten = rs.getString("ten");
				float gia = rs.getFloat("gia");
				combo423 = new Combo423(ten, gia);

			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		System.out.println();
		return combo423;
	}

	public NhanVienBanHang423 getNVBHByID(int id) {
		NhanVienBanHang423 nhanVienBanHang423 = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_NVBH_BYID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String ten = rs.getString("ten");
				nhanVienBanHang423 = new NhanVienBanHang423(id, "", "", ten, "", "", "", "");
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return nhanVienBanHang423;
	}

	public BanDat423 getBanDatByID(int id) {
		BanDat423 banDat423 = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_BANDAT_BYID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id_khachhang = rs.getInt("id_khachhang");
				KhachHang423 kh = getKHByID(id_khachhang);
				banDat423 = new BanDat423(id, kh);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return banDat423;
	}

	public KhachHang423 getKHByID(int id) {
		KhachHang423 khachHang423 = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_KH_BYID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String ten = rs.getString("ten");
				khachHang423 = new KhachHang423(ten);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return khachHang423;
	}

//	public List<HoaDonDetail423> selectHoaDonDetail(int id) {
//		List<HoaDonDetail423> list = new ArrayList<>();
//		// Step 1: Establishing a Connection
//		try (Connection connection = getConnection();
//				// Step 2:Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement(GET_CHI_TIET_HD);) {
//			preparedStatement.setInt(1, id);
//			System.out.println(preparedStatement);
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//			// Step 4: Process the ResultSet object.
//			while (rs.next()) {
//				String tenMonAn = rs.getString("Tên món ăn");
//				int soLuongMonAn = rs.getInt("Số lượng món ăn");
//				String tenCombo = rs.getString("Tên combo");
//				int soLuongCombo = rs.getInt("Số lượng combo");
//				float tongTienHoaDon = rs.getFloat("Tổng tiền hóa đơn");
//				list.add(new HoaDonDetail423(tenMonAn, soLuongMonAn, tenCombo, soLuongCombo, tongTienHoaDon));
//			}
//		} catch (SQLException e) {
//			printSQLException(e);
//		}
//		return list;
//	}

	public List<MonAnDat423> getDSMonAnDatByHDID(int id) {
		List<MonAnDat423> list = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_DS_MONANDAT_BYHDID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idMonAn = rs.getInt("id_monan");
				int soLuong = rs.getInt("soLuong");
				MonAn423 monAn423 = getMonAnById(idMonAn);
				list.add(new MonAnDat423(soLuong, monAn423));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return list;
	}

	public List<ComboDat423> getDSComboDatByHDID(int id) {
		List<ComboDat423> list = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(GET_DS_COMBODAT_BYHDID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idCombo = rs.getInt("id_combo");
				int soLuong = rs.getInt("soLuong");
				Combo423 combo423 = getComboById(idCombo);
				list.add(new ComboDat423(soLuong, combo423));
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
