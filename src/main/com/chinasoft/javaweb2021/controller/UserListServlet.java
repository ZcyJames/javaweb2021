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

@WebServlet(name = "UserListServlet")
public class UserListServlet extends HttpServlet {
    private IUserManageService service=new UserManageServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=utf-8");

        PrintWriter out = response.getWriter();
        Map<String,Object> map= RequestUtil.getQueryMap(request);
        String[] selectWheres=
                map.get("selectUserWhere").toString().equals("")?new String[]{} :new String[]{map.get("selectUserWhere").toString()};
        String[] s=
                map.get("s").toString().equals("")?new String[]{} :new String[]{map.get("s").toString()};
        List<Map<String,Object>> list=service.selectUserWheres(selectWheres, s);
        out.print(JSONObject.toJSON(new ReturnData(
                list.size()>0? StatusCode.REQUEST_SUCCESS:StatusCode.REQUEST_NOT_DATA,
                list,"用户列表页数据查找正常！")));
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
