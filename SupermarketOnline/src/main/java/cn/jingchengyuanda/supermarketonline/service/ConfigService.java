package cn.jingchengyuanda.supermarketonline.service;

import cn.jingchengyuanda.supermarketonline.model.ConfigModel;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

/**
 * 
 * @author fengxiuyuan
 *
 */
public interface ConfigService {
  /**
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage updateTokenTimeout(ConfigModel model) throws Exception;

  /**
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage queryConfig(ConfigModel model) throws Exception;

  /**
   * - 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage updateTitle(ConfigModel model) throws Exception;
  /**-查询前端配置
   * 
   * @param model 页面提交数据
   * @return 前端配置
   * @throws Exception 处理发生错误
   */
  JsonMessage queryWebConfig(ConfigModel model) throws Exception;

}
