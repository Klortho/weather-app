package gov.ncbi.WeatherApp.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("yweather:atmosphere")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class YweatherAtm {
	String message;
	Integer humidity;
	String visibility;
	String pressure;
	Integer rising;
}
