import java.util.*;
import java.util.Date;

public class MarketStock {
    private Map<Date, Set<Stock>> stocksMap = new HashMap<>();

   public double getMarketCapOfStockForDay(String ticker, Date date) {

       double marketCapForDay = 0;
       //Sprawdz czy istnieje data w mapie :
       if(stocksMap.containsKey(date)) {
           Set<Stock> stockSet = stocksMap.get(date);
           // Szukaj akcje po okreslonym ticker
           for (Stock stock : stockSet) {
               if(stock.getTicker().equals(ticker)) {
                   marketCapForDay = stock.getValue() * stock.getAmountInCirculation();
               }
           }
       }
        return marketCapForDay;
   }
   // Jak obliczyc marketcap : wsumie nie wiem ale w necie jest tak :
    // wystarczy pomnożyć łączną liczbę akcji znajdujących się w obrocie przez bieżącą cenę rynkową akcji.

    public int getAmountOfStockInCirculation(String ticker, Date date) {

       int totalAmountOfStock = 0;

       //tak samo sprawdzam czy istnieje data w mapie :
        if(stocksMap.containsKey(date)) {
            Set<Stock> stockSet = stocksMap.get(date);

            //szukam aukcje dla tickera
            for(Stock stock : stockSet) {
                if(stock.getTicker().equals(ticker)) {
                    totalAmountOfStock += stock.getAmountInCirculation();
                }
            }
        } else {
            System.out.println("Entry correct date.");
        }
        return totalAmountOfStock;
    }
    public double getTotalMarketCap(Date date) {

       double totalMarketCap = 0;

       if(stocksMap.containsKey(date)) {
           Set<Stock> stockSet = stocksMap.get(date);
           for(Stock stock : stockSet) {
               totalMarketCap += stock.getValue() * stock.getAmountInCirculation();
           }
        }else {
           System.out.println("Entry correct date. ");
       }
       return totalMarketCap;
    }

    public void addDateDay(Date date) {
        stocksMap.put(date, new HashSet<>());
    }

    public void addStockToDay(Stock stock, Date date) {
        // Sprawdź, czy mapa zawiera już klucz odpowiadający danej dacie
        if(stocksMap.containsKey(date)) {
            // Jeśli tak, pobierz zestaw akcji dla tej daty i dodaj nową akcję do tego zestawu
            stocksMap.get(date).add(stock);
        }
    }

    public void getTickerFromUserAndPrint() {
        Scanner sc = new Scanner(System.in);
        boolean wrongTicker = false;

       while (true) {
           System.out.println("Enter your ticker or 'end' to close ");

           String enteredTicker = sc.nextLine();
           if(enteredTicker.equalsIgnoreCase("end")) {
               break;
           }
           // Iteruj po wszystkich wpisach w mapie
           for(Map.Entry<Date,Set<Stock>> entry : stocksMap.entrySet()) {
               Date date = entry.getKey();
               Set<Stock> stockSet = entry.getValue();
               // Iteruj po wszystkich akcjach w danym dniu
               for(Stock stock : stockSet) {
                   if(stock.getTicker().equalsIgnoreCase(enteredTicker)) {
                       System.out.println("Ticker: " + stock.getTicker() + "\n" + "Price: " + stock.getValue() + "\n"  + "Amont in Circulation: " + stock.getAmountInCirculation() + "\n"  + "Date: " + date);
                   }
               }
           }
       }
    }


}


/*
Ogolnie zadanie sprawilo duzo trudnosci ze zrozumieniem . Ale powoli powoli cos z tego wykrzesalem .
Pytania :
    jak zmienic format daty na bardziej czytelny ?
    ak zrobic zeby irzutkownik mogl wprowadzic male litery to sie udalo trzeba zmienic equals na equalsIgnoreCase



 */