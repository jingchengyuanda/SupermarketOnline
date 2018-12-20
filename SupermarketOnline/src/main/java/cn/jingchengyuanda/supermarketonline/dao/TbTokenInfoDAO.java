package cn.jingchengyuanda.supermarketonline.dao;

import org.apache.ibatis.annotations.Mapper;

import cn.jingchengyuanda.supermarketonline.entity.TbTokenInfo;

/**
 * TbTokenInfo表的dao
 *
 * @author DarkKnight
 *
 */
@Mapper
public interface TbTokenInfoDAO {

  /**
   * -删除过期的TokenInfo
   * 
   * @return
   * @throws Exception 处理发生错误
   */
  int deleteTokenInfos() throws Exception;

  /**
   * -查询图片校验码是否存在
   *
   * @param tokenInfo
   * @return
   * @throws Exception 处理发生错误
   */
  TbTokenInfo queryImageCodeByToken(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -添加图片校验码
   *
   * @param tokenInfo
   * @return
   * @throws Exception 处理发生错误
   */
  int addImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -更新图片校验码
   *
   * @param tokenInfo
   * @return
   * @throws Exception 处理发生错误
   */
  int updateImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -删除图片校验码
   *
   * @param tokenInfo
   * @return
   * @throws Exception 处理发生错误
   */
  int deleteImageCode(TbTokenInfo tokenInfo) throws Exception;





}
