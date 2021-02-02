package main.com.chinasoft.javaweb2021.dao.impl;

import main.com.chinasoft.javaweb2021.basedao.BaseDao;
import main.com.chinasoft.javaweb2021.dao.IUserManageDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManageDaoImpl extends BaseDao implements IUserManageDao {
    static Connection con=null;
    static PreparedStatement stmt=null;
    static ResultSet set=null;

    @Override
    /* 登录*/
    public List<Map<String, Object>> selectUserWheres(String[] selectWheres, String[] s) {
        String sql="select ttu.user_id as userId,"+
                "ttu.user_name as userName," +
                "ttu.user_password as userPassWord," +
                "ttu.role_id as roleId from tt_user as ttu";
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        try {
            con=getConnection();
            if (selectWheres.length>0&&s.length>0){
                sql+=" where ";
                for (int i=0;i<selectWheres.length;i++){
                    if (i>=1){
                        sql+=" and "+selectWheres[i]+" ";
                    }else {
                        sql+=selectWheres[i]+" ";
                    }
                    if(selectWheres[i].indexOf("user_name")>-1&&s[i].indexOf("%")>-1){
                        sql+=" like  ? ";
                    }else{
                        sql+=" = ? ";
                    }
                }
                stmt=con.prepareStatement(sql);
                for (int i=0;i<s.length;i++){
                    stmt.setString(i+1,s[i]);
                }
            }else {
                stmt=con.prepareStatement(sql);
            }

            /*执行sql指令  检索查询*/
            set=stmt.executeQuery();
            while (set.next()){
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("userId",set.getString("userId"));
                map.put("userName",set.getString("userName"));
                map.put("userPassWord",set.getString("userPassWord"));
                map.put("roleId",set.getString("roleId"));
                list.add(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(con,stmt,set);
        }
        return list;
    }

    @Override
    public int updatePwd(String[] s) {
        return 0;
    }

    @Override
    /* 注册*/
    public int insertUserByOne(String[] s) {
        String sql="insert into tt_user(user_name,user_password,role_id) values(?,?,1);";
        return saveOrUpdateOrDel(sql, s);
    }

    @Override
    /* 新闻 检索*/
    public List<Map<String, Object>> selectTelWheres(String[] selectWheres, String[] s) {
        String sql="select ttn.news_id as newsId,"+
                "ttn.news_name as newsName," +
                "ttn.news_img as newsImg," +
                "ttn.user_name as userName from tt_news as ttn";
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        try {
            con=getConnection();
            if (selectWheres.length>0&&s.length>0){
                sql+=" where ";
                for (int i=0;i<selectWheres.length;i++){
                    if (i>=1){
                        sql+=" and "+selectWheres[i]+" ";
                    }else {
                        sql+=selectWheres[i]+" ";
                    }
                    if(selectWheres[i].indexOf("news_name")>-1&&s[i].indexOf("%")>-1){
                        sql+=" like  ? ";
                    }else{
                        sql+=" = ? ";
                    }
                }

                stmt=con.prepareStatement(sql);
                for (int i=0;i<s.length;i++){
                    stmt.setString(i+1,s[i]);

                }
            }else {
                stmt=con.prepareStatement(sql);
            }

            /*执行sql指令  检索查询*/

            set=stmt.executeQuery();
            while (set.next()){
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("newsId",set.getString("newsId"));
                map.put("newsName",set.getString("newsName"));
                map.put("newsImg",set.getString("newsImg"));
                map.put("userName",set.getString("userName"));
                list.add(map);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            close(con,stmt,set);
        }
        return list;
    }

    @Override
    public int updateOrDeleteTel(Map<String, Object> map) {
        return 0;
    }
}
