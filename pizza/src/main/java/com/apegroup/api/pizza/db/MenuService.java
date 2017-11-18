package com.apegroup.api.pizza.db;

import com.apegroup.api.pizza.db.configdb.PizzaPersistentManager;
import net.lulli.metadao.api.MetaDto;
import org.apache.log4j.Logger;
import java.util.List;

public class MenuService {
    private static final String ALLOW_FILTERING=" ALLOW FILTERING";
    private static final Logger log =  Logger.getLogger("RestaurantService");
    private static final String queryMenusList ="select * from restaurants.menu";
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

    public List<MetaDto> getMenuData(Integer id_restaurant, String category, String orderBy) {
        List<MetaDto> listOfData = null;
        if (null == mCachedMenuList)
        {
            log.debug("Before PizzaPersistentManager");
            try {
                log.debug("Before runQuery");
                String qSelectMenus = "select * from restaurants.menu where id_restaurant ='"+id_restaurant+"' " +ALLOW_FILTERING;
                listOfData = mPersistentManager.runQuery(qSelectMenus);
                log.debug("After runQuery");
                log.debug("Results:" + listOfData.size());
                mCachedMenuList = listOfData;
            } catch (Exception e) {
                log.debug(e);
            }
        }
        return mCachedMenuList;
    }
}