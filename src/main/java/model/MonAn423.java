package model;

public class MonAn423 {

	private int id;
	private String ten;
	private float gia;
	private String donVi;
	private String moTa;

	public MonAn423() {
	}
	
	public MonAn423(String ten, float gia) {
		this.ten = ten;
		this.gia = gia;
	}

	public MonAn423(int id, String ten, float gia, String donVi, String moTa) {
		this.id = id;
		this.ten = ten;
		this.gia = gia;
		this.donVi = donVi;
		this.moTa = moTa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "MonAn423 [id=" + id + ", ten=" + ten + ", gia=" + gia + ", donVi=" + donVi + ", moTa=" + moTa + "]";
	}
}
