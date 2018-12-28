package cn.jingchengyuanda.supermarketonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jingchengyuanda.supermarketonline.base.BaseAdminUserController;
import cn.jingchengyuanda.supermarketonline.model.TbSubTypeModel;
import cn.jingchengyuanda.supermarketonline.service.SubTypeService;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

/**
 * 
 * @author fengxiuyuan
 *
 */
@RestController
@RequestMapping("/subtype")
public class SubTypeController extends BaseAdminUserController {

  @Autowired
  private SubTypeService subTypeService;

  @RequestMapping("/disable")
  public JsonMessage disable(TbSubTypeModel model) throws Exception {
    return subTypeService.disable(model);
  }
   
  @RequestMapping("/enable")
  public JsonMessage enable(TbSubTypeModel model) throws Exception {
    return subTypeService.enable(model);
  }
  
  @RequestMapping("/update")
  public JsonMessage update(TbSubTypeModel model) throws Exception {
    return subTypeService.update(model);
  }
  
  @RequestMapping("/add")
  public JsonMessage add(TbSubTypeModel model) throws Exception {
    return subTypeService.add(model);
  }
  
  @RequestMapping("/queryAll")
  public JsonMessage queryAll(TbSubTypeModel model) throws Exception {
    return subTypeService.queryAll(model);
  }
}
