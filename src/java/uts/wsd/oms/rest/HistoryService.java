package uts.wsd.oms.rest;
        
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import uts.wsd.oms.*;

@Path("/movieStoreApp")
public class HistoryService {
    
    @Context
    private ServletContext application;

    private MovieStoreApplication getMovieStoreApp() throws JAXBException, IOException {
        synchronized (application) {
            MovieStoreApplication movieStoreApp = (MovieStoreApplication) application.getAttribute("movieStoreApp");
            if (movieStoreApp == null) {
                movieStoreApp = new MovieStoreApplication();
                movieStoreApp.setFilePath(application.getRealPath("WEB-INF"));
                application.setAttribute("movieStoreApp", movieStoreApp);
            }
            return movieStoreApp;
        }
    }
    
    @Path("history/all")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getHistory() throws JAXBException, IOException {
        return getMovieStoreApp().getHistory().getOrders();
    }
    
    @Path("history")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getHistoryByParams(@DefaultValue("-1") @QueryParam("id") int id, @QueryParam("email") String email,
            @QueryParam("title") String title, @QueryParam("status") String status) throws JAXBException, IOException {
        
        return getMovieStoreApp().getHistory().getOrdersByParams(id, email, title, status);
    }
}
