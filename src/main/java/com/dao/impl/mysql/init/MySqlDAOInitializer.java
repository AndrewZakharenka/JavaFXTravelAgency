package com.dao.impl.mysql.init;

import com.dao.init.DAOInitializer;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MySqlDAOInitializer implements DAOInitializer {
    private static final Logger LOGGER = LogManager.getLogger(MySqlDAOInitializer.class);
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private volatile boolean isInit;

    @Override
    public void init() {
        if (!isInit){
            try{
                Class.forName(DRIVER);
                isInit = true;
                LOGGER.info("DAO initialized");
            } catch (ClassNotFoundException e){
                LOGGER.error("Unable to load JDBC driver: {" + e.getMessage() + "}", e);
            }
        }
    }
}
