package uts.wsd.oms;

import java.util.*;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "orders")
public class Orders implements Serializable {

    @XmlElement(name = "user")
    private ArrayList<Order> list = new ArrayList<Order>();
    
    public ArrayList<Order> getList() {
        return list;
    }

    public void addOrder(Order order) {
        list.add(order);
    }
    
    public void removeOrder(Order order) {
        list.remove(order);
    }
}