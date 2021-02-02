package main.com.chinasoft.javaweb2021.controller;

import com.alibaba.fastjson.JSONObject;
import main.com.chinasoft.javaweb2021.service.IUserManageService;
import main.com.chinasoft.javaweb2021.service.impl.UserManageServiceImpl;
import main.com.chinasoft.javaweb2021.util.RequestUtil;
import main.com.chinasoft.javaweb2021.util.ReturnData;
import main.com.chinasoft.javaweb2021.util.StatusCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private IUserManageService service=new UserManageServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out =response.getWriter();
        Map<String,Object> map= RequestUtil.getQueryMap(request);

        String[] s={map.get("userName")+"",map.get("userPassWord")+""};
        String[] selectWheres={"ttu.user_name","ttu.user_password"};
        List<Map<String,Object>> list=service.selectUserWheres(selectWheres, s);

        if (list.size()<=0){
            out.print(JSONObject.toJSON(new ReturnData(StatusCode.ACCOUNT_OR_PASSWORD_ERROR,list,"登录不成功!")));
        }else {
            request.getSession().setAttribute(StatusCode.SESSION_USER_KEY, list.get(0));
            out.print(JSONObject.toJSON(new ReturnData(StatusCode.LOGIN_SUCCESS, list.get(0), "前后端交互成功！")));
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
