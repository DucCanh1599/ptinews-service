package ptinews.api.admin;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import ptinews.entity.ArticleEntity;
import ptinews.service.IArticleService;
import ptinews.service.impl.ArticleService;
import ptinews.utils.HttpUtil;

@WebServlet(urlPatterns = {"/admin/api/v1/article"})
public class ArticleAPI extends HttpServlet {
	private static final long serialVersionUID = 2L;
	
	private IArticleService articleService;

	public ArticleAPI() {
		articleService = new ArticleService();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String user = "canhnd";
		String tag = "heath";
		String category = "sức khỏe";
		ArticleEntity article = HttpUtil.of(req.getReader()).toModel(ArticleEntity.class);
		articleService.addNewArticle(article, user, tag, category);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		List<ArticleEntity> list = null;
		if (title == null) {
			list = articleService.findAll();
		} else {
			list = articleService.search(title);
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(list);
		resp.setContentType("application/json; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		OutputStream out = resp.getOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(out);
		writer.write(json);
		writer.close();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String encodedId = req.getParameter("id");
		boolean isDeleted = articleService.deleteArticle(encodedId);
		System.out.println(isDeleted);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ArticleEntity article = HttpUtil.of(req.getReader()).toModel(ArticleEntity.class);
		String encodedId = req.getParameter("id");
		articleService.updateArticle(article, encodedId);
	}
}
