package gov.ncbi.WeatherApp.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("yweather:forecast")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class YweatherForecast {
	private String message;
	private String day;
	private String date;
	private Integer low;
	private Integer high;
	private String text;
	private Integer code;
	
	public String getMessage() {
		return message;
	}
	public String getDay() {
		return day;
	}
	public String getDate() {
		return date;
	}
	public Integer getLow() {
		return low;
	}
	public Integer getHigh() {
		return high;
	}
	public String getText() {
		return text;
	}
	public Integer getCode() {
		return code;
	}
}
