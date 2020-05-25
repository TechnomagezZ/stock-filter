
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MakeMeRich {
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ",
			"IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE", "AMZN", "CRAY", "CSCO",
			"SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN",
			"YHOO");

	public static void main(String[] args) {

		// 1. Print these symbols using a Java 8 for-each and lambdas
		symbols.parallelStream().forEach(s -> System.out.println(s));

		// 2. Use the StockUtil class to print the price of Bitcoin
		StockInfo stockInfo = new StockInfo(StockUtil.prices);
		StockUtil stockPrice = new StockUtil();
		StockUtil.prices.entrySet().stream().forEach(s -> System.out.println(s));

		// 3. Create a new List of StockInfo that includes the stock price
		
		List<Entry<String, Double>> stock = StockUtil.prices.entrySet().stream().sorted().collect(Collectors.toList());
	
		// 4. Find the highest-priced stock under $500
		stock.stream().filter(StockUtil.isPriceLessThan(500).and(stockPrice.pickHigh())).collect(Collectors.toList());
	}

}
