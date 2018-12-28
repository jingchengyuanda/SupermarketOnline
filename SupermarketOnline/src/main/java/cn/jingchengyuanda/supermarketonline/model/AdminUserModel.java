package cn.jingchengyuanda.supermarketonline.model;

import cn.jingchengyuanda.supermarketonline.base.BaseModel;
import cn.jingchengyuanda.supermarketonline.entity.TbAdminUser;
/**
 * 
 * @author fengxiuyuan
 *
 */
public class AdminUserModel extends BaseModel {

  private static final long serialVersionUID = -623042763034786709L;

  private TbAdminUser user = new TbAdminUser();

  public AdminUserModel() {

  }

  public TbAdminUser getUser() {
    return user;
  }

  public void setUser(TbAdminUser user) {
    this.user = user;
  }

}
