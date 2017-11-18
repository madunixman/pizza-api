package com.apegroup.api.pizza;
import net.lulli.metadao.api.MetaDto;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class JSONService
{
    private static final Logger log = Logger.getLogger("JSONService");
    private static final RestaurantService restaurantService = RestaurantService.getInstance();

    @GET
    @Path("/restaurants")
    @Produces("application/json")
    public Response getRestaurants()
    {
        List<MetaDto> listOfData = restaurantService.getRestaurantsData();
        return Response
                .status(201)
                .entity(listOfData)
                .build();
    }

    @GET
    @Path("/restaurants/{id_restaurant}")
    @Produces("application/json")
    public Response printMessage(@PathParam("id_restaurant") Integer id_restaurant)
    {
        MetaDto restaurantDto = restaurantService.getRestaurantData(id_restaurant);
        return Response.status(200)
                .entity(restaurantDto)
                .build();
    }
}
