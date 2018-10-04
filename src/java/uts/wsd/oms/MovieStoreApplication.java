package uts.wsd.oms;

import java.io.*;
import java.util.*;
import javax.xml.bind.*;

public class MovieStoreApplication implements Serializable {

    private String filePath;
    private Movies movies;
    private Users users;
    private History history;

    public MovieStoreApplication() {
    }

    public MovieStoreApplication(String filePath, Movies movies) {
        this.filePath = filePath;
        this.movies = movies;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) throws JAXBException, FileNotFoundException, IOException {
        this.filePath = filePath;

        JAXBContext jc = JAXBContext.newInstance(Movies.class);
        Unmarshaller u = jc.createUnmarshaller();

        FileInputStream file = new FileInputStream(filePath + "/movies.xml");
        movies = (Movies) u.unmarshal(file);
        file.close();

        jc = JAXBContext.newInstance(Users.class);
        u = jc.createUnmarshaller();

        file = new FileInputStream(filePath + "/users.xml");
        users = (Users) u.unmarshal(file);
        file.close();

        jc = JAXBContext.newInstance(History.class);
        u = jc.createUnmarshaller();

        file = new FileInputStream(filePath + "/history.xml");
        history = (History) u.unmarshal(file);
        file.close();
        Util.initOrderID(history);
    }

    public Movies getMovies() {
        return movies;
    }

    public void setMovies(Movies movies) {
        this.movies = movies;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public void addMovie(Movie movie) throws JAXBException, FileNotFoundException {
        getMovies().addMovie(movie);
        JAXBContext jc = JAXBContext.newInstance(Movies.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(getMovies(), new FileOutputStream(filePath + "/movies.xml"));
    }

    public boolean registerUser(User user) throws JAXBException, FileNotFoundException {
        if (users.registerUser(user)) {
            JAXBContext jc = JAXBContext.newInstance(Users.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(users, new FileOutputStream(filePath + "/users.xml"));
            return true;
        } else {
            return false;
        }
    }

    public void addOrder(Order order) throws JAXBException, FileNotFoundException {
        getHistory().addOrder(order);
        JAXBContext jc = JAXBContext.newInstance(History.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(getHistory(), new FileOutputStream(filePath + "/history.xml"));
    }

    public void cancelOrder(int orderId) throws JAXBException, FileNotFoundException {
        if (getHistory().getOrders().stream().filter(u -> u.getOrderID() == orderId).findFirst().isPresent()) {
            getHistory().getOrders().stream().filter(u -> u.getOrderID() == orderId).findFirst().get().setOrderStatus("cancelled");
            JAXBContext jc = JAXBContext.newInstance(History.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(getHistory(), new FileOutputStream(filePath + "/history.xml"));
        }
    }

    public boolean validateName(String name) {
        return name.matches("[A-Z]([a-zA-]*)");
    }

    public boolean validatePhoneNo(String phoneNo) {
        return phoneNo.matches("([0-9]{10})");
    }

    public boolean validateCity(String city) {
        return city.matches("([a-zA-Z\\s]+)");
    }

    public boolean validatePostCode(String postCode) {
        return postCode.matches("([0-9]{4})");
    }

    public boolean validateEmail(String email) {
        return email.matches("[A-z][A-z\\._]*@[A-z]+(\\.[A-z]+)+");
    }

    public boolean validatePassword(String password) {
        return password.matches("([a-zA-Z0-9]{8,})");
    }
}
