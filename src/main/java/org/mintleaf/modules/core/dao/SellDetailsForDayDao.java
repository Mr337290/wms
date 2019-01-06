package org.mintleaf.modules.core.dao;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.mintleaf.modules.core.entity.VwSellDetailsForDay;
import org.springframework.stereotype.Component;

@Component
@SqlResource("vwSellDetailsForDay")
public interface SellDetailsForDayDao extends BaseMapper<VwSellDetailsForDay>{

}
