package com.clairevenant.springProject.Contoller;

import com.clairevenant.springProject.Model.User;
import org.springframework.web.bind.annotation.*;


@RestController
public class HomeController {

    @RequestMapping
    public String home(){
        return "Hello world" ;
    }


    //@RequestMapping(value = "/user" , method = RequestMethod.GET)
    @RequestMapping("/user")
    public User userMethod(){
        User user = new User();
        user.setId("2");
        user.setName("Simba");
        user.setEmailId("simba@gmail.com");
        return user;
    }

    @GetMapping("/{id}/{name}")
    public String pathVariable(@PathVariable String id ,
                               @PathVariable("name") String LastName){
        return " The id is : "+id +"  and name is : "+LastName;

    }
    @GetMapping("/requestParam")

    public String requestParam(
            @RequestParam(required = false,defaultValue = "") String name ,
            @RequestParam(name = "email") String emailId){
        return name +" "+emailId;
    }
}

