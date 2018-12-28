package cn.jingchengyuanda.supermarketonline.dao;
/**
 * 
 * @author fengxiuyuan
 *
 */

import org.apache.ibatis.annotations.Mapper;

import cn.jingchengyuanda.supermarketonline.entity.TbAdminUser;
import cn.jingchengyuanda.supermarketonline.entity.TbTokenInfo;
@Mapper
public interface TbAdminUserDAO {
  /**
   * -按照用户名查询用户信息
   * @param user
   * @return 按照用户名查询用户信息结果
   * @throws Exception 处理发生错误
   */
  TbAdminUser  queryByUsername(TbAdminUser user) throws Exception;
  /**
   * -按照主键查询用户信息
   * @param user
   * @return 按照主键查询用户信息结果
   * @throws Exception 处理发生错误
   */
  TbAdminUser queryByKey(TbAdminUser user) throws Exception;
  /**
   * -查询用户登录信息 
   * @param user
   * @return 查询用户登录信息 结果
   * @throws Exception 处理发生错误
   */
  TbAdminUser queryTokenUser(TbTokenInfo tbTokenInfo)throws Exception;
  /**
   * -添加登录用户信息
   * @param tbTokenInfo
   * @return 添加登录用户信息结果
   * @throws Exception 处理发生错误
   */
  int saveUserToToken(TbTokenInfo tbTokenInfo)throws Exception;
  /**
   * -修改登录用户信息
   * @param tbTokenInfo
   * @return 修改登录用户信息结果
   * @throws Exception 处理发生错误
   */
  int updateTokenUser(TbTokenInfo tbTokenInfo)throws Exception;
  /**
   * -移除登录用户登录信息
   * @param tbTokenInfo
   * @return
   * @throws Exception 处理发生错误
   */
  int deleteTokenUser(TbTokenInfo tbTokenInfo)throws Exception;

}
