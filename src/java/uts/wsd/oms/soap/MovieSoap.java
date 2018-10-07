/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.wsd.oms.soap;

import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.jws.*;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import uts.wsd.oms.*;

@WebService(serviceName = "Movie")
public class MovieSoap {

    @Resource
    private WebServiceContext context;

    private MovieStoreApplication getMovieStoreApp() {
        ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        MovieStoreApplication movieStoreApp = (MovieStoreApplication) application.getAttribute("diaryApp");
        try {
            if (movieStoreApp == null) {
                movieStoreApp = new MovieStoreApplication();
                movieStoreApp.setFilePath(application.getRealPath("WEB-INF"));
                application.setAttribute("movieStoreApp", movieStoreApp);
            }
        } catch (JAXBException | IOException ex) {
        }
        return movieStoreApp;
    }
    
    @WebMethod()
    public History ViewAllOrders(@WebParam(name = "orderID") String orderID, @WebParam(name = "email") String email, @WebParam(name = "title") String title, @WebParam(name = "status") String status) {
        History history = new History();
        int id = -1;
        try{
            id = Integer.parseInt(orderID);
        }catch(NumberFormatException ex){
        }
        history.setOrders((ArrayList<Order>)getMovieStoreApp().getHistory().getOrdersByParams(id, email, title, status));
        return history;
    }
}
