package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MonAnDAO423;
import model.MonAn423;

@WebServlet(urlPatterns = "/")
public class MonAnController423 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MonAnDAO423 monAnDAO423;

	public MonAnController423() {
		super();
	}

	public void init() {
		monAnDAO423 = new MonAnDAO423();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		response.setContentType("text/html");
		System.out.println(action);

		//
		try {
			switch (action) {
			case "/home":
				System.out.println("đã vào trang chủ");
				goToHome(request, response);
				break;
			case "/detail":
				System.out.println("đã vào trang chi tiết món ăn");
				goToDetail(request, response);
				break;
			case "/search":
				System.out.println("đã vào trang tìm kiếm món ăn");
				goToListBySearch(request, response);
				break;
			default:
				listMonAn(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void goToHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/monan/home-khachhang.jsp");
		dispatcher.forward(request, response);
	}

	private void goToDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		MonAn423 monan = monAnDAO423.selectMOnAn(id);
		request.setAttribute("monan", monan);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/monan/monan-form.jsp");
		dispatcher.forward(request, response);
	}

	private void listMonAn(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<MonAn423> list = new ArrayList<>();
		request.setAttribute("listMonAn", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/monan/monan-list.jsp");
		dispatcher.forward(request, response);
	}

	private void goToListBySearch(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String key = request.getParameter("ten");
		List<MonAn423> list = monAnDAO423.selectAllMonAnByName(key);
		
		request.setAttribute("listMonAn", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/monan/monan-list.jsp");
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
