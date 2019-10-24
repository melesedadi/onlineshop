package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
	private LoginService loginService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
	
	@RequestMapping("/")
	public String index(Model model) {
		return "loginform";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
    public String getLoginForm(){
        return "loginform";
    }
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String doLogin(@ModelAttribute(name = "loginForm") User user, Model model)
	{

        if(loginService.findUser(user.getUsername(),user.getPassword())!= null)
        {
            return "home";
        }
        else
        {
            model.addAttribute("invalidCredentials",true);
            return "loginform";
        }
    }
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegisterForm(Model model)
	{
        model.addAttribute("user",new User());

	    return "registerform";
    }
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@Valid User userForm, BindingResult result){

	    if(result.hasErrors()){
	        return "registerform";
        }

       String firstname = userForm.getFirstname();
       String lastname = userForm.getLastname();
       String username = userForm.getUsername();
       String password = userForm.getPassword();

       User user = new User(firstname,lastname,username,password);

       loginService.registerUser(user);
       return "loginform";
    }

    @RequestMapping("/userslist")
    public String departmentList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "userslist";

    }

    @PostMapping("/processuser")
    public String processForm1(@Valid User user,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "registerform";
        }
        userRepository.save(user);
        return "redirect:/userslist";
    }
    @RequestMapping("/balancelist")
    public String employeeList(Model model){
        model.addAttribute("accounts", accountRepository.findAll());
        return "balancelist";
    }

    @GetMapping("/addbalance")
    public String employeeForm(Model model){
        model.addAttribute("account", new Account());
        model.addAttribute("user", userRepository.findAll());
        return "balanceform";
    }
    @PostMapping("/processbalance")
    public String processForm2(@Valid Account account,
                               BindingResult result){
        if (result.hasErrors()){
            return "balanceform";
        }
        accountRepository.save(account);
        return "redirect:/balancelist";
    }
    @RequestMapping("/detailbalance/{id}")
    public String showPerson(@PathVariable("id") int id, Model model)
    {model.addAttribute("account", accountRepository.findAll());
        return "showbalance";
    }
    @RequestMapping("/updatebalance/{id}")
    public String updatePerson(@PathVariable("id") int id,Model model){
        model.addAttribute("account", accountRepository.findById(id).get());
        return "balanceform";
    }
    @RequestMapping("/deletebalance/{id}")
    public String delPerson(@PathVariable("id") int id){
        accountRepository.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/detailuser/{id}")
    public String showPet(@PathVariable("id") int id, Model model)
    {model.addAttribute("user", userRepository.findById(id).get());
        return "showusers";
    }
    @RequestMapping("/updateuser/{id}")
    public String updatePet(@PathVariable("id") int id,Model model){
        model.addAttribute("account", accountRepository.findById(id).get());
        model.addAttribute("users", userRepository.findAll());
        return "registerform";
    }
    @RequestMapping("/deleteuser/{id}")
    public String delPet(@PathVariable("id") int id){
        userRepository.deleteById(id);
        return "redirect:/";
    }
  }
