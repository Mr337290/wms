package org.mintleaf.modules.core.dao;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.mintleaf.modules.core.entity.WarehouseWater;
import org.springframework.stereotype.Component;

@Component
@SqlResource("warehouseWater")
public interface WarehouseWaterDao extends BaseMapper<WarehouseWater>{

}
