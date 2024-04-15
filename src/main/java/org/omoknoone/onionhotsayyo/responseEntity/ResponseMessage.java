package org.omoknoone.onionhotsayyo.responseEntity;

import java.util.Map;

public class ResponseMessage {

    private int httpStatus;                 // 상태코드
    private String message;                 // 응답 메세지
    private Map<String, Object> result;     // 응답 데이터

    public ResponseMessage() {
    }

    public ResponseMessage(int httpStatus, String message, Map<String, Object> result) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.result = result;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "httpStatus=" + httpStatus +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
