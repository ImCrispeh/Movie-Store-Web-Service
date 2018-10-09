package uts.wsd.oms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

public class CartController {

    private String filePath;
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws JAXBException, FileNotFoundException, IOException {
        this.filePath = filePath;

        JAXBContext jc = JAXBContext.newInstance(Order.class);
        Unmarshaller u = jc.createUnmarshaller();

        FileInputStream file = new FileInputStream(filePath);
        order = (Order) u.unmarshal(file);
        System.out.println(order.getOrderID());
        file.close();
    }
    
    public Order createOrder() throws JAXBException, FileNotFoundException {
        setOrder(new Order());
        marshal();
        return getOrder();
    }

    public void addMovie(Movie movie) throws JAXBException, FileNotFoundException {
        getOrder().addMovie(movie);
        marshal();
    }

    public void removeMovie(String movie) throws JAXBException, FileNotFoundException {
        String[] splitString = movie.split("_");
        if (splitString.length == 3) {
            getOrder().removeMovie(splitString[1], splitString[2]);
            marshal();
        }
    }

    private void marshal() throws JAXBException, FileNotFoundException {
        JAXBContext jc = JAXBContext.newInstance(Order.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(getOrder(), new FileOutputStream(filePath));
    }

    public void cancelOrder() throws JAXBException, FileNotFoundException {
        setOrder(new Order());
        marshal();
    }
    
    public void setOrderUser(User user) throws JAXBException, FileNotFoundException{
        getOrder().setUserDetails(user);
        marshal();
    }
    
    public void setOrderDetails(String firstName, String lastName, String email, String paymentMethod) throws JAXBException, FileNotFoundException{
        getOrder().setFirstName(firstName);
        getOrder().setLastName(lastName);
        getOrder().setEmail(email);
        getOrder().setPaymentMethod(paymentMethod);
        marshal();
    }
}
