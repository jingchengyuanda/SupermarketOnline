package cn.jingchengyuanda.supermarketonline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jingchengyuanda.supermarketonline.base.BaseAdminUserController;
import cn.jingchengyuanda.supermarketonline.model.ConfigModel;
import cn.jingchengyuanda.supermarketonline.service.ConfigService;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

/**
 * 
 * @author fengxiuyuan
 *
 */
@RestController
@RequestMapping("/config")
public class ConfigController extends BaseAdminUserController {

  @Autowired
  private ConfigService configService;

  @RequestMapping("/queryConfig")
  public JsonMessage queryConfig(ConfigModel model) throws Exception {
    return configService.queryConfig(model);
  }

  @RequestMapping("/updateTokenTimeout")
  public JsonMessage updateTokenTimeout(ConfigModel model) throws Exception {
    return configService.updateTokenTimeout(model);
  }

  @RequestMapping("/updateTitle")
  public JsonMessage updateTitle(ConfigModel model) throws Exception {
    return configService.updateTitle(model);
  }
}
