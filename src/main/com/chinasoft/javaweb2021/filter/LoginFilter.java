package main.com.chinasoft.javaweb2021.filter;

import com.alibaba.fastjson.JSONObject;
import main.com.chinasoft.javaweb2021.util.ReturnData;
import main.com.chinasoft.javaweb2021.util.StatusCode;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=utf-8");

        if (request.getSession().getAttribute(StatusCode.SESSION_USER_KEY)!=null
                ||request.getServletPath().equals("/toutiao/loginServlet")){

            chain.doFilter(req, resp);
        }else {
            response.getWriter().print(JSONObject.toJSON(new ReturnData(StatusCode.NEED_LOGIN,"用户未登录或异地登录，账户异常。请重新登录")));
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
