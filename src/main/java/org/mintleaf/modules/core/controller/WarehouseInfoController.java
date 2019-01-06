package org.mintleaf.modules.core.controller;

import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.mintleaf.modules.core.biz.WarehouseInfoServersImpl;
import org.mintleaf.modules.core.biz.WarehouseWaterServerImpl;
import org.mintleaf.modules.core.entity.WarehouseInfo;
import org.mintleaf.modules.core.entity.WarehouseWater;
import org.mintleaf.vo.PageFrame;
import org.mintleaf.vo.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("warehouse")
public class WarehouseInfoController {
	private final static Logger logger = LoggerFactory.getLogger(WarehouseInfoController.class);
	@Autowired
	private WarehouseInfoServersImpl warehouseInfoServersImpl;

	@RequestMapping(value = "index.html", method = { RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("modules/warehouse/index.html");
		return view;
	}

	@Autowired
	private WarehouseWaterServerImpl warehouseWaterServerImpl;

	@RequestMapping(value = "page.json", method = { RequestMethod.POST })
	@ResponseBody
	public ResultMsg page(@ModelAttribute WarehouseInfo warehouseInfo, Long pageNum, Long pageSize) {
		logger.info("分页查询");
		PageQuery<WarehouseInfo> pageQuery = warehouseInfoServersImpl.page(warehouseInfo, pageNum, pageSize);
		PageFrame pageFrame = new PageFrame();
		List<WarehouseInfo> warehouseInfoes = pageQuery.getList();
		for (WarehouseInfo info : warehouseInfoes) {
			Integer in = 0, out = 0;
			List<WarehouseWater> warehouseWaters = warehouseWaterServerImpl.loadByWarehouse(info.getId());
			if (warehouseWaters != null) {
				for (WarehouseWater warehouseWater : warehouseWaters) {
					// 入库
					if ("1".equals(String.valueOf(warehouseWater.getStatus()))) {
						Integer quantity = warehouseWater.getQuantity();
						if (quantity != null) {
							in = in + quantity;
						}
					} else if ("2".equals(String.valueOf(warehouseWater.getStatus()))) {
						Integer quantity = warehouseWater.getQuantity();
						if (quantity != null) {
							out = out + quantity;
						}
					}
				}
			}
			info.setIn(in);
			info.setOut(out);
		}
		pageFrame.setList(warehouseInfoes);
		pageFrame.setPageNum(Long.valueOf(pageNum));
		pageFrame.setPageSize(Long.valueOf(pageSize));
		pageFrame.setPages(pageQuery.getTotalPage());
		pageFrame.setTotal(pageQuery.getTotalRow());
		ResultMsg result = new ResultMsg();
		result.setData(pageFrame);
		return result;
	}

	@RequestMapping(value = "findById.json", method = { RequestMethod.POST }) // 请求类型
	@ResponseBody
	public ResultMsg loadWarehouse(WarehouseInfo warehouseInfo) throws Exception {
		// 向用户表查询用户信息
		WarehouseInfo info = warehouseInfoServersImpl.single(warehouseInfo.getId());
		WarehouseInfo r = new WarehouseInfo();
		r.setInventory(info.getInventory());
		r.setSn(info.getSn());
		r.setBatchNumber(info.getBatchNumber());
		r.setId(info.getId());
		ResultMsg result = new ResultMsg();
		result.setData(r);
		return result;
	}
}
