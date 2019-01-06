package org.mintleaf.modules.core.biz;

import java.util.Date;
import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.mintleaf.modules.core.dao.WarehouseInfoDao;
import org.mintleaf.modules.core.entity.WarehouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*仓库信息*/
@Service
public class WarehouseInfoServersImpl {
	@Autowired
	private WarehouseInfoDao warehouseInfoDao;

	public void save(WarehouseInfo info) {
		info.setCreateTime(new Date());
		warehouseInfoDao.insertTemplate(info,true);
	}
	
	public int update(WarehouseInfo info) {
		return warehouseInfoDao.updateTemplateById(info);
	}
	
	public List<WarehouseInfo> findBySn(String sn) {
		WarehouseInfo entity = new WarehouseInfo();
		entity.setSn(sn);
		return warehouseInfoDao.template(entity);
	}
	
	public PageQuery<WarehouseInfo> page(WarehouseInfo shopInfo, Long pageNum, Long pageSize) {
		PageQuery<WarehouseInfo> pageQuery = new PageQuery<WarehouseInfo>();
		pageQuery.setPageSize(Long.valueOf(pageSize));
		pageQuery.setPageNumber(Long.valueOf(pageNum));
		pageQuery.setParas(shopInfo);
		// 查出用户分页集合
		warehouseInfoDao.templatePage(pageQuery);
		return pageQuery;
	}
	public WarehouseInfo single(Integer id) {
		return warehouseInfoDao.single(id);
	}
	
	public void delete(Integer id) {
		warehouseInfoDao.deleteById(id);
	}
}
