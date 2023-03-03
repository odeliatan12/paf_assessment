package sg.edu.nus.iss.day22_workshop.repo;

public class Queries {
    
    public static final String SQL_GETALLACCOUNTS = "select * from accounts";
    public static final String SQL_GETACCOUNDBYID = "select * from accounts where ";
    public static final String SQL_INSERTINTOACCOUNT = "insert into accounts(account_id, name, balance) values (?, ?, ?)";
    public static final String SQL_UPDATEACCOUNT = """
        UPDATE accounts
        SET balance = ?
        WHERE account_id = ?;
        """;

    public static final String SQL_INSERTINTOTRANSFERACCOUNT = """
        insert into transferAccount(id, from_account, to_account, ammount_transferred, comments) 
        values ( ?, ?, ?, ?, ?);
        """;

    public static final String SQL_GETBALANCE = """
        select balance from accounts where account_id = ?;    
        """;
}
