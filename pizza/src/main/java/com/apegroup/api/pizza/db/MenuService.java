package com.apegroup.api.pizza.db;

import com.apegroup.api.pizza.RestaurantService;
import com.apegroup.api.pizza.db.configdb.PizzaPersistentManager;
import net.lulli.metadao.api.MetaDto;
import org.apache.log4j.Logger;

import java.util.Hashtable;
import java.util.List;

public class MenuService {
    private static final Logger log =  Logger.getLogger("RestaurantService");
    private static final String queryMenusList ="select * from restaurants.restaurant";
    private PizzaPersistentManager mPersistentManager;
    private static MenuService instance;

    private static List<MetaDto> mCachedMenuList = null;


    private MenuService()
    {
        mPersistentManager = new PizzaPersistentManager();
    }

    public static MenuService getInstance()
    {
        if(null == instance)
        {
            instance = new MenuService();
        }
        return instance;
    }
}
