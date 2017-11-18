package com.apegroup.api.pizza;
import com.apegroup.api.pizza.db.MenuService;
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
    private static final MenuService menuService = MenuService.getInstance();
    public static final String DEFAULT_MENU_ORDER_BY = "name";

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


    @GET
    @Path("/{id_restaurant}/menu")
    @Produces("application/json")
    public Response getMenus(@PathParam("id_restaurant") Integer id_restaurant,
                                @QueryParam("category") String category,
                                @QueryParam("orderBy") String orderBy)
    {
        if( null == orderBy || (! (orderBy.equals("name") || orderBy.equals("id"))))
        {
            orderBy = DEFAULT_MENU_ORDER_BY;
        }
        List<MetaDto> listOfData = menuService.getMenuData(id_restaurant, category, orderBy);
        log.debug("id_restaurant="+id_restaurant);
        log.debug("category="+category);
        log.debug("orderBy="+orderBy);
        return Response
                .status(200)
                .entity(listOfData)
                .build();
    }

}
