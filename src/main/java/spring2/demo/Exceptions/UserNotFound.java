package spring2.demo.Exceptions;

public class UserNotFound extends Exception{
    public UserNotFound(String meassage) {
        super(meassage);
    }
}
