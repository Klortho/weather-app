package gov.ncbi.WeatherApp.model;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class YweatherCondition {
	String message;
	String text;
	Integer code;
	String temp;
	
	public String getTemp() {
		return temp;
	}

	String date;
}
