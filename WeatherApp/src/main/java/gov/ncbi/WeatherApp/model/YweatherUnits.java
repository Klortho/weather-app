package gov.ncbi.WeatherApp.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("yweather:units")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class YweatherUnits {
	
	String message;
	@XStreamAlias("temperature")
	String temp;
	String distance;
	String pressure;
	String speed;
}
