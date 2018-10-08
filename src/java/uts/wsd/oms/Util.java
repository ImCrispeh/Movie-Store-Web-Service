package uts.wsd.oms;

import java.util.*;

public class Util {

    private static int nextOrderID = 0;
    private static ArrayList<Integer> usedIDs = new ArrayList<Integer>();

    public static int generateOrderID() {
        int temp = nextOrderID;
        generateNextID();
        return temp;
    }

    public static void initOrderID(History history) {
        if(history != null && history.getOrders() != null)
            for (Order order : history.getOrders())
                usedIDs.add(order.getOrderID());
        generateNextID();
    }
    
    private static void generateNextID(){
        int id;
        Random rand = new Random();
        int min = 100, max = 999;
        do{
            id = rand.nextInt((max - min) + 1) + min;
        }while(usedIDs.contains(id) && usedIDs.size() < (max-min));
        usedIDs.add(id);
        nextOrderID = id;
    }
    
    public static void removeOrderID(int id){
        usedIDs.remove((Integer)id);
    }
}
