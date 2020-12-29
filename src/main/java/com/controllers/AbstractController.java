package com.controllers;

import com.controllers.impl.ViewTripsController;
import com.service.user.TourService;
import com.service.user.UserService;
import com.service.user.impl.TourServiceImpl;
import com.service.user.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AbstractController {
    protected static final TourService TOUR_SERVICE = new TourServiceImpl();

    protected static final UserService USER_SERVICE = new UserServiceImpl();

    protected static final Logger LOGGER = LogManager.getLogger(AbstractController.class);

}
