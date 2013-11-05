package gov.ncbi.WeatherApp.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

import spock.lang.Specification

/**
 * Attempt to spock tests in Spring MVC 
 * @author biyyalas
 *
 */
class GroovyControllerTest extends Specification {
	
	void "Test from home"() {
		def domain = "http://localhost:8990/WeatherApp/"
		def map = ['zipCode' : 68503]
		when:
		ResponseEntity entity = new RestTemplate().getForEntity(domain , String.class, 68503)

		then:
		entity.statusCode == HttpStatus.OK
		println entity.body 
	}
}
