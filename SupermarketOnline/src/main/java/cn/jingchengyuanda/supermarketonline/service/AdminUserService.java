package cn.jingchengyuanda.supermarketonline.service;

import cn.jingchengyuanda.supermarketonline.model.AdminUserModel;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

/**
 * 管理用户服务
 * @author fengxiuyuan
 *
 */
public interface AdminUserService {
/**
 * -用户登录
 * @param model 页面数据
 * @return 用户登录结果
 * @throws Exception 处理发生异常
 */
  JsonMessage login(AdminUserModel model) throws Exception;
/**
 * 
 * @param model
 * @return
 * @throws Exception
 */
JsonMessage logout(AdminUserModel model) throws Exception;
/**
 * 
 * @param model
 * @return
 * @throws Exception
 */
JsonMessage getUserInfo(AdminUserModel model) throws Exception;

}
