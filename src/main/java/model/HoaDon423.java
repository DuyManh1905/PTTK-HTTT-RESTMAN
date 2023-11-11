package model;

public class HoaDon423 {
	private int id;
	private String thoiGian;
	private NhanVienBanHang423 nhanVienBanHang423;
	private float tongTien;

	public HoaDon423() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon423(int id, String thoiGian, NhanVienBanHang423 nhanVienBanHang423, float tongTien) {
		super();
		this.id = id;
		this.thoiGian = thoiGian;
		this.nhanVienBanHang423 = nhanVienBanHang423;
		this.tongTien = tongTien;
	}
	
	public HoaDon423(int id, String thoiGian, float tongTien) {
		this.id = id;
		this.thoiGian = thoiGian;
		this.tongTien = tongTien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public NhanVienBanHang423 getNhanVienBanHang423() {
		return nhanVienBanHang423;
	}

	public void setNhanVienBanHang423(NhanVienBanHang423 nhanVienBanHang423) {
		this.nhanVienBanHang423 = nhanVienBanHang423;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}

	
}
