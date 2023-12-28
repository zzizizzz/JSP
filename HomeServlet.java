package app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet{
	
	// 서블릿의 초기화를 담당하는 메소드다.
	// 서블릿객체는 생성자 메소드 대신 init()메소드에서 초기화작업을 실행한다.
	@Override
	public void init() throws ServletException {
		System.out.println("HomeServlet의 init() 실행됨");
	}
	
	// 서블릿 객체가 폐기되기 직전에 실행되는 메소드다.
	// 서블릿 객체가 사용한 자원을 반납하는 작업을 수행한다.
	public void destory() {
	System.out.println("HomeServlet의 destory() tlfgodehla");
	}
	
	// 클라이언트에서 HTTP요청이 올때마다 실행되는 메소드다.
	// 클라이언트의 요청을 분석해서 적절한 응답을 제공하는 작업을 수행한다.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("HomeServlet의 service()실행됨");
		
		String message = "샘플 홈입니다.";
		
		res.setContentType("text/htm; charser=UTF-8");
		PrintWriter out = res.getWriter();
		
		out.println("<!doctype html>");
		out.println("<html lang='ko'>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>sample</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>"+message+"<h1>");
		out.println("</body>");
		out.println("</html>");
	}
}

