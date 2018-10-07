package uts.wsd.oms;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "history")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="http://uts/wsd/oms")
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

    public void addOrder(Order order) {
        orders.add(order);
    }

    //Return orders based from the entirety of history.xml based on URL parameters (for web service)
    public List<Order> getOrdersByParams(int id, String email, String title, String status) {
        List<Order> ordersToReturn = new ArrayList<Order>();

        //Add orders matching given ID (unless no ID given)
        if (id != -1) {
            for (Order order : orders) {
                if (order.getOrderID() == id) {
                    ordersToReturn.add(order);
                }
            }
        } else {
            if (orders != null) {
                ordersToReturn.addAll(orders);
            }
        }

        //Remove any orders that do match email parameter
        if (email != null && !email.isEmpty()) {
            List<Order> toDelete = new ArrayList<Order>();
            for (Order order : ordersToReturn) {
                if (!order.getEmail().equalsIgnoreCase(email)) {
                    toDelete.add(order);
                }
            }

            ordersToReturn.removeAll(toDelete);
        }

        //Remove any orders that do match title parameter
        if (title != null && !title.isEmpty()) {
            List<Order> toDelete = new ArrayList<Order>();

            for (Order order : ordersToReturn) {
                List<Movie> movies = order.getMovies().getList();
                
                int i = 0;
                boolean isMatch = false;
                while (i < movies.size() && !isMatch) {
                    if (movies.get(i).getTitle().equalsIgnoreCase(title)) {
                        isMatch = true;
                    }
                    i++;
                }
                
                if (!isMatch) {
                    toDelete.add(order);
                }
            }

            ordersToReturn.removeAll(toDelete);
        }

        //Remove any orders that do match status parameter
        if (status != null && !status.isEmpty()) {
            List<Order> toDelete = new ArrayList<Order>();

            for (Order order : ordersToReturn) {
                if (!order.getOrderStatus().equalsIgnoreCase(status)) {
                    toDelete.add(order);
                }
            }

            ordersToReturn.removeAll(toDelete);
        }

        return ordersToReturn;
    }
}
