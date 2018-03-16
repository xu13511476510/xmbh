package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import DBHelp.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
public class FalseUserServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
	
    private String action ; 
	public FalseUserServlet() {
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
		String uid = (request.getParameter("uid"));
		
		if(request.getParameter("del")!=null)
		{
			action = request.getParameter("del");
			System.out.println(action);
			if(action.equals("����û�")) 
			{
				try {
					Connection con = DBConnection.connect();
					String sql = "update falseuser set fusituation = '1' where fuid=?;";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, uid);
					ps.execute();
					String sql1="update user set ucondition = '0' where uid=?;";
					PreparedStatement ps1 = con.prepareStatement(sql1);
					ps1.setString(1, uid);
					ps1.execute();	
					
					String sql2="insert into message(muid1,muid2,mtext,msituation,mtime)"
							+"values(?,?,?,?,sysdate())"
							;
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setString(1, "00000000001");
					ps2.setString(2, uid);
					ps2.setString(3,"���������û��ٱ��ѱ����,�����������ҿͷ�");
					ps2.setInt(4, 7);
					ps2.execute();	
					
					con.close();
					request.getRequestDispatcher("/FalseUser.jsp").forward(request, response);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}							
			}
			else if(action.equals("���Ծٱ�")) 
			{
				try {
					Connection con = DBConnection.connect();
					String sql = "update falseuser set fusituation = '1' where fuid=?;";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, uid);
					ps.execute();
					request.getRequestDispatcher("/FalseUser.jsp").forward(request, response);
					con.close();
				} 
				catch (Exception e) {
					e.printStackTrace();
				}															
			}
			}else
			{
				System.out.println("����");
			}
         }

}
