package ptinews.utils;

import javax.servlet.http.HttpServletRequest;

/*
 * Khi người dùng đăng nhập vào --> lưu thông tin người dùng.
 * putValue(); --> dùng để duy trì thông tin của user khi đăng nhập vào hệ thống.
 * removeValue(); --> xóa thông tin khi user đăng xuất khỏi hệ thống.
 * getValue(); --> lấy thông tin user.
 * */

public class SessionUtil {

	private static SessionUtil sessionUtil = null;

    public static SessionUtil getInstance() {
        if (sessionUtil == null) {
            sessionUtil = new SessionUtil();
        }
        return sessionUtil;
    }

    public void putValue(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    public Object getValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public void removeValue(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }

}
