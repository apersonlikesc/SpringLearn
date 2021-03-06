package controller;

import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public ModelAndView user(){
        User user = new User();
        user.setFavorites((new String []{"Spring MVC","Struts 2"}));
        ModelAndView modelAndView = new ModelAndView("user", "command", user);
        return modelAndView;
    }
@RequestMapping(value = "/adduser",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("SpringWeb") User user, ModelMap modelMap){
        modelMap.addAttribute("username",user.getUsername());
        modelMap.addAttribute("address",user.getAddress());
    System.out.println(user.getAddress());
        modelMap.addAttribute("password",user.getPassword());
        modelMap.addAttribute("recivepaper",user.getRecivepaper());
        modelMap.addAttribute("favorites",user.getFavorites());
        return "userlist";
    }
    @ModelAttribute("webFrameworkList")
    public List<String> getWebFrameworkList()
    {
        List<String> webFrameworkList = new ArrayList<String>();
        webFrameworkList.add("Spring MVC");
        webFrameworkList.add("Spring Boot");
        webFrameworkList.add("Struts 2");
        webFrameworkList.add("Apache Hadoop");
        return webFrameworkList;
    }
}
