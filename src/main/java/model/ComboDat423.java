package model;

public class ComboDat423 {
	private int id;
	private int soLuong;
	private Combo423 combo423;
	private BanDat423 banDat423;

	public ComboDat423() {
		// TODO Auto-generated constructor stub
	}

	public ComboDat423(int id, int soLuong, Combo423 combo423, BanDat423 banDat423) {
		super();
		this.id = id;
		this.soLuong = soLuong;
		this.combo423 = combo423;
		this.banDat423 = banDat423;
	}

	public ComboDat423(int soLuong, Combo423 combo423) {
		this.soLuong = soLuong;
		this.combo423 = combo423;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Combo423 getCombo423() {
		return combo423;
	}

	public void setCombo423(Combo423 combo423) {
		this.combo423 = combo423;
	}

	public BanDat423 getBanDat423() {
		return banDat423;
	}

	public void setBanDat423(BanDat423 banDat423) {
		this.banDat423 = banDat423;
	}

}
