package cn.jingchengyuanda.supermarketonline.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.jingchengyuanda.supermarketonline.entity.TbConfig;

/**
 * 
 * @author fengxiuyuan
 *
 */
@Mapper
public interface TbConfigDAO {
  /**
   * 查询网站标题查询
   * 
   * @return 网站标题配置
   * @throws Exception
   */
  TbConfig queryTitle() throws Exception;

  int updateTitle(TbConfig tbConfig) throws Exception;

  /**
   * 
   * @return
   * @throws Exception
   */
  TbConfig queryTokenTimeout() throws Exception;

  /**
   * 
   * @return
   * @throws Exception
   */
  int updateTokenTimeout(TbConfig tbConfig) throws Exception;

}
