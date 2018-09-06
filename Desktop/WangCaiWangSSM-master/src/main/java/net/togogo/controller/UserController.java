package net.togogo.controller;

import net.togogo.bean.Company;
import net.togogo.bean.User;
import net.togogo.service.CompanyService;
import net.togogo.service.UserService;
import net.togogo.utis.newMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @SuppressWarnings("deprecation")
    @RequestMapping("/register")
    @ResponseBody
    public String register(@RequestParam("email") String email,
                           @RequestParam("password")String password,
                           @RequestParam("username")String username,
                           @RequestParam("role")String role,
                           HttpSession session) throws NoSuchAlgorithmException {
        if (userService.checkExist(email)|| companyService.checkExist(email)){
            return "emailExist";
        }
        else if (role.equals("person")){
            String upassword = newMD5.generateCode(password);
            User user = new User(email,upassword,username);
            boolean rs = userService.createUser(user);
            if (rs)
                return "success";
            else
                return "fail";
        }
        else if (role.equals("company")){
            String upassword = newMD5.generateCode(password);
            Company company = new Company(email,upassword,username);
            boolean rs = companyService.createCompany(company);
            if (rs)
                return "success";
            else
                return "fail";
        }
        return "fail";
    }
}
