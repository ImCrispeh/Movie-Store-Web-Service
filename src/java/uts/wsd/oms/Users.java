package uts.wsd.oms;

import java.util.*;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class Users implements Serializable {

    @XmlElement(name = "user")
    private ArrayList<User> list = new ArrayList<User>();

    public ArrayList<User> getList() {
        return list;
    }

    public void addUser(User user) {
        list.add(user);
    }

    public boolean registerUser(User user) {
        if (list.stream().filter(u -> u.getEmail().equals(user.getEmail())).findFirst().isPresent()) {
            return false;
        } else {
            addUser(user);
            return true;
        }
    }

    public User getUser(String email) {
        if (list.stream().filter(u -> u.getEmail().equals(email)).findFirst().isPresent()) {
            return list.stream().filter(u -> u.getEmail().equals(email)).findFirst().get();
        } else {
            return null;
        }
    }

    public void removeUser(User user) {
        list.remove(user);
    }

    public User login(String email, String password) {
        for (User user : list) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;

    }

    public void editUser(User user, String firstName, String lastName, String email, String password, String phoneNo, String address, String city, String state, String postCode){
        removeUser(user);
        user.updateUser(firstName, lastName, email, password, phoneNo, address, city, state, postCode);
    }
}
