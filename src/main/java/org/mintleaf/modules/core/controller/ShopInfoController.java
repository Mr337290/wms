package org.mintleaf.modules.core.controller;

import org.beetl.sql.core.engine.PageQuery;
import org.mintleaf.modules.core.biz.ShopInfoServersImpl;
import org.mintleaf.modules.core.entity.ShopInfo;
import org.mintleaf.vo.PageFrame;
import org.mintleaf.vo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("shopInfo")
public class ShopInfoController {
	@Autowired
	private ShopInfoServersImpl shopInfoServersImpl;

	@RequestMapping(value = "index.html", method = { RequestMethod.GET })
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("modules/shopInfo/index.html");
		return view;
	}

	@RequestMapping(value = "add.html", method = { RequestMethod.GET })
	public ModelAndView add() {
		ModelAndView view = new ModelAndView("modules/shopInfo/add.html");
		return view;
	}
	
	@RequestMapping(value="edit.html",method = {RequestMethod.GET})
    public ModelAndView edit(){
        ModelAndView view =new ModelAndView("modules/shopInfo/edit.html");
        return view;
    }
	
	@RequestMapping(value = "findById.json",method = {RequestMethod.POST}) //请求类型
    @ResponseBody
    public ResultMsg updateCoreMenu(ShopInfo shopInfo) throws Exception{
        //向用户表查询用户信息
		ShopInfo tmp=shopInfoServersImpl.single(shopInfo.getId());
        ResultMsg result=new ResultMsg();
        result.setData(tmp);
        return result;
    }
	
	@RequestMapping(value = "edit.do",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg update(ShopInfo shopInfo) {
		shopInfoServersImpl.update(shopInfo);
        ResultMsg result=new ResultMsg();
        result.setData(shopInfo);
        return result;
    }

	@RequestMapping(value = "add.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultMsg add(ShopInfo shopInfo) {
		shopInfoServersImpl.insert(shopInfo);
		ResultMsg result = new ResultMsg();
		result.setData(shopInfo);
		return result;
	}
	@RequestMapping(value="page.json",method = {RequestMethod.POST})
    @ResponseBody
    public ResultMsg page(@ModelAttribute ShopInfo shopInfo, Long pageNum, Long pageSize){
        PageQuery<ShopInfo> pageQuery=shopInfoServersImpl.page(shopInfo,pageNum,pageSize);
        PageFrame pageFrame=new PageFrame();
        pageFrame.setList(pageQuery.getList());
        pageFrame.setPageNum(Long.valueOf(pageNum));
        pageFrame.setPageSize(Long.valueOf(pageSize));
        pageFrame.setPages(pageQuery.getTotalPage());
        pageFrame.setTotal(pageQuery.getTotalRow());
        ResultMsg result=new ResultMsg();
        result.setData(pageFrame);
        return  result;
    }
}
