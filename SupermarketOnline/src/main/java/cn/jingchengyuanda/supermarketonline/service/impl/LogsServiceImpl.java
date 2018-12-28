package cn.jingchengyuanda.supermarketonline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.jingchengyuanda.supermarketonline.dao.TbLogsDAO;
import cn.jingchengyuanda.supermarketonline.entity.TbLogs;
import cn.jingchengyuanda.supermarketonline.model.LogsModel;
import cn.jingchengyuanda.supermarketonline.service.LogsService;
import cn.jingchengyuanda.supermarketonline.utils.JsonMessage;
import cn.jingchengyuanda.supermarketonline.utils.PageBean;

/**
 * 
 * @author fengxiuyuan
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LogsServiceImpl implements LogsService {

  @Autowired
  private TbLogsDAO tbLogsDAO;

  @Override
  public JsonMessage queryAll(LogsModel model) throws Exception {
    PageBean page = model.getPage();
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    Page<TbLogs> list = (Page<TbLogs>) tbLogsDAO.queryAll(model.getTbLogs());
    page.setPageInfo(list);
    JsonMessage message = JsonMessage.getSuccess("");
    message.put("page", page);
    message.put("list", list);
    return message;
  }

}
