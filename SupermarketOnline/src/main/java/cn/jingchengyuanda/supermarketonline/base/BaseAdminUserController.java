package cn.jingchengyuanda.supermarketonline.base;

import cn.jingchengyuanda.supermarketonline.aop.NeedAdminUser;
import cn.jingchengyuanda.supermarketonline.entity.TbAdminUser;

public class BaseAdminUserController implements NeedAdminUser {
  // 登录用户信息=====================================================
  /**
   * 登录用户信息
   */
  private TbAdminUser user;

  @Override
  public TbAdminUser getUser() {
    return user;
  }

  @Override
  public void setUser(TbAdminUser user) {
    this.user = user;
  }

  // 登录用户信息=====================================================
}
