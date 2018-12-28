package cn.jingchengyuanda.supermarketonline.aop;

import cn.jingchengyuanda.supermarketonline.entity.TbAdminUser;

/**
 * -需要登录的接口定义
 * @author fengxiuyuan
 *
 */
public interface NeedAdminUser {
  /**
   *-设置登录用户信息
   * @param user
   */
  public void setUser(TbAdminUser user);
  /**
   * -获取登录用户信息
   * @return 登录用户信息
   */
  public TbAdminUser getUser();

}
