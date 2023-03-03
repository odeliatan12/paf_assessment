package sg.edu.nus.iss.day22_workshop.models;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TransferAccount {

    private String id;
    private String fromAccountid;
    private String toAccountid;

    @NotEmpty(message = "please enter an amount")
    @Positive
    private Double ammount;
    private Double totalAmmount;
    private String comments;
    // private LocalDateTime date;

    public TransferAccount(){

    }

    public TransferAccount(String fromAccountid, String toAccountid, Double ammount, 
        String comments){
        this.fromAccountid = fromAccountid;
        this.toAccountid = toAccountid;
        this.ammount = ammount;
        this.comments = comments;
    }

    public TransferAccount(String id, String fromAccountid, String toAccountid, 
        Double ammount, String comments){
        this.id =  id;
        this.fromAccountid = fromAccountid;
        this.toAccountid = toAccountid;
        this.ammount = ammount;
        this.comments = comments;
        // this.date = date;
    }
    
    public String getFromAccountid() {
        return fromAccountid;
    }
    public void setFromAccountid(String fromAccountid) {
        this.fromAccountid = fromAccountid;
    }
    public String getToAccountid() {
        return toAccountid;
    }
    public void setToAccountid(String toAccountid) {
        this.toAccountid = toAccountid;
    }
    public Double getAmmount() {
        return ammount;
    }
    public void setAmmount(Double ammount) {
        this.ammount = ammount;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public Double getTotalAmmount() {
        return totalAmmount;
    }
    public void setTotalAmmount(Double totalAmmount) {
        this.totalAmmount = totalAmmount;
    }
    // public LocalDateTime getDate() {
    //     return date;
    // }
    // public void setDate(LocalDateTime localDateTime) {
    //     this.date = localDateTime;
    // }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
