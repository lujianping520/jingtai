package com.haina.news.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.haina.news.domin.Mynews;
import com.haina.news.service.MynewsService;
import com.haina.news.tools.Tools;
@Controller
@SessionAttributes(value={"newslist","attr2"})
public class NewsController {
	@Autowired
	private MynewsService mynewsService;
	/**
	 * 首页
	 */
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	/*
	 * 添加新闻页面
	 */
	@RequestMapping("/addnews")
	public String addnews(){
		return "addnews";
	}
	/*
	 * 新闻列表页面
	 */
	@RequestMapping("/findall")
	public ModelAndView findall(){
		List<Mynews> list = mynewsService.findAll();
		ModelAndView mav = new ModelAndView("newslist");
		mav.addObject("newslist",list);
		return mav;
	}
	/*
	 * 模板1页面
	 */
	@RequestMapping("/modelone")
	public String modelone(){
		return "modelone";
	}
	/*
	 * 模板2页面
	 */
	@RequestMapping("/modeltwo")
	public String modeltwo(){
		return "modeltwo";
	}
	@RequestMapping("/findbyid")
	public String findbyid(int id,HttpServletRequest request){
		//System.out.println("id" + id);
		Mynews mn = mynewsService.findbyid(id);
		request.setAttribute("mn", mn);
		return "modelone";
		
	}
	
	@RequestMapping("/f")
	public String findby(HttpServletRequest request){

		System.out.println(request.getServletContext().getRealPath("/"));
		return "";
		
	}
	//添加
	@RequestMapping("/add")
	public String add(Mynews mynews,HttpServletRequest request){
		/*System.out.println(mynews.getId());
		System.out.println(mynews.getTitle());
		System.out.println(mynews.getZaiyao());
		System.out.println(mynews.getContent());*/
		mynewsService.add(mynews);
		Mynews mn = mynewsService.staticfun();
		try {
			String url1 = Tools.changeHtml("modelone.jsp",mn,request,1);
			mn.setUrl1(url1.substring(url1.lastIndexOf("\\")+1,url1.length()));
			String url2 = Tools.changeHtml("modeltwo.jsp", mn,request,2);
			mn.setUrl2(url2.substring(url2.lastIndexOf("\\")+1,url2.length()));
			//System.out.println(url2);
			mynewsService.updatemn(mn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/findall";
	}
	//静态化
	/*@RequestMapping("/staticfun1")
	public String staticfun1() throws IOException{
		Mynews mn = mynewsService.staticfun();
		//System.out.println(mn.getId());
		try {
			Tools.changeHtml("modelone.jsp",mn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return "";
	}*/
    
	@RequestMapping("hhh")
	public String index2(){
		return "hh";
	}


}
