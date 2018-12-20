package cn.jingchengyuanda.supermarketonline.service;

import cn.jingchengyuanda.supermarketonline.model.TbTypeModel;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;

/**
 * Type服务
 * 
 * @author fengxiuyuan
 *
 */
public interface TypeService {
  /**
   * -查询全部
   * 
   * @param model 页面数据
   * @return 查询结果
   * @throws Exception 处理发生异常
   */
  JsonMessage queryAll(TbTypeModel model) throws Exception;

  /**
   * -添加
   * 
   * @param model 页面数据
   * @return 添加结果
   * @throws Exception 处理发生异常
   */
  JsonMessage add(TbTypeModel model) throws Exception;

  /**
   * -修改
   * @param model 页面数据
   * @return 修改结果
   * @throws Exception 处理发生异常
   */
  JsonMessage update(TbTypeModel model) throws Exception;

  /**
   * -删除
   * @param model 页面数据
   * @return 删除结果
   * @throws Exception 处理发生异常
   */
  JsonMessage delete(TbTypeModel model) throws Exception;

  /**
   * -主键查询
   * @param model 页面数据
   * @return 主键查询结果
   * @throws Exception 处理发生异常
   */
  JsonMessage queryByKey(TbTypeModel model) throws Exception;
  /**
   * -返删除
   * @param model 页面数据
   * @return 返删除结果
   * @throws Exception 处理发生异常
   */
  JsonMessage undelete(TbTypeModel model) throws Exception;

}
