package main.com.chinasoft.javaweb2021.service.impl;

import main.com.chinasoft.javaweb2021.dao.IUserManageDao;
import main.com.chinasoft.javaweb2021.dao.impl.UserManageDaoImpl;
import main.com.chinasoft.javaweb2021.service.IUserManageService;

import java.util.List;
import java.util.Map;

public class UserManageServiceImpl implements IUserManageService {
    private IUserManageDao dao=new UserManageDaoImpl();

    @Override
    public List<Map<String, Object>> selectUserWheres(String[] selectWheres, String[] s) {
        return dao.selectUserWheres(selectWheres, s);
    }

    @Override
    public int updatePwd(String[] s) {
        return dao.updatePwd(s);
    }

    @Override
    public int insertUserByOne(String[] s) {
        return dao.insertUserByOne(s);
    }

    @Override
    /*  检索新闻信息*/
    public List<Map<String, Object>> selectTelWheres(String[] selectWheres, String[] s) {
        return dao.selectTelWheres(selectWheres, s);
    }

    @Override
    public int updateOrDeleteTel(Map<String, Object> map) {
        return dao.updateOrDeleteTel(map);
    }
}
