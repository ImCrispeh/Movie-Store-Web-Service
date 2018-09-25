package uts.wsd.oms;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "history")
@XmlAccessorType(XmlAccessType.FIELD)
public class History implements Serializable {

    @XmlElement(name = "order")
    private ArrayList<Order> orders;

    public History(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public History() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
    
    public void addOrder(Order order){
        orders.add(order);
    }
}
