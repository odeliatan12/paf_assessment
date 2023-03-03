package sg.edu.nus.iss.day22_workshop.repo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day22_workshop.Utils;
import sg.edu.nus.iss.day22_workshop.models.Account;
import sg.edu.nus.iss.day22_workshop.models.TransferAccount;

import static sg.edu.nus.iss.day22_workshop.repo.Queries.*;

@Repository
public class PageRepoImpl {
    
    @Autowired
    private JdbcTemplate template;

    public List<Account> getAllAccounts(){

        return template.query(SQL_GETALLACCOUNTS, BeanPropertyRowMapper.newInstance(Account.class));
    }

    public Double getBalancebyId(String accountId){
        return template.queryForObject(SQL_GETBALANCE, Double.class, accountId);
    }
    public List<Account> getAccountbyId(String accountId){
        List<Account> resultList = new LinkedList<Account>();
        resultList = template.query(SQL_GETACCOUNDBYID, BeanPropertyRowMapper.newInstance(Account.class), accountId);
        return resultList;
    }

    // Updating into account
    public Boolean updateAccount(Double totalAmount, String account_id){
        Integer result = template.update(SQL_UPDATEACCOUNT, totalAmount, account_id);
        return result > 0 ? true : false;
    }

    // Saving into account
    public Boolean saveIntoTransactionAccount(TransferAccount ta){
        Integer result = template.update(SQL_INSERTINTOTRANSFERACCOUNT,
            ta.getId(), ta.getFromAccountid(), ta.getToAccountid(), ta.getAmmount(), ta.getComments());
        return result > 0 ? true : false;
    }
}
