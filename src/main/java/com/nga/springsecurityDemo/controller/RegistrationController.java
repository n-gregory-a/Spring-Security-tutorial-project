package com.nga.springsecurityDemo.controller;

import com.nga.springsecurityDemo.entity.User;
import com.nga.springsecurityDemo.service.UserService;
import com.nga.springsecurityDemo.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoggingPage(Model model) {
        model.addAttribute("crmUser", new CrmUser());

        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser crmUser,
            BindingResult bindingResult,
            Model model
    ) {

        String userName = crmUser.getUserName();
        logger.info("Processing registration form for: " + userName);

        // form validation
        if (bindingResult.hasErrors()) {
            return "registration-form";
        }

        // check the database if user already exists
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("registrationError", "User name already exists.");
            logger.warning("User name already exists.");
            return "registration-form";
        }

        // save user in the database
        userService.save(crmUser);
        logger.info("Successfully created user: " + userName);

        return "registration-confirmation";
    }

}
