package gov.ncbi.WeatherApp.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("channel")
public class Channel {
	
    String title;
    String link;
    String description;
    String language;
    String lastBuildDate;
    Integer ttl;
    
    @XStreamAlias("yweather:location")
    YweatherLocation yWl;
    @XStreamAlias("yweather:units")
    YweatherUnits yWu;
    @XStreamAlias("yweather:wind")
    YweatherWind yWw;
    @XStreamAlias("yweather:atmosphere")
    YweatherAtm yWa;
    @XStreamAlias("yweather:astronomy")
    YweatherAst yWas;
    
    Image image;
    public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getTitle() {
		return title;
	}
	public String getLink() {
		return link;
	}
	public YweatherLocation getyWl() {
		return yWl;
	}
	public YweatherUnits getyWu() {
		return yWu;
	}
	public YweatherWind getyWw() {
		return yWw;
	}
	public Image getImage() {
		return image;
	}
	Item item;

}
