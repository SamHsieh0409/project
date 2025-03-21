package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter(urlPatterns = {"/product", "/product/add", "/user"})
//@WebFilter(urlPatterns = {"/product", "/product/*", "/user"})
@WebFilter(urlPatterns = {"/*"})
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("LoginFilter URI: " + request.getRequestURI().toString());
		// 若 URI 是 "/WebCart/login" 或 "/WebCart/CAPTCHA" 或 首頁 則 by pass
		if(request.getRequestURI().toString().equals("/WebCart/login") ||
			request.getRequestURI().toString().equals("/WebCart/CAPTCHA") ||
			request.getRequestURI().toString().equals("/WebCart/index.jsp")) {
			chain.doFilter(request, response);
			return;
		}
		
		// 檢查是否有登入資訊 ?
		HttpSession session = request.getSession();
		if(session.getAttribute("userDto") == null) {
			// 使用者尚未登入, 要帶給 result.jsp 的參數
			request.setAttribute("result", "使用者尚未登入");
			request.setAttribute("redirectURL", "/WebCart/login");
			request.setAttribute("redirectName", "請登入");
			request.getRequestDispatcher("/WEB-INF/view/result.jsp").forward(request, response); 
			return;
		}
		
		// by pass
		chain.doFilter(request, response);
		
	}
	
}