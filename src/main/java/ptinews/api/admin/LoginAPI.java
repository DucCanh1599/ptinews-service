package ptinews.api.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

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
		user = userService.checkLogin(user);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(user);
		resp.setContentType("application/json; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		OutputStream out = resp.getOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(out);
		writer.write(json);
		writer.close();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	}
}
