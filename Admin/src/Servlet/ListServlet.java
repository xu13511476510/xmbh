package Servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemoryUserRepositoryDAO;
import Model.View_Student____;
public class ListServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private List<View_Student____> users;
    private MemoryUserRepositoryDAO repository =new MemoryUserRepositoryDAO();
   
	public ListServlet() {
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
		
			    users = repository.listAll();
				String p = request.getParameter("page");
	        int page;
	        try {
	            //��ǰҳ��
	            page = Integer.valueOf(p);
	        } catch (NumberFormatException e) {
	            page = 1;
	        }
	        //�û�����
	        int totalUsers = users.size();
	        //ÿҳ�û���
	        int usersPerPage = 10;
	        //��ҳ��
	        int totalPages = totalUsers % usersPerPage == 0 ? totalUsers / usersPerPage : totalUsers / usersPerPage + 1;
	        //��ҳ��ʼ�û����
	        int beginIndex = (page - 1) * usersPerPage;
	        //��ҳĩβ�û���ŵ���һ��
	        int endIndex = beginIndex + usersPerPage;
	        if (endIndex > totalUsers)
	            endIndex = totalUsers;
	        request.setAttribute("totalUsers", totalUsers);
	        request.setAttribute("usersPerPage", usersPerPage);
	        request.setAttribute("totalPages", totalPages);
	        request.setAttribute("beginIndex", beginIndex);
	        request.setAttribute("endIndex", endIndex);
	        request.setAttribute("page", page);
	        request.setAttribute("users", users);
	        request.getRequestDispatcher("/Third.jsp").forward(request,response);
				
		
         
	}
	
	
}
