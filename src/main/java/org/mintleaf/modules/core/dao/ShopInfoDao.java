package org.mintleaf.modules.core.dao;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.mintleaf.modules.core.entity.ShopInfo;
import org.springframework.stereotype.Component;

@Component
@SqlResource("shopInfo")
public interface ShopInfoDao extends BaseMapper<ShopInfo>{

}
