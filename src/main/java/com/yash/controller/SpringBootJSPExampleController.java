package com.yash.controller;

import com.yash.model.User;
import com.yash.model.UserDetail;
import com.yash.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by JavaDeveloperZone on 19-07-2017.
 */
@Controller
public class SpringBootJSPExampleController {

    @Autowired
    private LoginService loginService;
//    @GetMapping("/register")                     // it will handle all request for /welcome
//    public String SpringBootHello() {
//        return "register";           // welcome is view name. It will call welcome.jsp
//    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model) {
       model.addAttribute("userForm", new User());

        return "register";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm,@ModelAttribute("userD") UserDetail userDetail ,BindingResult bindingResult, Model model) {
       // userValidator.validate(userForm, bindingResult);

      if (bindingResult.hasErrors()) {
          return "registration";
      }
      userForm.setUserDetail(userDetail);
       userDetail.setUser(userForm);

        loginService.register(userForm);

        return "welcome";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value ="/login" , method = RequestMethod.POST)
    public String welcome(Model model,@ModelAttribute("userForm") User userForm,BindingResult result) {

        List<User> users=loginService.getAllUsers();
        for(User u:users){
            if((u.getUsername().equals(userForm.getUsername()))&&(u.getPassword().equals(userForm.getPassword()))){

                return "welcome";
            }

        }

        return "login";
    }

    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> users=loginService.getAllUsers();

        model.addAttribute("users", users);

        return "userlist";
    }
}


