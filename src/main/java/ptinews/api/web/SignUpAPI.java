package ptinews.api.web;

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

@WebServlet(urlPatterns = { "/api/v1/signup" })
public class SignUpAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	IUserService userService;
	
	public SignUpAPI() {
		userService = new UserService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		UserEntity user = HttpUtil.of(req.getReader()).toModel(UserEntity.class);
		userService.addUser(user.getUsername(), user.getPassword(), user.getEmail());
	}
}
 