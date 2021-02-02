package main.com.chinasoft.javaweb2021.basedao;

import java.sql.*;
public class BaseDao {
    private static String account="";
    private static String password="";
    private static String url="";
    private static String driverName="";

    static{
        account="root";
        password="123456";
        url="jdbc:mysql://127.0.0.1:3306/javaweb2021?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true";
        driverName="com.mysql.cj.jdbc.Driver";

    }


    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName(driverName);
            con= DriverManager.getConnection(url, account, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }


    public static void close(Connection con, PreparedStatement stmt, ResultSet set){
        if(set!=null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*JDBC中  DML操作 增删改  返回影响行int sql指令迭代拼接占位符过程*/
    public int saveOrUpdateOrDel(String sql,String[] s){
        int count=0;
        Connection con=getConnection();
        PreparedStatement stmt=null;
        try {
            stmt=con.prepareStatement(sql);
            if(s!=null){
                for(int i=0;i<s.length;i++){
                    stmt.setString(i+1, s[i]);
                }
                count=stmt.executeUpdate();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally {
            close(con, stmt, null);
        }
        return count;
    }


}
