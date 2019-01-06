package org.mintleaf.modules.core.controller;

import static org.mintleaf.vo.ResultMsg.ok;

import java.util.Date;
import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.mintleaf.modules.core.biz.WarehouseInfoServersImpl;
import org.mintleaf.modules.core.biz.WarehouseWaterServerImpl;
import org.mintleaf.modules.core.entity.WarehouseInfo;
import org.mintleaf.modules.core.entity.WarehouseWater;
import org.mintleaf.vo.PageFrame;
import org.mintleaf.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("warehouseIn")
public class WarehouseInController {
	@Autowired
	private WarehouseInfoServersImpl warehouseInfoServersImpl;
	@Autowired
	private WarehouseWaterServerImpl warehouseWaterServerImpl;

	@RequestMapping(value = "index.html", method = { RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("modules/warehouse/in/index.html");
		return view;
	}

	@RequestMapping(value = "add.html", method = { RequestMethod.GET })
	public ModelAndView add() {
		ModelAndView view = new ModelAndView("modules/warehouse/in/add.html");
		return view;
	}

	@RequestMapping(value = "add.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultMsg add(WarehouseInfo warehouseInfo) {
		warehouseInfo.setInventory(warehouseInfo.getQuantity());
		warehouseInfo.setCreateTime(new Date());
		warehouseInfo.setModifyTime(new Date());
		List<WarehouseInfo> sns = warehouseInfoServersImpl.findBySn(warehouseInfo.getSn());
		if (!sns.isEmpty()) {
			return new ResultMsg("批次：" + warehouseInfo.getSn() + "已入库", false);
		}
		warehouseInfoServersImpl.save(warehouseInfo);
		WarehouseWater entity = new WarehouseWater();
		entity.setWarehouseId(warehouseInfo.getId());
		entity.setQuantity(warehouseInfo.getQuantity());
		entity.setStatus(1);
		warehouseWaterServerImpl.insert(entity);
		ResultMsg result = new ResultMsg();
		result.setData(warehouseInfo);
		return result;
	}

	@RequestMapping(value = "page.json", method = { RequestMethod.POST })
	@ResponseBody
	public ResultMsg page(@ModelAttribute WarehouseInfo warehouseInfo, Long pageNum, Long pageSize) {
		WarehouseWater tmp = new WarehouseWater();
		tmp.setStatus(1);
		PageQuery<WarehouseWater> pageQuery = warehouseWaterServerImpl.page(tmp, pageNum, pageSize);
		PageFrame pageFrame = new PageFrame();
		List<WarehouseWater> warehouseWaters = pageQuery.getList();
		for (WarehouseWater info : warehouseWaters) {
			info.setWarehouseInfo(warehouseInfoServersImpl.single(info.getWarehouseId()));
		}
		pageFrame.setList(warehouseWaters);
		pageFrame.setPageNum(Long.valueOf(pageNum));
		pageFrame.setPageSize(Long.valueOf(pageSize));
		pageFrame.setPages(pageQuery.getTotalPage());
		pageFrame.setTotal(pageQuery.getTotalRow());
		ResultMsg result = new ResultMsg();
		result.setData(pageFrame);
		return result;
	}

	@RequestMapping(value = "deleteBatch.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultMsg deleteBatch(String id) {
		String[] ids = id.split(",");
		/*检查是否存在出库数据*/
		for(String t : ids) {
			WarehouseWater warehouseWater = warehouseWaterServerImpl.loadById(Integer.valueOf(t));
			List<WarehouseWater> warehouseWaters =  warehouseWaterServerImpl.loadByWarehouse(warehouseWater.getWarehouseId());
		    for(WarehouseWater water:warehouseWaters) {
		    	if("2".equals(String.valueOf(water.getStatus()))) {
		    		return new ResultMsg("已存在出库数据，不允许删除",false);
		    	}
		    }
		}
        for(String t:ids) {
        	Integer tt= Integer.valueOf(t);
        	WarehouseWater warehouseWater = warehouseWaterServerImpl.loadById(tt);
        	warehouseInfoServersImpl.delete(warehouseWater.getWarehouseId());
        	warehouseWaterServerImpl.delete(tt);
        }
		return ok();
	}
}
