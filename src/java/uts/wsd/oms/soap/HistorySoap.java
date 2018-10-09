package uts.wsd.oms.soap;

import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import uts.wsd.oms.*;

@WebService(serviceName = "History")
public class HistorySoap {

    @Resource
    private WebServiceContext context;

    private MovieStoreApplication getMovieStoreApp() {
        ServletContext application = (ServletContext) context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
        MovieStoreApplication movieStoreApp = (MovieStoreApplication) application.getAttribute("movieStoreApp");
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
