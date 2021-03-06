package controller;


import beans.student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class stdcontroller {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public ModelAndView student(){
        return new ModelAndView("student","command",new student());
    }
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb")student student,
                             ModelMap model) {
        model.addAttribute("name", "dsa");
        model.addAttribute("age", student.getAge());
        model.addAttribute("id", student.getId());
        return "result";
    }

}
