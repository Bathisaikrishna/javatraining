package com.visa.prj.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@Controller
public class HotelController {

	@Autowired
	private BookingService bs;
	
	@RequestMapping("search.do")
	public ModelAndView searchHotels()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchForm.jsp");
		mav.addObject("searchCriteria", new SearchCriteria());
		return mav;
	}
	
	@RequestMapping("hotels.do")
	public ModelAndView showHotels(@ModelAttribute("searchCriteria") SearchCriteria s)
	{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("searchResults.jsp");
		List<Hotel> hotels = bs.findHotels(s.getSearchString());
		mav.addObject("hotelList", hotels);
		return mav;
	}
	
	@RequestMapping("viewHotel.do")
	public ModelAndView viewHotel(HttpServletRequest req)
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showHotel.jsp");
		System.out.println(bs.getHotelById(Integer.parseInt(req.getParameter("id"))));
		mav.addObject("hotel", bs.getHotelById(Integer.parseInt(req.getParameter("id"))));

		return mav;
	}
	
	
	@RequestMapping("bookingForm.do")
	public ModelAndView makeBooking(HttpServletRequest req, @RequestParam("id") int id) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("userLoginForm.jsp");
		Booking b = new Booking();
		System.out.println(req.getParameter("id"));
		
		Hotel hotel = bs.getHotelById(Integer.parseInt(req.getParameter("id")));
		b.setHotel(hotel);
		mav.addObject("booking",b);
		
		
		return mav;
		
		
	}
	
	
	@RequestMapping("successlogin.do")
	public ModelAndView makeBookAfterLogin(HttpServletRequest req)
	{
		ModelAndView mav = new ModelAndView();
		
		Hotel h = bs.getHotelById(Integer.parseInt(req.getParameter("hotel.id")));
		
		User u = new User();
		u.setEmail( req.getParameter("user.email"));
		u.setPassword(req.getParameter("user.password"));
		Booking b = new Booking();
		b.setUser(u);
		b.setHotel(h);
		mav.setViewName("bookingForm.jsp");
		mav.addObject("booking",b);
		
		return mav;
		
	}
	
	
	
	
	@RequestMapping("placeReservation.do")
	public String makeReservation(HttpServletRequest req, @RequestParam("hotel.id")long hid, @RequestParam("checkinDate") Date checkin, @RequestParam("checkoutDate") Date checkout) {
		
		System.out.println(req.getParameter("user.email"));
		bs.makeBooking(req.getParameter("user.email"), hid,checkin, checkout, false , 2);
		return "index.jsp";
		
	}
}
