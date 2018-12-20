package cn.jingchengyuanda.supermarketonline.model;

import cn.jingchengyuanda.supermarketonline.base.BasePageModel;
import cn.jingchengyuanda.supermarketonline.entity.TbSubType;

public class TbSubTypeModel extends BasePageModel {

  private static final long serialVersionUID = -7833570884540604829L;
  private TbSubType tbSubType = new TbSubType();

  public TbSubTypeModel() {

  }

  public TbSubType getTbSubType() {
    return tbSubType;
  }

  public void setTbSubType(TbSubType tbSubType) {
    this.tbSubType = tbSubType;
  };

}
