package cn.jingchengyuanda.supermarketonline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.jingchengyuanda.supermarketonline.dao.TbLogsDAO;
import cn.jingchengyuanda.supermarketonline.dao.TbSubTypeDAO;
import cn.jingchengyuanda.supermarketonline.entity.TbLogs;
import cn.jingchengyuanda.supermarketonline.entity.TbSubType;
import cn.jingchengyuanda.supermarketonline.entity.TbType;
import cn.jingchengyuanda.supermarketonline.model.TbSubTypeModel;
import cn.jingchengyuanda.supermarketonline.service.SubTypeService;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;
import cn.jingchengyuanda.supermarketonline.utils.MyUtils;
import cn.jingchengyuanda.supermarketonline.utils.PageBean;

/**
 * -ubTypeService实现
 * 
 * @author fengxiuyuan
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SubTypeServiceImpl implements SubTypeService {

  @Autowired
  private TbSubTypeDAO tbSubTypeDAO;
  @Autowired
  private TbLogsDAO tbLogsDAO;

  @Override
  public JsonMessage queryAll(TbSubTypeModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    // 查询分类信息
    List<TbType> types = tbSubTypeDAO.queryType();
    message.put("types", types);
    // 查询小类信息
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbSubType> list = (Page<TbSubType>) tbSubTypeDAO.queryAll();
    page.setPageInfo(list);
    message.put("page", page);
    message.put("list", list);
    return message;
  }

  private JsonMessage checkSubType(TbSubType subType) throws Exception {
    if (subType.getTid() == null || subType.getTid() < 1) {
      return JsonMessage.getFail("必须选择类型");
    }
    if (MyUtils.isEmpty(subType.getSubName())) {
      return JsonMessage.getFail("名称必须填写");
    }
    if (MyUtils.isEmpty(subType.getSubInfo())) {
      return JsonMessage.getFail("描述必须填写");
    }

    return null;
  }

  @Override
  public JsonMessage add(TbSubTypeModel model) throws Exception {
    TbSubType subType = model.getTbSubType();
    // 必填校验=======================
    JsonMessage check = checkSubType(subType);
    if (check != null) {
      return check;
    }
    // 名称冲突检测==============================
    if (tbSubTypeDAO.queryByTidSubName(subType) != null) {
      return JsonMessage.getFail("类型已经存在");
    }
    int result = tbSubTypeDAO.add(subType);
    // 添加日志信息
    TbLogs logs = new TbLogs();
    // 操作员
    logs.setOperator(model.getTbAdminUser().getAuid().toString());
    // 类型
    logs.setLogtype("subtypemanage");
    // 信息
    logs.setLog(String.format("添加了:%s", model.getTbSubType()));
    tbLogsDAO.add(logs);
    
    return result == 1 ? JsonMessage.getSuccess("添加成功") : JsonMessage.getFail("添加失败");
  }

  @Override
  public JsonMessage update(TbSubTypeModel model) throws Exception {
    TbSubType subType = model.getTbSubType();
    // 必填校验=======================
    JsonMessage check = checkSubType(subType);
    if (check != null) {
      return check;
    }
    TbSubType checksub = tbSubTypeDAO.queryByKey(subType);
    if (checksub == null) {
      return JsonMessage.getFail("类型不存在");
    } // 名称冲突检测==================
    TbSubType name = tbSubTypeDAO.queryByTidSubName(subType);
    if (name != null && !subType.getStid().equals(name.getStid())) {
      // 修改的情况
      return JsonMessage.getFail("类型已经存在");
    }
    int result = tbSubTypeDAO.update(model.getTbSubType());
    // 添加日志信息
    TbLogs logs = new TbLogs();
    // 操作员
    logs.setOperator(model.getTbAdminUser().getAuid().toString());
    // 类型
    logs.setLogtype("subtypemanage");
    // 信息
    logs.setLog(String.format("修改了:%s", model.getTbSubType()));
    tbLogsDAO.add(logs);
    return result == 1 ? JsonMessage.getSuccess("修改成功") : JsonMessage.getFail("修改失败");
  }

  @Override
  public JsonMessage enable(TbSubTypeModel model) throws Exception {
    model.getTbSubType().setIsEnable("y");
    int result = tbSubTypeDAO.updateIsEnable(model.getTbSubType());
    TbLogs logs = new TbLogs();
    // 操作员
    logs.setOperator(model.getTbAdminUser().getAuid().toString());
    // 类型
    logs.setLogtype("subtypemanage");
    // 信息
    logs.setLog(String.format("启用了:%s", model.getTbSubType()));
    tbLogsDAO.add(logs);
    return result == 1 ? JsonMessage.getSuccess("启用成功") : JsonMessage.getFail("启用失败");

  }

  @Override
  public JsonMessage disable(TbSubTypeModel model) throws Exception {
    model.getTbSubType().setIsEnable("n");
    int result = tbSubTypeDAO.updateIsEnable(model.getTbSubType());
    // 添加日志信息
    TbLogs logs = new TbLogs();
    // 操作员
    logs.setOperator(model.getTbAdminUser().getAuid().toString());
    // 类型
    logs.setLogtype("subtypemanage");
    // 信息
    logs.setLog(String.format("禁用了:%s", model.getTbSubType()));
    tbLogsDAO.add(logs);
    return result == 1 ? JsonMessage.getSuccess("禁用成功") : JsonMessage.getFail("禁用失败");

  }
}
