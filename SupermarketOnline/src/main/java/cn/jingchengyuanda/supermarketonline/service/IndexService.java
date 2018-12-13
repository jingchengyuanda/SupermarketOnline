package cn.jingchengyuanda.supermarketonline.service;

import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

/**
 * Index服务类
 *
 * @author DarkKnight
 *
 */
public interface IndexService {

  /**
   * -首页显示信息
   * 
   * @return
   * @throws Exception
   */
  JsonMessage index() throws Exception;

}
