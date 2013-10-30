package gov.ncbi.WeatherApp.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("yweather:astronomy")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class YweatherAst {
	String message;
	String sunrise;
	String sunset;
}
