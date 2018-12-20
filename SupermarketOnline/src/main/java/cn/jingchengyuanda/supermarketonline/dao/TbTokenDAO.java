package cn.jingchengyuanda.supermarketonline.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.jingchengyuanda.supermarketonline.entity.TbToken;

/**
 * TbToken-数据访问类
 *
 * @author DarkKnight
 *
 */
@Mapper
public interface TbTokenDAO {
  /**
   * addToken-添加token
   *
   * @param token  添加token
   * @return 返回token
   * @throws Exception 处理发生错误
   */
  int addToken(TbToken token) throws Exception;

  /**
   * updateToken-更新token时间
   *
   * @param token 更新token时间
   * @return 返回数据
   * @throws Exception 处理发生错误
   */
  int updateToken(TbToken token) throws Exception;

  /**
   * queryToken-查询token是否存在
   *
   * @param token  查询token是否存在
   * @return 返回数据
   * @throws Exception 处理发生错误
   */
  TbToken queryToken(TbToken token) throws Exception;

  /**
   * deleteTokens-删除过期的token
   *
   * @return 返回数据
   * @throws Exception 处理发生错误
   */
  int deleteTokens() throws Exception;

}
