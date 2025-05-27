package toy.global.exception;

import org.springframework.http.HttpStatusCode;

public class ToyException extends RuntimeException {

    private final ExceptionCode exceptionCode;

    public ToyException(ExceptionCode exceptionCode){
        this.exceptionCode = exceptionCode;
    }

    @Override
    public String getMessage() {
        return exceptionCode.getMessage();
    }

    public HttpStatusCode getHttpStatusCode(){
        return exceptionCode.getHttpStatus();
    }

    public String getClientExceptionCodeName(){
        return exceptionCode.getClientExceptionCode().name();
    }

}
