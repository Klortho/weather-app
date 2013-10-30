package gov.ncbi.WeatherApp.model;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class Item {
	String title;
	@XStreamAlias("geo:lat")
	String geoLat;
	
	@XStreamAlias("geo:long")
	String geoLong;
	
	String link;
	String pubDate;
	@XStreamAlias("yweather:condition")
	YweatherCondition Ywc;
	public YweatherCondition getYwc() {
		return Ywc;
	}
	String description; //html
	
	public String getDescription() {
		return description;
	}
	@XStreamImplicit(itemFieldName="yweather:forecast")
	List<YweatherForecast> yWF_list;
	public List<YweatherForecast> getyWF_list() {
		return yWF_list;
	}
	Guid guid;
}
