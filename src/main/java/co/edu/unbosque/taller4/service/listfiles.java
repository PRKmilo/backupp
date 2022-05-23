package co.edu.unbosque.taller4.service;


import co.edu.unbosque.taller4.Dto.Pieza;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@Path("/imagenes")
public class listfiles extends HttpServlet {
    private String UPLOAD_DIRECTORY = "imagen";
    private ImageServices imageServices;
    public listfiles(){
        this.imageServices=new ImageServices();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public Response list(){
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        return null;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {



        // Specifying the content type for the response
        response.setContentType("application/json");
        System.out.println("fiel en doget de la linea 25");
        // Getting an instance of the upload path
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);

        // Listing file names in path
        List<String> files = new ArrayList<String>();
        List<Pieza> piezas=imageServices.getPieces().get();



        for(int i=0;i< uploadDir.listFiles().length;i++){
            files.add(UPLOAD_DIRECTORY + File.separator + "Captura de pantalla (6).png");
        }

        // Adding the data to response, parsing it to json using Gson library
        PrintWriter out = response.getWriter();
        out.println(new Gson().toJson(files));
    }



}