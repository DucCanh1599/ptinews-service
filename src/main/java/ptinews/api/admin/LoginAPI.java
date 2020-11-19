package ptinews.api.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ptinews.entity.UserEntity;
import ptinews.service.IUserService;
import ptinews.service.impl.UserService;
import ptinews.utils.HttpUtil;

@WebServlet(urlPatterns = {"/admin/api/v1/login"})
public class LoginAPI extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	IUserService userService;
	
	public LoginAPI() {
		userService = new UserService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserEntity user = HttpUtil.of(req.getReader()).toModel(UserEntity.class);
		int isAdmin = userService.checkLogin(user);
		System.out.println(isAdmin);
	}
}
