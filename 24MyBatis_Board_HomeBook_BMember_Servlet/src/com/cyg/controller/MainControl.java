package com.cyg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyg.service.*;

/**
 * Servlet implementation class MainControl
 */
@WebServlet("*.do")
public class MainControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ActionDo Method");
		String uri = request.getRequestURI();
		System.out.println(uri);
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		String command = uri.substring(contextPath.length());
		System.out.println(command);
		// aaaa/bbbb/xxxx.do
		Service service = null; // Created Interface
		PrintWriter out = null;
		switch (command) {
		case "/login/login.do":
			System.out.println(command + "를 처리합니다.");
			try {
				service = new LoginService();
				boolean res = service.execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/mymember/bmemberJoin.do":
			System.out.println(command + "를 처리합니다.");
			try {
				service = new MemberJoinService();
				boolean res = service.execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/mymember/MemberInfo.do":
			System.out.println(command + "를 처리합니다.");
			try {
				service = new MemberInfoService();
				boolean res = service.execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/mymember/confirmId.do":
			System.out.println(command + "를 처리합니다.");
			try {
				boolean res = new ConfirmIdService().execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/mymember/MemberInfoAdjust.do":
			System.out.println(command + "를 처리합니다.");
			try {
				service = new MemberInfoAdjustService();
				boolean res = service.execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/main.do":
			System.out.println(command + "를 처리합니다.");
			try {
				service = new MainService();
				boolean res = service.execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/mymember/memberList.do":
			System.out.println(command + "를 처리합니다.");
			try {
				service = new AllMemberListService();
				boolean res = service.execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/login/Logout.do":
			System.out.println(command + "를 처리합니다.");
			try {
				service = new LogoutService();
				boolean res = service.execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/homebook/homebook.do":
			System.out.println(command + "를 처리합니다.");
			try {
				service = new HomeBookInsertService();
				boolean res = service.execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/homebook/homebookinfo.do":
			System.out.println(command+"를 처리합니다.");
			try {
				boolean res = new HomeBookInfoService().execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/homebook/homebookallinfo.do":
			System.out.println(command+"를 처리합니다.");
			try {
				boolean res = new HomeBookInfoServiceAll().execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/Login/password.do":
			System.out.println(command+"를 처리합니다.");
			try {
				boolean res = new PasswordSeekService().execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Login처리부분
			break;
		case "/homebook/homebookadjust.do":
			System.out.println(command+"를 처리합니다.");
			try {
				boolean res = new HomeBookAdjustService().execute(request, response);
				System.out.println(res);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		}

	}
}
