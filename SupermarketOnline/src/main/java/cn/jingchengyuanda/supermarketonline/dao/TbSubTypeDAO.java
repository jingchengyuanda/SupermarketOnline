package cn.jingchengyuanda.supermarketonline.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.jingchengyuanda.supermarketonline.entity.TbSubType;
import cn.jingchengyuanda.supermarketonline.entity.TbType;

/**
 * -TbSubTypeDAO数据访问层
 * @author fengxiuyuan
 *
 */
@Mapper
public interface TbSubTypeDAO {
  /**
   * 
   * @return
   * @throws Exception 处理发生异常
   */
  List<TbType> queryType()throws Exception;
  /**
   * 
   * @return
   * @throws Exception 处理发生异常
   */
  List<TbSubType> queryAll() throws Exception;
  /**
   * -按照tid和subName查询小类信息
   * @param tbSubType 小类信息
   * @return 小类信息结果
   * @throws Exception 处理发生异常
   */
  TbSubType  queryByTidSubName(TbSubType tbSubType)throws Exception;
  /**
   * -按照主键查询
   * @param tbSubType
   * @return
   * @throws Exception
   */
  TbSubType  queryByKey(TbSubType tbSubType)throws Exception;
  /**
   * 
   * @param tbSubType
   * @return
   * @throws Exception 处理发生异常
   */
  int add(TbSubType tbSubType) throws Exception;
  /**
   * 
   * @param tbSubType
   * @return
   * @throws Exception 处理发生异常
   */
  int update(TbSubType tbSubType)throws Exception;
  /**
   * -修改启用状态
   * @param tbSubTypeb 小类信息
   * @return 修改启用状态状态
   * @throws Exception 处理发生异常
   */
  int  updateIsEnable(TbSubType tbSubTypeb) throws Exception;
  
  

}
