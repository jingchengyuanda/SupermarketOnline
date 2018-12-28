package cn.jingchengyuanda.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jingchengyuanda.supermarketonline.dao.TbAdminUserDAO;
import cn.jingchengyuanda.supermarketonline.dao.TbLogsDAO;
import cn.jingchengyuanda.supermarketonline.entity.TbAdminUser;
import cn.jingchengyuanda.supermarketonline.entity.TbLogs;
import cn.jingchengyuanda.supermarketonline.entity.TbTokenInfo;
import cn.jingchengyuanda.supermarketonline.model.AdminUserModel;
import cn.jingchengyuanda.supermarketonline.service.AdminUserService;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;
import cn.jingchengyuanda.supermarketonline.utils.MyUtils;

/**
 * 
 * @author fengxiuyuan
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AdminUserServiceImpl implements AdminUserService {

  private static final String Y = "y";
  @Autowired
  private TbAdminUserDAO tbAdminUserDAO;
  @Autowired
  private TbLogsDAO tbLogsDAO;

  @Override
  public JsonMessage login(AdminUserModel model) throws Exception {
    TbAdminUser user = model.getUser();
    if (MyUtils.isEmpty(user.getUsername())) {
      return JsonMessage.getFail("用户名必须填写");

    }
    if (MyUtils.isEmpty(user.getPassword())) {
      return JsonMessage.getFail("密码必须填写");

    }
    TbAdminUser suser = tbAdminUserDAO.queryByUsername(user);
    if (suser == null) {
      return JsonMessage.getFail("用户名不存在");
    }

    if (!Y.equalsIgnoreCase(suser.getIsEnable())) {
      return JsonMessage.getFail("用户已经冻结");
    }
    if (!suser.getPassword().equalsIgnoreCase(user.getPassword())) {
      return JsonMessage.getFail("密码错误");
    }
    // 登录成功需要添加tokeninfo
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    tokenInfo.setInfo(suser.getAuid() + "");
    // 查看是否存在token中是否存在
    TbAdminUser tuser = tbAdminUserDAO.queryTokenUser(tokenInfo);
    if (tuser != null) {
      // 存在就删除
      tbAdminUserDAO.deleteTokenUser(tokenInfo);
    }
    tbAdminUserDAO.saveUserToToken(tokenInfo);
    //记录登录信息
    TbLogs logs =new TbLogs();
    logs.setOperator(tokenInfo.getInfo());
    logs.setLogtype("login");
    logs.setLog("用户登录");
    tbLogsDAO.add(logs);
    return JsonMessage.getSuccess("登录成功");
  }

  @Override
  public JsonMessage getUserInfo(AdminUserModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
   TbAdminUser user=tbAdminUserDAO.queryTokenUser(model.makeTbTokenInfo());
    if (user!=null) {
      //除掉敏感信息
      user.setAuid(null);
      user.setPassword(null);
      
    }
    message.put("user", user);
    return message;
  }

  @Override
  public JsonMessage logout(AdminUserModel model) throws Exception {
    tbAdminUserDAO.deleteTokenUser(model.makeTbTokenInfo());
    return JsonMessage.getSuccess("退出成功");
  }

}
