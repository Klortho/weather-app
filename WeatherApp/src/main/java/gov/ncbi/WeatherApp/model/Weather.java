package gov.ncbi.WeatherApp.model;

import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * @author biyyalas
 * The model for the simple form
 */
public class Weather {
	
	@Digits(integer = 5, fraction = 0, message = "Zip Code must be numeric and should consist exactly 5 digits")
	@NotNull(message = "Enter Zip code, it can't be null!")
	private Integer zipCode;
	private String city;
	private String img;
	private boolean isSubmit;

	public boolean isSubmit() {
		return isSubmit;
	}

	public void setSubmit(boolean isSubmit) {
		this.isSubmit = isSubmit;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message ;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public void setyWF_list(List<YweatherForecast> yWF_list) {
		this.yWF_list = yWF_list;
	}

	private String region;
	private String temp;
	public String getCity() {
		return city;
	}

	public String getRegion() {
		return region;
	}

	public String getTemp() {
		return temp;
	}

	public List<YweatherForecast> getyWF_list() {
		return yWF_list;
	}

	private List<YweatherForecast> yWF_list;
	public String message;
	
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
		
	@Override
	public String toString() {
		return "Weather [zipCode=" + zipCode + "]";
	}
}
