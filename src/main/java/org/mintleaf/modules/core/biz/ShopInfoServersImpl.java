package org.mintleaf.modules.core.biz;

import java.util.List;

import org.beetl.sql.core.engine.PageQuery;
import org.mintleaf.modules.core.dao.ShopInfoDao;
import org.mintleaf.modules.core.entity.CoreUser;
import org.mintleaf.modules.core.entity.ShopInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class ShopInfoServersImpl {
	@Autowired
	private ShopInfoDao shopInfoDao;

	public List<ShopInfo> findByPage(ShopInfo shopInfo) {
		PageQuery<ShopInfo> page = new PageQuery<ShopInfo>();
		shopInfoDao.templatePage(page);
		return shopInfoDao.template(shopInfo, 1, 10);
	}

	public void insert(ShopInfo shopInfo) {
		shopInfoDao.insertTemplate(shopInfo);
	}

	public PageQuery<ShopInfo> page(ShopInfo shopInfo, Long pageNum, Long pageSize) {
		PageQuery<ShopInfo> pageQuery = new PageQuery<ShopInfo>();
		pageQuery.setPageSize(Long.valueOf(pageSize));
		pageQuery.setPageNumber(Long.valueOf(pageNum));
		pageQuery.setParas(shopInfo);
		// 查出用户分页集合
		shopInfoDao.templatePage(pageQuery);
		return pageQuery;
	}
	
	public ShopInfo single(Integer id) {
		return shopInfoDao.single(id);
	}
	
	public void update(ShopInfo entity) {
		shopInfoDao.updateById(entity);
	}
}
