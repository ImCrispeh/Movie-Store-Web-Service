package uts.wsd.oms;

import java.util.*;

public class Util {

    private static int nextOrderID = 0;

    public static int generateOrderID() {
        int temp = nextOrderID;
        nextOrderID++;
        return temp;
    }
    
    public static void initOrderID(ArrayList<History> history){
        for(History h : history)
            for(Order order : h.getOrders())
                if(order.getOrderID() > nextOrderID)
                    nextOrderID = order.getOrderID()+1;
    }
}
