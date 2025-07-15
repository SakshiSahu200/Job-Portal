package com.example.jobportal.controller;

import com.example.jobportal.entity.Users;
import com.example.jobportal.entity.UsersType;
import com.example.jobportal.services.UsersService;
import com.example.jobportal.services.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String Register(Model model){
        List<UsersType> usersType = usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersType);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistration(@Valid Users users, Model model){
//        System.out.println("User: " + users);
        Optional<Users>optionalUsers = usersService.getUserByEmail(users.getEmail());
        if(optionalUsers.isPresent()){
            List<UsersType> usersType = usersTypeService.getAll();
            model.addAttribute("error","Email already exists");
            model.addAttribute("getAllTypes", usersType);
            model.addAttribute("user", new Users());
            return "register";
        }
        usersService.addNew(users);
        return "dashboard";
    }
}
