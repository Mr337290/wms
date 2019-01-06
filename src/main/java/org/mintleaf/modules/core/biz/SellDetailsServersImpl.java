package org.mintleaf.modules.core.biz;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.beetl.sql.core.engine.PageQuery;
import org.mintleaf.modules.core.dao.SellDetailsDao;
import org.mintleaf.modules.core.dao.SellDetailsForDayDao;
import org.mintleaf.modules.core.entity.SellDetails;
import org.mintleaf.modules.core.entity.VwSellDetailsForDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SellDetailsServersImpl {
	@Autowired
	private SellDetailsDao sellDetailsDao;
	@Autowired
	private SellDetailsForDayDao sellDetailsForDayDao;
	
	public PageQuery<VwSellDetailsForDay> page(VwSellDetailsForDay sellDetails, Long pageNum, Long pageSize) {
		PageQuery<VwSellDetailsForDay> pageQuery = new PageQuery<VwSellDetailsForDay>();
		pageQuery.setPageSize(Long.valueOf(pageSize));
		pageQuery.setPageNumber(Long.valueOf(pageNum));
		pageQuery.setParas(sellDetails);
		// 查出用户分页集合
		sellDetailsForDayDao.templatePage(pageQuery);
		return pageQuery;
	}

	public void uploadCVS(InputStream   inputStream ) {
		try {
			InputStreamReader isr = new InputStreamReader(inputStream, "utf-8");
			Reader reader = new BufferedReader(isr);
			CSVParser parser = CSVFormat.EXCEL
					.withHeader("sellTime","shopCode", "batchNumber", "sn", "quantity", "price", "currency").parse(reader);
			List<CSVRecord> list = parser.getRecords();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			for (CSVRecord record : list) {
				if(record.getRecordNumber() == 1) {
					continue;
				}
				SellDetails sellDetails = new SellDetails();
				String sellTime = record.get("sellTime");
				sellTime = sellTime.replaceAll("[^\\d.]", "");
				while(sellTime.length() < 13) {
					sellTime = sellTime+"0";
				}
				sellDetails.setSellTime(sdf.parse(sellTime));
				sellDetails.setShopCode(record.get("shopCode"));
				sellDetails.setBatchNumber(record.get("batchNumber"));
				sellDetails.setSn(record.get("sn"));
				String quantity = record.get("quantity");
				if(!StringUtils.isEmpty(quantity)) {
					sellDetails.setQuantity(Integer.valueOf(quantity));
				}
				String price = record.get("price");
				if(!StringUtils.isEmpty(quantity)) {
					BigDecimal big = new BigDecimal(price);
					sellDetails.setPrice(big);
				}
				sellDetails.setCurrency(record.get("currency"));
				sellDetails.setCreateTime(new Date());
				insert(sellDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(SellDetails sellDetails) {
		sellDetailsDao.insert(sellDetails);
	}
	
	public void delete(Integer id) {
		sellDetailsDao.deleteById(id);
	}
	
	public PageQuery<SellDetails> page(SellDetails sellDetails, Long pageNum, Long pageSize) {
		PageQuery<SellDetails> pageQuery = new PageQuery<SellDetails>();
		pageQuery.setPageSize(Long.valueOf(pageSize));
		pageQuery.setPageNumber(Long.valueOf(pageNum));
		pageQuery.setParas(sellDetails);
		// 查出用户分页集合
		sellDetailsDao.templatePage(pageQuery);
		return pageQuery;
	}
}
