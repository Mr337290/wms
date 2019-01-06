package org.mintleaf.modules.core.dao;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.mintleaf.modules.core.entity.WarehouseInfo;
import org.springframework.stereotype.Component;

@Component
@SqlResource("warehouseInfo")
public interface WarehouseInfoDao extends BaseMapper<WarehouseInfo>{

}
