package org.mintleaf.modules.core.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.beetl.sql.core.engine.PageQuery;
import org.mintleaf.modules.core.biz.SellDetailsServersImpl;
import org.mintleaf.modules.core.entity.SellDetails;
import org.mintleaf.modules.core.entity.VwSellDetailsForDay;
import org.mintleaf.vo.PageFrame;
import org.mintleaf.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("selldetails")
public class SellDetailsController { 
	@Autowired
	private SellDetailsServersImpl sellDetailsServersImpl;
	@RequestMapping(value = "index.html", method = { RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("modules/selldetails/index.html");
		return view;
	}
	
	@RequestMapping(value = "indexForDay.html", method = { RequestMethod.GET })
	public ModelAndView indexForDay() {
		ModelAndView view = new ModelAndView("modules/selldetails/indexForDay.html");
		return view;
	}
	
	@RequestMapping(value = "uploads.html", method = { RequestMethod.GET })
	public ModelAndView uploads() {
		ModelAndView view = new ModelAndView("modules/selldetails/uploads.html");
		return view;
	}
	
	@RequestMapping(value = "/upload.do",method = RequestMethod.POST)
	public @ResponseBody ResultMsg uploads(HttpServletRequest request,MultipartFile[] file)
    {
		try {
			sellDetailsServersImpl.uploadCVS(file[0].getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ResultMsg.ok();
    }
	
	@RequestMapping(value = "/delete.do",method = RequestMethod.POST)
	public @ResponseBody ResultMsg delete(SellDetails sellDetails)
    {
		sellDetailsServersImpl.delete(sellDetails.getId());
		return ResultMsg.ok();
    }
	
	@RequestMapping(value = "page.json", method = { RequestMethod.POST })
	@ResponseBody
	public ResultMsg page(@ModelAttribute SellDetails sellDetails, Long pageNum, Long pageSize) {
		PageQuery<SellDetails> pageQuery = sellDetailsServersImpl.page(sellDetails, pageNum, pageSize);
		PageFrame pageFrame = new PageFrame();
		List<SellDetails> sellDetailses = pageQuery.getList();
		pageFrame.setList(sellDetailses);
		pageFrame.setPageNum(Long.valueOf(pageNum));
		pageFrame.setPageSize(Long.valueOf(pageSize));
		pageFrame.setPages(pageQuery.getTotalPage());
		pageFrame.setTotal(pageQuery.getTotalRow());
		ResultMsg result = new ResultMsg();
		result.setData(pageFrame);
		return result;
	}
	
	@RequestMapping(value = "pageForDay.json", method = { RequestMethod.POST })
	@ResponseBody
	public ResultMsg page(@ModelAttribute VwSellDetailsForDay sellDetails, Long pageNum, Long pageSize) {
		PageQuery<VwSellDetailsForDay> pageQuery = sellDetailsServersImpl.page(sellDetails, pageNum, pageSize);
		PageFrame pageFrame = new PageFrame();
		List<VwSellDetailsForDay> sellDetailses = pageQuery.getList();
		pageFrame.setList(sellDetailses);
		pageFrame.setPageNum(Long.valueOf(pageNum));
		pageFrame.setPageSize(Long.valueOf(pageSize));
		pageFrame.setPages(pageQuery.getTotalPage());
		pageFrame.setTotal(pageQuery.getTotalRow());
		ResultMsg result = new ResultMsg();
		result.setData(pageFrame);
		return result;
	}
}
