package uts.wsd.oms.soap.client;

public class HistoryClient {
    public static void main(String[] args) {
        History_Service locator = new History_Service();
        HistorySoap history = locator.getHistorySoapPort();
        
        for(Order order : history.viewAllOrders("").getOrder())
        {
            
        }
    }
}
