package org.mintleaf.modules.core.dao;

import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.mintleaf.modules.core.entity.SellDetails;
import org.springframework.stereotype.Component;

@Component
@SqlResource("sellDetails")
public interface SellDetailsDao extends BaseMapper<SellDetails>{

}
