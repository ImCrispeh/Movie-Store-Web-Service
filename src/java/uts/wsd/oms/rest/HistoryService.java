package uts.wsd.oms.rest;

import com.sun.jersey.api.provider.jaxb.XmlHeader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
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

    @Path("history")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @XmlHeader("<?xml-stylesheet type=\"text/xsl\" href=\"/Project/xsl/historyRest.xsl\"?>")
    public History getHistoryByParams(@DefaultValue("-1") @QueryParam("id") int id, @QueryParam("email") String email,
            @QueryParam("title") String title, @QueryParam("status") String status) throws JAXBException, IOException {
        History history = new History();
        history.setOrders((ArrayList) getMovieStoreApp().getHistory().getOrdersByParams(id, email, title, status));
        return history;
    }
}
