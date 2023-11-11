package model;

public class MonAnDat423 {
	private int id;
	private int soLuong;
	private MonAn423 monAn423;
	private BanDat423 banDat423;
	
	
	public MonAnDat423(int id, int soLuong, MonAn423 monAn423, BanDat423 banDat423) {
		this.id = id;
		this.soLuong = soLuong;
		this.monAn423 = monAn423;
		this.banDat423 = banDat423;
	}
	
	public MonAnDat423(int soLuong, MonAn423 monAn423) {
		this.soLuong = soLuong;
		this.monAn423 = monAn423;
	}

	

	public MonAnDat423() {
		// TODO Auto-generated constructor stub
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

	public MonAn423 getMonAn423() {
		return monAn423;
	}

	public void setMonAn423(MonAn423 monAn423) {
		this.monAn423 = monAn423;
	}

	public BanDat423 getBanDat423() {
		return banDat423;
	}

	public void setBanDat423(BanDat423 banDat423) {
		this.banDat423 = banDat423;
	}
	
}
