package gov.ncbi.WeatherApp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author biyyalas
 * Ref1 : http://markchensblog.blogspot.com/2013/02/use-spring-mvc-test-framework-and.html
 * Ref2 : https://github.com/acogoluegnes/blog-spring-mvc-test-framework
 * Tests 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class HomeControllerTest_MockMVC {
	
	@Autowired WebApplicationContext wac; 

	private MockMvc mockMvc;
	
	@Before
	public void setUp() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testHome() throws Exception {

		this.mockMvc.perform(get("/").accept(MediaType.TEXT_HTML))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("weather"))
		.andExpect(view().name("home"));
	}
	
	@Test
	public void testResult() throws Exception {
		
		Integer zip = new Integer(20886);
		this.mockMvc.perform(get("/report?zipCode="+zip).accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("weather"))
		.andExpect(model().errorCount(0))
		.andExpect(model().size(1))
		.andExpect(view().name("home"));
	}
	
	@Test
	public void testImproperZip() throws Exception {
		
		Integer zip = new Integer(681234);
		this.mockMvc.perform(get("/report?zipCode="+zip).accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().errorCount(1))
		.andExpect(view().name("home"));
	}
	
	@Test
	public void testImproperZip2() throws Exception {
		
		this.mockMvc.perform(get("/report?zipCode=").accept(MediaType.TEXT_HTML))
		.andExpect(model().errorCount(1))
		.andExpect(view().name("home"));
	}
}
