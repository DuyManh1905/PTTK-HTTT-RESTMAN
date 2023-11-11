package model;

public class TKKhachHang423 extends KhachHang423 {
	private float tongTien;

	public TKKhachHang423() {
	}

	public TKKhachHang423(int id, String username, String password, String ten, String ngaySinh, String email,
			String diaChi, String ghiChu, float tongTien) {
		super(id, username, password, ten, ngaySinh, email, diaChi, ghiChu);
		// TODO Auto-generated constructor stub
		this.tongTien = tongTien;
	}

	

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	
	

	@Override
	public String toString() {
		return "TKKhachHang423 [tongTien=" + tongTien + ", getTongTien()=" + getTongTien() + ", getId()=" + getId()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getTen()=" + getTen()
				+ ", getNgaySinh()=" + getNgaySinh() + ", getEmail()=" + getEmail() + ", getDiaChi()=" + getDiaChi()
				+ ", getGhiChu()=" + getGhiChu() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
