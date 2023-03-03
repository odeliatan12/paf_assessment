package sg.edu.nus.iss.day22_workshop.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import sg.edu.nus.iss.day22_workshop.exception.OrderException;
import sg.edu.nus.iss.day22_workshop.models.Account;
import sg.edu.nus.iss.day22_workshop.models.TransferAccount;
import sg.edu.nus.iss.day22_workshop.repo.PageRepoImpl;

@Service
public class FundsTransferService {
    
    @Autowired
    private PageRepoImpl repo;

    public List<Account> getAllAccounts(){
        return repo.getAllAccounts();
    }

    // Perform transaction
    @Transactional(rollbackOn = OrderException.class)
    public void createFundTransfer(TransferAccount ac) throws OrderException{

        String transactionid = UUID.randomUUID().toString().substring(0,8);
        // Getting timestamp
        ac.setId(transactionid);
        // ac.setDate(LocalDateTime.now());
        Boolean result = repo.saveIntoTransactionAccount(ac);
        System.out.println(">>>>>>>" + result);
        
        // querying the balance 
        Double getFromAccount1 = repo.getBalancebyId(ac.getFromAccountid());

        System.out.println(">>>>>>>" + getFromAccount1);
        Double getFromAccount2 = repo.getBalancebyId(ac.getToAccountid());

        
        Double amount = ac.getAmmount();
        Double Account1balance = getFromAccount1 - amount;
        Double Account2balance = getFromAccount2 + amount;
        
        if(ac.getFromAccountid() == ac.getToAccountid()){
            if(amount < 0){
                if(amount == 0){
                    if(amount > getFromAccount2){
                        if(amount < 10){
                            throw new OrderException();
                        }
                    }
                }
            }
        } else {
            // Updating into account 2;
            Boolean account1 = repo.updateAccount(Account1balance, ac.getFromAccountid());
            System.out.println(">>>>>>> account1" + account1);
            Boolean account2 = repo.updateAccount(Account2balance, ac.getToAccountid());
            System.out.println(">>>>>> account2" + account2);
        }
        
    }

    
}
