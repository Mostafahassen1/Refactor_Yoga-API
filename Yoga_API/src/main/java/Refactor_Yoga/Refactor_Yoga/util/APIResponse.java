package Refactor_Yoga.Refactor_Yoga.util;

public class APIResponse<T> {
    private int status ;
    private String message ;
    private  T data ;

    public APIResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> APIResponse<T> ok(T data){
        return  new APIResponse<>(200 , "Success" , data) ;
    }
    public static <T> APIResponse<T> notFound(){
        return  new APIResponse<>(404 , "Element is not found" , null) ;
    }

    public static <T> APIResponse<T> badRequest(){
        return new APIResponse<>(400 , "This is a bad Request" , null ) ;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
