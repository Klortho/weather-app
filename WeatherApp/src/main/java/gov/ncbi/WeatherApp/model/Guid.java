package gov.ncbi.WeatherApp.model;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamConverter(value=ToAttributedValueConverter.class, strings={"message"})
public class Guid {
	String isPermaLink;
	String message;
}
