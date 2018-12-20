package cn.jingchengyuanda.supermarketonline.entity;

import java.util.Date;

import cn.jingchengyuanda.supermarketonline.base.BaseEntity;
/**
 * 
 * @author fengxiuyuan
 *
 */
public class TbConfig extends BaseEntity {

  private static final long serialVersionUID = -1488473125251713954L;
  
  private  String configKey;
  private String configValue;
  private Date lastupdate;
  
  public TbConfig()
  {
    
  }

  public String getConfigKey() {
    return configKey;
  }

  public void setConfigKey(String configKey) {
    this.configKey = configKey;
  }

  public String getConfigValue() {
    return configValue;
  }

  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }
  
}
