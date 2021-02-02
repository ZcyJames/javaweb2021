package main.com.chinasoft.javaweb2021.service;

import java.util.List;
import java.util.Map;

public interface IUserManageService {
    public List<Map<String,Object>>  selectUserWheres(String[] selectWheres, String[]  s);
    public int updatePwd(String[] s) ;
    public int insertUserByOne(String[] s);
    public List<Map<String,Object>> selectTelWheres(String[] selectWheres, String[]  s);
    public int updateOrDeleteTel(Map<String,Object> map);
}
