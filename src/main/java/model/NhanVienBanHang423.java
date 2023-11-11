package model;

public class NhanVienBanHang423 {
	private int id;
	private String username;
	private String password;
	private String ten;
	private String ngaySinh;
	private String email;
	private String diaChi;
	private String ghiChu;
	
	public NhanVienBanHang423() {
		// TODO Auto-generated constructor stub
	}

	public NhanVienBanHang423(int id, String username, String password, String ten, String ngaySinh, String email,
			String diaChi, String ghiChu) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.email = email;
		this.diaChi = diaChi;
		this.ghiChu = ghiChu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
