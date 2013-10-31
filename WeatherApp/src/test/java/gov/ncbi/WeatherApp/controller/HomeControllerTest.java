package gov.ncbi.WeatherApp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.ModelAndViewAssert.assertAndReturnModelAttributeOfType;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;
import gov.ncbi.WeatherApp.model.Weather;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author biyyalas
 * Ref1 : http://markchensblog.blogspot.com/2013/02/use-spring-mvc-test-framework-and.html
 * Ref2 : https://github.com/prassu21/weather-app
 * Tests 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class HomeControllerTest {
	
	@Autowired
	private ApplicationContext applicationContext;
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private RequestMappingHandlerAdapter handlerAdapter;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		handlerAdapter = applicationContext.getBean(RequestMappingHandlerAdapter.class);
	}

	@Test
	public void testHomeGet() throws Exception {
		request.setMethod("GET");
		request.setRequestURI("/");
		final ModelAndView mav = handle(request, response);
		assertAndReturnModelAttributeOfType(mav, "weather", Weather.class);
	}
	
	@Test
	public void testZipFormat() throws Exception {
		request.setMethod("GET");
		request.setRequestURI("/report");
		request.setParameter("zipCode", "68503");
		ModelAndView mav = handle(request, response);
		Weather weather = assertAndReturnModelAttributeOfType(mav, "weather", Weather.class);
		assertEquals(new Integer(68503), weather.getZipCode());
		assertViewName(mav, "home");
		BindingResult errors = (BindingResult) mav.getModel().get(
                BindingResult.MODEL_KEY_PREFIX + "weather");
		
		assertTrue("No BindingResult for attribute: " + "weather", errors != null);
		
		assertTrue(null != errors.getFieldError("zipCode") ? errors
                .getFieldError("zipCode").getDefaultMessage() : "",
                !errors.hasErrors());
	}
	
	/*
	 * Pasted from Ref2, *not* mine
	 */
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        final RequestMappingHandlerMapping handlerMapping = applicationContext.getBean(
                RequestMappingHandlerMapping.class);
        final HandlerExecutionChain handler = handlerMapping
                .getHandler(request);
        assertNotNull("No handler found for request, check you request mapping", handler);

        final Object controller = handler.getHandler();
        final HandlerInterceptor[] interceptors = handlerMapping.getHandler(
                request).getInterceptors();
        for (HandlerInterceptor interceptor : interceptors) {
            final boolean carryOn = interceptor.preHandle(request, response,
                    controller);
            if (!carryOn) {
                return null;
            }
        }
        ModelAndView mav = handlerAdapter.handle(request, response, controller);
        return mav;
    }
}
