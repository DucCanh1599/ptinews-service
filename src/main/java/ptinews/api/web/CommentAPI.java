package ptinews.api.web;

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

import ptinews.entity.CommentEntity;
import ptinews.service.ICommentService;
import ptinews.service.impl.CommentService;
import ptinews.utils.HttpUtil;

@WebServlet(urlPatterns = {"/admin/api/v1/comment"})
public class CommentAPI extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	ICommentService commentService;
	
	public CommentAPI() {
		commentService = new CommentService();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String userEmail = "canhnd@gmail.com";
		String articleId = "5f74dc4b-cf0f-42ec-8697-86ad8a791c51";
		CommentEntity comment = HttpUtil.of(req.getReader()).toModel(CommentEntity.class);
		commentService.addNewComment(comment, userEmail, articleId);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String articleId = req.getParameter("articleId");
		List<CommentEntity> list = commentService.findByArticleId(articleId);
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
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String encodedId = req.getParameter("id");
		boolean isDeleted = commentService.deleteComment(encodedId);
		System.out.println(isDeleted);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String articleId = req.getParameter("articleId");
	}
	
}
