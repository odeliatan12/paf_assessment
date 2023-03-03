package sg.edu.nus.iss.day22_workshop.exception;

// to handle custom exceptions for @transactional methods
public class OrderException extends Exception {
    
    public OrderException(){
        super();
    }

    public OrderException(String msg){
        super(msg);
    }
}