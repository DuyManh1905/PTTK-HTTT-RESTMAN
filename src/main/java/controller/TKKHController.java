package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HoaDonDAO423;
import dao.TKKhachHangDAO423;
import model.ComboDat423;
import model.HoaDon423;
import model.KhachHang423;
import model.MonAnDat423;
import model.TKKhachHang423;

@WebServlet(urlPatterns = "/tkkh/*")
public class TKKHController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TKKhachHangDAO423 tkKhachHangDAO423;
	private HoaDonDAO423 hoaDonDAO423;

	public TKKHController() {
		super();
	}

	public void init() {
		tkKhachHangDAO423 = new TKKhachHangDAO423();
		hoaDonDAO423 = new HoaDonDAO423();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();

		String action = uri.substring(contextPath.length());

		response.setContentType("text/html");
		System.out.println("dòng 24" + action);
		switch (action) {
		case "/tkkh/tk":
			System.out.println("đã vào trang chủ");
			goToHome(request, response);
			break;
		case "/tkkh/xembc":
			System.out.println("đã vào xem báo cáo");
			goToGDXemBaoCao(request, response);
			break;
		case "/tkkh/tkkhtdt":
			System.out.println("đã vào thống kê khách hàng theo doanh thu");
			goToGDTKKHTDT(request, response);
			break;
		case "/tkkh/search-by-date":
			System.out.println("đã vào seach khách hàng by date");
			goToGDTKKHTDTByDate(request, response);
			break;
		case "/tkkh/detail":
			System.out.println("đã vào danh sach hoa don cua khach hang");
			goToGDDSHDByKHAndDate(request, response);
			break;
		case "/tkkh/detail/hd":
			System.out.println("đã vào hoa don chi tiet");
			goToGDHDChiTiet(request, response);
			break;
		default:
			System.out.println("đã vào default");
			goToHome(request, response);
			break;
		}
	}

	private void goToHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/thongke-khachhang/home-nvql.jsp");
		dispatcher.forward(request, response);
	}

	private void goToGDXemBaoCao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/thongke-khachhang/gd-xembaocao.jsp");
		dispatcher.forward(request, response);
	}

	private void goToGDTKKHTDT(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<TKKhachHang423> list = new ArrayList<>();

		request.setAttribute("listKh", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/thongke-khachhang/gd-tkkhtdt.jsp");
		dispatcher.forward(request, response);
	}

	private void goToGDTKKHTDTByDate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		List<TKKhachHang423> list = tkKhachHangDAO423.getListKhByDate(startDate, endDate);

		request.setAttribute("listKh", list);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/thongke-khachhang/gd-tkkhtdt.jsp");
		dispatcher.forward(request, response);
	}

	private void goToGDDSHDByKHAndDate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		int id = Integer.parseInt(request.getParameter("id"));
		
		KhachHang423 khachHang = tkKhachHangDAO423.selectKhachHang(id);

		List<HoaDon423> list = tkKhachHangDAO423.getDSHDByKHAndDate(id, startDate, endDate);

		request.setAttribute("listHd", list);
		request.setAttribute("kh", khachHang);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/thongke-khachhang/gd-ds-hoadon-kh.jsp");
		dispatcher.forward(request, response);
	}

	private void goToGDHDChiTiet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int id_kh = Integer.parseInt(request.getParameter("id_kh"));
		
		KhachHang423 kh = hoaDonDAO423.getKHByID(id_kh);
		HoaDon423 hd = hoaDonDAO423.getHDById(id);

		request.setAttribute("hd", hd);
		request.setAttribute("kh", kh);
		
		List<MonAnDat423> monAnDat423s = hoaDonDAO423.getDSMonAnDatByHDID(id);
		List<ComboDat423> comboDat423s = hoaDonDAO423.getDSComboDatByHDID(id);
		
		request.setAttribute("dsmonan", monAnDat423s);
		request.setAttribute("dscombo", comboDat423s);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/thongke-khachhang/gd-hd-chitiet.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static void main(String[] args) {

	}
}
