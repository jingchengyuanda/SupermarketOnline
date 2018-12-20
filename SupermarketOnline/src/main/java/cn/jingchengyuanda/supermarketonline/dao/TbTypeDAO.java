package cn.jingchengyuanda.supermarketonline.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.jingchengyuanda.supermarketonline.entity.TbType;

/**
 * 
 * @author fengxiuyuan
 *
 */
@Mapper

public interface TbTypeDAO {
  /**
        *   分页查询
   * @return 分页查询结果
   * @throws Exception 处理发生错误
   */
  public List<TbType> queryAll() throws Exception;

  /**
   * - 按主键查询
   * @param tbType
   * @return
   * @throws Exception 处理发生错误
   */
  
  public TbType queryByKey(TbType tbType) throws Exception;
  
  /**
   *-按照名称查询
   * @param tbType
   * @return
   * @throws Exception 处理发生错误
   */
  public TbType queryByTypeName(TbType tbType) throws Exception;
  /**
   *  -添加
   * @param tbType 添加数据
   * @return 添加结果
   * @throws Exception处理发生错误
   */
  int add(TbType tbType) throws Exception;
  /**
   * -修改
   * @param tbType 修改数据
   * @return 修改结果
   * @throws Exception 处理发生错误
   */
  int update(TbType tbType) throws Exception;
  /**
   * -删除或者返删除
   * @param tbType 删除数据
   * @return 删除或者返删除结果
   * @throws Exception 处理发生错误
   */
  int delete(TbType tbType) throws Exception;

}
