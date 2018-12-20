package cn.jingchengyuanda.supermarketonline.model;

import cn.jingchengyuanda.supermarketonline.base.BasePageModel;
import cn.jingchengyuanda.supermarketonline.entity.TbType;

public class TbTypeModel extends BasePageModel {

  private static final long serialVersionUID = -4898566211010926315L;

  private TbType tbType = new TbType();

  public TbTypeModel() {

  }

  public TbType getTbType() {
    return tbType;
  }

  public void setTbType(TbType tbType) {
    this.tbType = tbType;
  }

}
