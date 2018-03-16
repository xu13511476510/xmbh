package Servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemoryUserRepositoryDAO;
import Model.View_Student____;
public class ButtonServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private List<View_Student____> users;
    private MemoryUserRepositoryDAO repository =new MemoryUserRepositoryDAO();
    private String action ; 
	public ButtonServlet() {
        super();
    }

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		if(request.getParameter("mbutton")!=null)
		{
			action = request.getParameter("mbutton");
			System.out.println(action);
			if(action.equals("�鿴���ٱ���Ŀ")) 
			{
				response.sendRedirect("/Admin/Main.jsp");  
			}
			else if(action.equals("�鿴���ٱ��û�")) 
			{
				response.sendRedirect("/Admin/FalseUser.jsp");  
			}
			
			else if(action.equals("�鿴����ͳ����Ϣ")) 
			{
				response.sendRedirect("/Admin/Fourth.jsp");  
			}else
			{
				System.out.println("����");
			}
         }
		
	}
	
	
}
