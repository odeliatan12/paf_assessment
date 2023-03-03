package sg.edu.nus.iss.day22_workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sg.edu.nus.iss.day22_workshop.models.Account;
import sg.edu.nus.iss.day22_workshop.models.TransferAccount;
import sg.edu.nus.iss.day22_workshop.service.FundsTransferService;

@Controller
public class LandingPageController {

    @Autowired
    private FundsTransferService service;

    @GetMapping(path = {"/", "/index.html"})
    public String getLandingPage(Model model){

        System.out.println(">>>>>>>>>>> hellloooooo");
        // Querying for the database
        List<Account> result = service.getAllAccounts();
        System.out.println(">>>>>> ");
        model.addAttribute("account", result);
        model.addAttribute("validation", new TransferAccount());
        return "index";
    }
    
}
