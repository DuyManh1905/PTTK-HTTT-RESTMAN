package model;

public class Ban423 {
	private int id;
	private String viTri;
	private String sucChua;
	private String trangThai;
	public Ban423() {
		// TODO Auto-generated constructor stub
	}
	public Ban423(int id, String viTri, String sucChua, String trangThai) {
		super();
		this.id = id;
		this.viTri = viTri;
		this.sucChua = sucChua;
		this.trangThai = trangThai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getViTri() {
		return viTri;
	}
	public void setViTri(String viTri) {
		this.viTri = viTri;
	}
	public String getSucChua() {
		return sucChua;
	}
	public void setSucChua(String sucChua) {
		this.sucChua = sucChua;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}
