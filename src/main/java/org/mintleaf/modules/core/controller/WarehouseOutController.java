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
@RequestMapping("warehouseOut")
public class WarehouseOutController {
	@Autowired
	private WarehouseInfoServersImpl warehouseInfoServersImpl;
	@Autowired
	private WarehouseWaterServerImpl warehouseWaterServerImpl;
	
	@RequestMapping(value = "index.html", method = { RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("modules/warehouse/out/index.html");
		return view;
	}
	@RequestMapping(value = "edit.html", method = { RequestMethod.GET })
	public ModelAndView add() {
		ModelAndView view = new ModelAndView("modules/warehouse/out/edit.html");
		return view;
	}
	
	@RequestMapping(value = "edit.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg out(WarehouseWater warehouseWater) {
		WarehouseInfo warehouseInfo =warehouseInfoServersImpl.single(warehouseWater.getId());
        if(warehouseInfo ==null) {
        	return new ResultMsg("数据异常，请联系管理员",false);
        }
        Integer inventory = warehouseInfo.getInventory();
        Integer quantity =  warehouseWater.getQuantity();
        if(quantity ==null || quantity < 1) {
        	return new ResultMsg("出库数量不合法，请核对",false);
        }
        if(quantity > inventory) {
        	return new ResultMsg("库存不够，请及时进货",false);
        }
        /*修改库存*/
        warehouseInfo.setInventory( inventory - quantity );
        warehouseInfo.setModifyTime(new Date());
        warehouseInfoServersImpl.update(warehouseInfo);
        /*产生出库记录*/
        WarehouseWater entity = new WarehouseWater();
		entity.setWarehouseId(warehouseInfo.getId());
		entity.setQuantity(quantity);
		entity.setStatus(2);
		entity.setOperand(warehouseWater.getOperand());
		entity.setCreateTime(new Date());
		warehouseWaterServerImpl.insert(entity);
		ResultMsg result=new ResultMsg();
        result.setData(entity);
        return result;
    }
	
	@RequestMapping(value = "page.json", method = { RequestMethod.POST })
	@ResponseBody
	public ResultMsg page(@ModelAttribute WarehouseInfo warehouseInfo, Long pageNum, Long pageSize) {
		WarehouseWater tmp = new WarehouseWater();
		tmp.setStatus(2);
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
        for(String t:ids) {
        	Integer tt= Integer.valueOf(t);
        	WarehouseWater warehouseWater = warehouseWaterServerImpl.loadById(tt);
        	/*把数量退回去*/
        	WarehouseInfo warehouseInfo = warehouseInfoServersImpl.single(warehouseWater.getWarehouseId());
        	warehouseInfo.setInventory(warehouseInfo.getInventory() + warehouseWater.getQuantity());
        	warehouseInfoServersImpl.update(warehouseInfo);
        	warehouseWaterServerImpl.delete(tt);
        }
		return ok();
	}
}
