
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class MakeMeRich {
	
	final static String API_KEY = "VFVOBPYFHTLCN7J4";
	
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ",
			"IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE", "AMZN", "CRAY", "CSCO",
			"SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN",
			"YHOO");
	
	public static void main(String[] args) throws IOException {
		
		
		//System.out.println(rootURL);
		
		// 1. Print these symbols using a Java 8 for-each and lambdas
		//symbols.parallelStream().forEach(s -> System.out.println(s));

		// 2. Use the StockUtil class to print the price of Bitcoin 
		List<Double> list = Arrays.asList(StockUtil.prices.get("BTC-USD"));
		
		
		System.out.println("BTC-USD" + list);
		// 3. Create a new List of StockInfo that includes the stock price
		for(int i = 0; i < symbols.size(); i++) {
			final String Sym = symbols.get(i);
			String rootURL = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE";
			String interval = "15min";
			rootURL += "&symbol=" + Sym;
			rootURL += "&interval=" + interval;
			rootURL += "&apikey=" + API_KEY;
			URL request = new URL(rootURL);
			InputStream openStream = request.openStream();
			String response = IOUtils.toString(openStream);
			JSONObject root = new JSONObject(response);
			JSONObject globalQuote = (JSONObject) root.get("Global Quote");
			final String symbol = (String) globalQuote.get("01. symbol");
			final String symPrice = (String) globalQuote.get("05. price");
			final double price = Double.parseDouble(symPrice);
			StockInfo stocks = new StockInfo(symbol, price);
			System.out.println(stocks.toString());
			for(int j =0+1;j < symbols.size(); j++) {
				StockUtil util = new StockUtil();
				List<StockInfo> stocksInfo = Arrays.asList(stocks);
				StockInfo stockInfo1 = stocksInfo.get(i);
				StockInfo stockInfo2 = stocksInfo.get(j);
				
				stocksInfo.stream().filter(stocksInfo -> util.pickHigh(stockInfo1.price, stockInfo2.price)).collect(Collectors.toList());
			}
		}
		
		
		
	
		// 4. Find the highest-priced stock under $500
		
		
	}

}
//Copyright, Zachary Zensen 2020