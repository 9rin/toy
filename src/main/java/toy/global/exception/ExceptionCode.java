package toy.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionCode {

    // 404 Not Found
    TWEET_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.TWEET_NOT_FOUND, "트윗이 존재하지 않습니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.COMMENT_NOT_FOUND, "댓글이 존재하지 않습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, ClientExceptionCode.USER_NOT_FOUND, "계정이 존재하지 않습니다."),

    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, ClientExceptionCode.INTERNAL_SERVER_ERROR, "예상치 못한 서버에러가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final ClientExceptionCode clientExceptionCode;
    private final String message;

    ExceptionCode(HttpStatus httpStatus, ClientExceptionCode clientExceptionCode, String message) {
        this.httpStatus = httpStatus;
        this.clientExceptionCode = clientExceptionCode;
        this.message = message;
    }

}
