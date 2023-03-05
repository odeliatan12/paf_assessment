package sg.edu.nus.iss.day22_workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import sg.edu.nus.iss.day22_workshop.exception.OrderException;
import sg.edu.nus.iss.day22_workshop.models.TransferAccount;
import sg.edu.nus.iss.day22_workshop.service.FundsTransferService;
import sg.edu.nus.iss.day22_workshop.service.LogAuditService;

@Controller
public class FundsTransferController {

    @Autowired
    private FundsTransferService service;

    // @Autowired
    // private LogAuditService auditservice;
    
    @PostMapping(path = "/postTransfer")
    public String postForm(@RequestBody MultiValueMap<String, String> form, Model model) throws OrderException{

        System.out.println(">>>>>>>> form" + form);
        String fromAccount = form.getFirst("fromAccount");
        String toAccount = form.getFirst("toAccount");
        String comments = form.getFirst("comments");
        Double amount = Double.parseDouble(form.getFirst("ammount"));
        System.out.println(">>>>>>> amount" + amount);
        TransferAccount ac = new TransferAccount(fromAccount, toAccount, amount, comments);
        service.createFundTransfer(ac);
        // auditservice.insertTransaction(ac);
        model.addAttribute("fromAccount", fromAccount);
        model.addAttribute("toAccount", toAccount);
        model.addAttribute("amount", amount);
        model.addAttribute("transferaccount", ac);
        return "transfer";
    }
}
