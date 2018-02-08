package cn.ccut.invoice.exception;

/**
 * 自定义异常类，针对预期的异常
 *
 * @authorMr.Robot
 * @create2018-02-08 15:41
 */
public class CustomException extends Exception{
    //异常信息
    public String message;

    public CustomException(String message){
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
