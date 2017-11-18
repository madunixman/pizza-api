package com.apegroup.api.pizza;

import com.apegroup.api.pizza.db.configdb.PizzaPersistentManager;
import net.lulli.metadao.api.MetaDto;
import org.apache.log4j.Logger;

import java.util.Hashtable;
import java.util.List;

public class RestaurantService {
    private static final Logger log =  Logger.getLogger("RestaurantService");
    private static final String queryRestaurantsList ="select * from restaurants.restaurant";
    private PizzaPersistentManager mPersistentManager;
    private static RestaurantService instance;

    private static List<MetaDto> mCachedRestaurantsList = null;
    private static Hashtable<Integer, MetaDto> mCachedRestaurantDetail = new Hashtable<>();

    private RestaurantService()
    {
        mPersistentManager = new PizzaPersistentManager();
        mCachedRestaurantDetail = new Hashtable<>();
    }

    public static RestaurantService getInstance()
    {
        if(null == instance)
        {
            instance = new RestaurantService();
        }
        return instance;
    }

    public List<MetaDto> getRestaurantsData() {
        List<MetaDto> listOfData = null;
        if (null == mCachedRestaurantsList)
        {
            log.debug("Before PizzaPersistentManager");
            try {
                log.debug("Before runQuery");
                listOfData = mPersistentManager.runQuery(queryRestaurantsList);
                log.debug("After runQuery");
                log.debug("Results:" + listOfData.size());
            } catch (Exception e) {
                log.debug(e);
            }
            mCachedRestaurantsList = listOfData;
        }
        return listOfData;
    }

    public MetaDto getRestaurantData(Integer id_restaurant) {
        MetaDto restaurantDto = null;
        List<MetaDto> resList = null;
        if (!mCachedRestaurantDetail.containsKey(id_restaurant)) {
            try {
                resList = mPersistentManager.runQuery("select * from restaurants.restaurant where id ='" + id_restaurant + "'");
                restaurantDto = resList.get(0);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                log.error("Param is not an integer or it is not present as an Id: " + id_restaurant.toString());
            }
            if (restaurantDto != null)
            {
                mCachedRestaurantDetail.put(id_restaurant, restaurantDto);
            }
        }
        else
        {
            restaurantDto = mCachedRestaurantDetail.get(id_restaurant);
        }
        return restaurantDto;
    }
}
