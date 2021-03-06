package com.houzhuo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.houzho.service.CheckUserService;
import com.houzhuo.entity.User;

/**
 * 作为一个控制器。根据checkUserService的校验结果进行处理
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CheckUserService cku = new CheckUserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

		/*
		 * 业务逻辑实现
		 */
		
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//取得参数username的值
			String uname = request.getParameter("uname");
			String passwd = request.getParameter("upwd");
			
			System.out.println("用户名 ==》 " + uname);
			System.out.println("密码 ==》 " + passwd);

			RequestDispatcher rd = null;
			String forward = null;
			if (uname == null || passwd == null) {
				request.setAttribute("msg", "用户名或密码为空");
				rd = request.getRequestDispatcher("/servlet2/error.jsp");
				rd.forward(request, response);
			} else {
				User user = new User();
				user.setName(uname);
				user.setPassword(passwd);
				boolean bool = cku.check(user);

				if (bool) {
					forward = "/servlet2/success.jsp";
				} else {
					forward = "/servlet2/error.jsp";
				}

				rd = request.getRequestDispatcher(forward);
				rd.forward(request, response);
			}
		}

}
