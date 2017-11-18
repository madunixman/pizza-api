package com.apegroup.api.pizza;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Hashtable;

@Path("/")
public class JSONService {

        @GET
        @Path("/getx")
        @Produces("application/json")
        public Hashtable<String, String> getItemInJSON_wrong() {
		       Hashtable<String, String>item = new Hashtable<String, String>();
        	       item.put("name", "my-name");
        	       item.put("surname", "my-surname");
                return item;

        }

        @GET
        @Path("/restaurants")
        @Produces("application/json")
        public Response getItemInJSON() {
                Hashtable<String, String>item = new Hashtable<String, String>();
                item.put("name", "my-name");
                item.put("surname", "my-surname");
                return Response.status(201).entity(item).build();
        }

        @POST
        @Path("/post")
        @Consumes("application/json")
        public Response createItemInJSON(Hashtable<String, String> item) {

                String result = "Item created : " + item;
                return Response.status(201).entity(result).build();

        }
}

