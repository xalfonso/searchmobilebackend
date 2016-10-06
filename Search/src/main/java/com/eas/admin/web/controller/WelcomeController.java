package com.eas.admin.web.controller;

import com.eas.admin.dao.UserDao;
import com.eas.admin.entity.Privilege;
import com.eas.admin.entity.User;
import com.eas.admin.facade.AdminFacade;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Resource
    private AdminFacade adminFacade;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {

        //	    User user = new User();
//            user.setUsername("E.MARTINEZ")
//                    .setPassword("PASSSSSDFFG")
//                    .setName("Eduardo")
//                    .setSurname("Alfonso Sanchez")
//                    .setCreateDate(new Date());
//            this.adminFacade.insertUser(user);
//            
//            model.addAttribute("id", user.getId());


        /*
        try {
            this.adminFacade.resetPrivileges();
        } catch (Exception ex) {
            logger.error("Error: " + ex.getMessage());
        }
        */
        
        
        return "welcome";
    }

}
