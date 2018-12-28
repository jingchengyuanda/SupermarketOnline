package cn.jingchengyuanda.supermarketonline.service;

import cn.jingchengyuanda.supermarketonline.model.LogsModel;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

/**
 * 
 * @author fengxiuyuan
 *
 */
public interface LogsService {
  /**
   * 查询TbLogs信息
   * @param model 页面参数
   * @return TbLogs信息
   * @throws Exception 处理发生异常
   */
  JsonMessage queryAll(LogsModel model) throws Exception;

}
