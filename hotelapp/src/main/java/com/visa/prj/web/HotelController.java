package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HotelController {

	@RequestMapping("search.do")
	public ModelAndView searchHotels()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchForm.jsp");
		mav.addObject("searchCriteria", new String());
		return mav;
	}
	
	@RequestMapping("hotels.do")
	public ModelAndView getHotels(HttpServletRequest req)
	{
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("searchForm.jsp");
		//mav.addObject(attributeName, attributeValue);
		return mav;
	}
}
