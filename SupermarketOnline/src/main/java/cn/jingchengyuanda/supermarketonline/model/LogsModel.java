package cn.jingchengyuanda.supermarketonline.model;

import cn.jingchengyuanda.supermarketonline.base.BasePageModel;
import cn.jingchengyuanda.supermarketonline.entity.TbLogs;
/**
 * 
 * @author fengxiuyuan
 *
 */
public class LogsModel extends BasePageModel {

  private static final long serialVersionUID = -4547024008027832663L;

  private TbLogs tbLogs = new TbLogs();

  public LogsModel() {

  }

  public TbLogs getTbLogs() {
    return tbLogs;
  }

  public void setTbLogs(TbLogs tbLogs) {
    this.tbLogs = tbLogs;
  }

}
