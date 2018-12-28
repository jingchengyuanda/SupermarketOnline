package cn.jingchengyuanda.supermarketonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jingchengyuanda.supermarketonline.base.BaseAdminUserController;
import cn.jingchengyuanda.supermarketonline.model.LogsModel;
import cn.jingchengyuanda.supermarketonline.service.LogsService;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

/**
 * 
 * @author fengxiuyuan
 *
 */
@RestController
@RequestMapping("/logs")
public class LogsController extends BaseAdminUserController {
  
  @Autowired
  private LogsService logsService;
  
  @RequestMapping("/queryAll")
  public JsonMessage queryAll(LogsModel model)throws Exception{
    return logsService.queryAll(model);
  }
}
