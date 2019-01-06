package org.mintleaf.modules.core.biz;

import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.mintleaf.modules.core.dao.WarehouseWaterDao;
import org.mintleaf.modules.core.entity.WarehouseInfo;
import org.mintleaf.modules.core.entity.WarehouseWater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseWaterServerImpl {
	@Autowired
	private WarehouseWaterDao warehouseWaterDao;
	public void insert(WarehouseWater entity) {
		warehouseWaterDao.insertTemplate(entity);
	}
	public List<WarehouseWater> loadByWarehouse(Integer warehouseId) {
		WarehouseWater warehouseWater = new WarehouseWater();
		warehouseWater.setWarehouseId(warehouseId);
		return warehouseWaterDao.template(warehouseWater);
	}
	
	public WarehouseWater  loadById(Integer id) {
		return warehouseWaterDao.single(id);
	}
	
	public void delete(Integer id) {
		warehouseWaterDao.deleteById(id);
	}
	
	public PageQuery<WarehouseWater> page(WarehouseWater warehouseWater, Long pageNum, Long pageSize) {
		PageQuery<WarehouseWater> pageQuery = new PageQuery<WarehouseWater>();
		pageQuery.setPageSize(Long.valueOf(pageSize));
		pageQuery.setPageNumber(Long.valueOf(pageNum));
		pageQuery.setParas(warehouseWater);
		// 查出用户分页集合
		warehouseWaterDao.templatePage(pageQuery);
		return pageQuery;
	}
}
