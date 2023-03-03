package sg.edu.nus.iss.day22_workshop;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.day22_workshop.models.Account;
import sg.edu.nus.iss.day22_workshop.models.TransferAccount;

public class Utils {
    public static Account createAccount(SqlRowSet rs){
        Account a = new Account();
        a.setAccount_id("account_id");
        a.setName(rs.getString("name"));
        a.setBalance(rs.getDouble("balance"));
        return a;
    }

    public static JsonObject toJSON(TransferAccount a){
        return Json.createObjectBuilder()
                    .add("transactionId", a.getId())
                    .add("from_account", a.getFromAccountid())
                    .add("to_account", a.getToAccountid())
                    .build();
    }

    
}
