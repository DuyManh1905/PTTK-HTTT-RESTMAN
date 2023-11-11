package model;

public class BanDat423 {
	private int id;
	private String trangThai;
	private String ghiChu;
	private KhachHang423 khachHang423;
	private HoaDon423 hoaDon423;
	private Ban423 ban423;

	public BanDat423() {
		// TODO Auto-generated constructor stub
	}

	public BanDat423(int id, String trangThai, String ghiChu, KhachHang423 khachHang423, HoaDon423 hoaDon423,
			Ban423 ban423) {
		super();
		this.id = id;
		this.trangThai = trangThai;
		this.ghiChu = ghiChu;
		this.khachHang423 = khachHang423;
		this.hoaDon423 = hoaDon423;
		this.ban423 = ban423;
	}

	public BanDat423(int id, KhachHang423 khachHang423) {
		this.id = id;
		this.khachHang423 = khachHang423;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public KhachHang423 getKhachHang423() {
		return khachHang423;
	}

	public void setKhachHang423(KhachHang423 khachHang423) {
		this.khachHang423 = khachHang423;
	}

	public HoaDon423 getHoaDon423() {
		return hoaDon423;
	}

	public void setHoaDon423(HoaDon423 hoaDon423) {
		this.hoaDon423 = hoaDon423;
	}

	public Ban423 getBan423() {
		return ban423;
	}

	public void setBan423(Ban423 ban423) {
		this.ban423 = ban423;
	}

}
