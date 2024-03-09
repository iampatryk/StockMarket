import java.util.Date;

public class Main {
    public static void main(String[] args) {

        MarketStock marketStock = new MarketStock();

        Date date1 = new Date(2023,1,1);
        Date date2 = new Date(2023,1,2);
        Date date3 = new Date(2023,1,3);

        marketStock.addDateDay(date1);
        marketStock.addDateDay(date2);
        marketStock.addDateDay(date3);

        Stock stock1 = new Stock("TES",55.20, 69);
        Stock stock2 = new Stock("AAA",303.50, 90);
        Stock stock3 = new Stock("PKO",4059.60, 990);
        Stock stock4 = new Stock("BMW",4459.60, 590);
        Stock stock5 = new Stock("BTC",1259.50, 1220);
        Stock stock6 = new Stock("MIC",40779.70, 2340);
        Stock stock7 = new Stock("WIG",409.67, 120);
        Stock stock8 = new Stock("DAX",4234.62, 9190);
        Stock stock9 = new Stock("ETF",8959.60, 2390);
        Stock stock10 = new Stock("XRP",329.40, 4490);
        Stock stock11 = new Stock("COI",39.70, 6570);
        Stock stock12 = new Stock("FRD",34649.90, 990);
        Stock stock13 = new Stock("EWS",0.20, 1290);
        Stock stock14 = new Stock("VFR",549.10, 190);
        Stock stock15 = new Stock("MRD",9.40, 390);


        marketStock.addStockToDay(stock1,date1);
        marketStock.addStockToDay(stock2,date1);
        marketStock.addStockToDay(stock3,date1);
        marketStock.addStockToDay(stock4,date1);
        marketStock.addStockToDay(stock5,date1);
        marketStock.addStockToDay(stock6,date2);
        marketStock.addStockToDay(stock7,date2);
        marketStock.addStockToDay(stock8,date2);
        marketStock.addStockToDay(stock9,date2);
        marketStock.addStockToDay(stock10,date2);
        marketStock.addStockToDay(stock11,date3);
        marketStock.addStockToDay(stock12,date3);
        marketStock.addStockToDay(stock13,date3);
        marketStock.addStockToDay(stock14,date3);
        marketStock.addStockToDay(stock15,date3);


        String tick = "TES";
        Date dat = new Date(2023,1,1);

        System.out.println("GET MARKETCAP OF STOCK FOR DAY");
        double marketCapForDay = marketStock.getMarketCapOfStockForDay(tick,dat);
        System.out.println("Market Cap of: " + tick + " on " + dat + " is: " + marketCapForDay + "\n");


        System.out.println("GET AMOUNT OF STOCK IN CIRCULATION ");
        // Uzyje String i date z tych wyzej
        int totalAmountOfStock = marketStock.getAmountOfStockInCirculation(tick,dat);
        System.out.println("Amount of " + tick + " on " + dat + " is: " + totalAmountOfStock + "\n");

        System.out.println("GET TOTAL AMOUNT OF MARKET CAP ");
        // uzyje tej samej daty
        double totalMarketCap = marketStock.getTotalMarketCap(dat);
        System.out.println("Total market cap on " + dat + " is : " + totalMarketCap + "\n");

//        marketStock.getTickerFromUserAndPrint();

    }
}


/*
Stwórz klasę Giełdy, która umożliwi na śledzenie danych o wartości akcji i zmianie w czasie.

Giełda będzie zawierała w sobie ogólny portfel akcji w formie mapy gdzie akcje muszą być unikatowe i każdy dzień otrzyma własny zestaw akcji.

Możliwe będzie podsumowanie wartości akcji na podstawie tickera, ilość akcji w obiegu oraz uzyskanie totalnej wartości rynku.

Dodatkowo stwórz klasę, która pozwoli użytkownikowi na interakcję z giełdą, gdzie będzie mógł przy pomocy wpisanych wartości otrzymać wartości.

Samodzielnie uzupełnij listę akcji i dat.

Jeśli data nie istnieje lub akcja nie istnieje, poinformuj o tym użytkownika

Klasy:
Stock
	String ticker;
	double value;
	int amountInCirculation;
Date
	int year;
	int month;
	int day;
StockMarket
Map<Date, Set<Stock>> stocks

	getMarketCapOfStockForDay(String ticker, Date date);
	getAmountOfStockInCirculation(String ticker, Date date);
	getTotalMarketCap(Date date);


 */