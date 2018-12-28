package cn.jingchengyuanda.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jingchengyuanda.supermarketonline.dao.TbConfigDAO;
import cn.jingchengyuanda.supermarketonline.dao.TbLogsDAO;
import cn.jingchengyuanda.supermarketonline.entity.TbLogs;
import cn.jingchengyuanda.supermarketonline.model.ConfigModel;
import cn.jingchengyuanda.supermarketonline.service.ConfigService;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

@Service
@Transactional(rollbackFor = Exception.class)
public class ConfigServiceImpl implements ConfigService {

  @Autowired
  private TbConfigDAO tbConfigDAO;
  @Autowired
  private TbLogsDAO tbLogsDAO;

  @Override
  public JsonMessage queryWebConfig(ConfigModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.put("title", tbConfigDAO.queryTitle());
    return message;
  }

  @Override
  public JsonMessage queryConfig(ConfigModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    message.put("tokenTimeout", tbConfigDAO.queryTokenTimeout());
    message.put("title", tbConfigDAO.queryTitle());
    return message;
  }

  @Override
  public JsonMessage updateTokenTimeout(ConfigModel model) throws Exception {
    int result = tbConfigDAO.updateTokenTimeout(model.getConfig());
    // 添加日志信息
    TbLogs logs = new TbLogs();
    // 操作员
    logs.setOperator(model.getTbAdminUser().getAuid().toString());
    // 类型
    logs.setLogtype("configmanage");
    // 信息
    logs.setLog(String.format("修改了:%s", model.getTbAdminUser()));
    tbLogsDAO.add(logs);
    return result == 1 ? JsonMessage.getSuccess("修改成功") : JsonMessage.getFail("修改成功");
  }

  @Override
  public JsonMessage updateTitle(ConfigModel model) throws Exception {
    int result = tbConfigDAO.updateTitle(model.getConfig());
    // 添加日志信息
    TbLogs logs = new TbLogs();
    // 操作员
    logs.setOperator(model.getTbAdminUser().getAuid().toString());
    // 类型
    logs.setLogtype("configmanage");
    // 信息
    logs.setLog(String.format("修改了:%s", model.getTbAdminUser()));
    tbLogsDAO.add(logs);
    return result == 1 ? JsonMessage.getSuccess("修改成功") : JsonMessage.getFail("修改成功");
  }
}
