package gov.ncbi.WeatherApp.service;

import gov.ncbi.WeatherApp.model.Channel;
import gov.ncbi.WeatherApp.model.Rss;
import gov.ncbi.WeatherApp.model.Weather;
import gov.ncbi.entrez.Entrez;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;

@Service("yahooService")
public class YahooService {
	
	public void processRequest(Weather weather) {
		weather.setSubmit(true);
		XStream xStream = new XStream();
    	xStream.processAnnotations(Rss.class);
    	
    	StringBuilder xmlResponse = new StringBuilder();
    	try {
    		URL url = new URL("http://weather.yahooapis.com/forecastrss?p="+weather.getZipCode());
    		BufferedReader in = new BufferedReader(
    				new InputStreamReader(url.openStream()));
    		String inputLine = null;
    		String ls = System.getProperty("line.separator");

    		while ((inputLine = in.readLine()) != null) {
                xmlResponse.append(inputLine);
                xmlResponse.append(ls);
            }
            in.close();
            Rss rss = (Rss)xStream.fromXML(xmlResponse.toString());
            Channel c = rss.getChannel();
            // basically the image url has to be pulled from item description
            String desc = c.getItem().getDescription();
            Document doc = Jsoup.parse(desc);
            Element elem = doc.getElementsByTag("img").first(); // (assuming) guaranteed the presence of image by service 
            weather.setImg(elem.absUrl("src"));
            weather.setCity(c.getyWl().getCity());
            weather.setRegion(c.getyWl().getRegion());
            weather.setyWF_list(c.getItem().getyWF_list());
            String temp = c.getItem().getYwc().getTemp();
            weather.setTemp(temp);
            Entrez pubmed = new Entrez("pubmed");
            
            if (Integer.parseInt(temp) > 45 && Integer.parseInt(temp) < 80 )
            	//weather.setMessage(pubmed.getProperty("Description").toString());
            	weather.setMessage("It's nice outside. Bazinga!");
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	}
	}
}
	


