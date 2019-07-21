package com.springmvc.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.dao.CityDAO;
import com.springmvc.model.CityInfo;

@Controller
@RequestMapping("/")
public class CityApplicationController {
	
	@Autowired
	CityDAO citydao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showCityInputForm(ModelMap model) {
		
		return "index";
	}

	@RequestMapping(value = "/showCityInfoAction", method = RequestMethod.GET)
	public String getCityInfo(HttpServletRequest request ,ModelMap model)
	{
		String city=request.getParameter("city");
	
	/*	HashMap<String,CityInfo> hm=new HashMap<>();
		hm.put("Pune",new CityInfo("Pune", "MH", "famous for historical places") );
		hm.put("Mumbai",new CityInfo("Mumbai", "MH", "capital famous for industries & employment") );
		hm.put("Jaipur",new CityInfo("Jaipur", "RJ", "pink famous for forts & palaces") );
		CityInfo cinfo=hm.get(city);*/
				
		
		CityInfo cinfo=citydao.getCityInfo(city);		
		model.addAttribute("cinfo",cinfo);
		return "show";
	}
	
}
