package ptinews.api.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ptinews.entity.CategoryEntity;
import ptinews.service.ICategoryService;
import ptinews.service.impl.CategoryService;
import ptinews.utils.HttpUtil;

@WebServlet(urlPatterns = {"/admin/api/v1/category"})
public class CategoryAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ICategoryService categoryService;
	
	public CategoryAPI() {
		categoryService = new CategoryService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		CategoryEntity category = HttpUtil.of(req.getReader()).toModel(CategoryEntity.class);
		categoryService.addCategory(category);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
	}
}
