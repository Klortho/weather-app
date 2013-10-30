package gov.ncbi.WeatherApp.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("yweather:location")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class YweatherLocation {
	String message;
	String city;
	public String getCity() {
		return city;
	}
	public String getRegion() {
		return region;
	}
	String region;
	String country;
}
