package cn.jingchengyuanda.supermarketonline.model;

import cn.jingchengyuanda.supermarketonline.base.BaseModel;
import cn.jingchengyuanda.supermarketonline.entity.TbConfig;

/**
 * 
 * @author fengxiuyuan
 *
 */
public class ConfigModel extends BaseModel {

  private static final long serialVersionUID = -8138271114119019597L;
  
  private TbConfig config =new TbConfig();
  
  public ConfigModel() {
    
  }

  public TbConfig getConfig() {
    return config;
  }

  public void setConfig(TbConfig config) {
    this.config = config;
  }

}
