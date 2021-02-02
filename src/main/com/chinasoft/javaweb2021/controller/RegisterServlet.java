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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private IUserManageService service=new UserManageServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json; charset=utf-8");
        PrintWriter out =response.getWriter();
        Map<String,Object> map= RequestUtil.getQueryMap(request);
        List<String> list=(List<String>) JSONObject.toJSON(map.values());
        String[] s=new String[list.size()];
        for(int i=0;i<list.size();i++){
            s[i]=list.get(list.size()-1-i);
            System.out.println(s[i]);
        }

        if(service.insertUserByOne(s)>0){
            out.print(JSONObject.toJSON(new ReturnData(StatusCode.REQUEST_SUCCESS,true, "数据新增成功")));
        }else{
            out.print(JSONObject.toJSON(new ReturnData(StatusCode.REQUEST_ERROR, "数据新增失败！")));
        }

        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
