package cn.jingchengyuanda.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jingchengyuanda.supermarketonline.config.MyConfig;
import cn.jingchengyuanda.supermarketonline.converter.DateConverter;
import cn.jingchengyuanda.supermarketonline.dao.UtilsDAO;
import cn.jingchengyuanda.supermarketonline.service.IndexService;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

/**
 *
 * @author DarkKnight
 *
 */
@Service
public class IndexServiceImpl implements IndexService {
  @Autowired
  private MyConfig myConfig;
  @Autowired
  private UtilsDAO utilsDAO;

  @Override
  public JsonMessage index() throws Exception {
    JsonMessage message = JsonMessage.getSuccess(String.format("欢迎使用%s，%s", myConfig.appName, DateConverter.SDF_LONG.format(utilsDAO.queryTime())));
    return message;
  }

}
