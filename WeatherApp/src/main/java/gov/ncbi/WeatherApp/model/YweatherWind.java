package gov.ncbi.WeatherApp.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("yweather:wind")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class YweatherWind {
	String message;
	Integer chill;
	Integer direction;
	Integer speed;
}
