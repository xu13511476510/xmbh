package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

    /**
     * ����
     */
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //��ȡ��Ŀ¼����Ӧ�ľ���·��
        String currentURL = request.getRequestURI();
        HttpSession session = request.getSession(false);
        if(!currentURL.contains("login.jsp")&&!currentURL.contains("LoginServlet")){
            //�жϵ�ǰҳ���Ƿ����ض��ΰ���ĵ�½ҳ��ҳ�棬����ǾͲ���session���жϣ���ֹ��ѭ��
            if(session==null||session.getAttribute("username")==null){ 
                response.sendRedirect(request.getContextPath()+"/login.jsp?filter=false");
                return;
            }
        }

        //��������ִ��
        chain.doFilter(request, response);
    }

    /**
     * ��ʼ��
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}