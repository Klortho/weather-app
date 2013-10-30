package gov.ncbi.WeatherApp.controller;

import gov.ncbi.WeatherApp.model.Weather;
import gov.ncbi.WeatherApp.service.YahooService;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author biyyalas
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/**
	 * home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("weather", new Weather());
		return "home";
	}
	
	/**
	 * Where action happens
	 */
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String getReport(@Valid Weather weather, BindingResult result) {
		
		if (!result.hasErrors())
			YahooService.processRequest(weather);
		return "home";
	}
}
