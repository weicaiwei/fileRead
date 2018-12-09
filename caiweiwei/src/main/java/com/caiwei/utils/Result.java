package com.caiwei.utils;

public class Result {
   
        public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

        private String status;
        private Object data;
        private String message;
        
        public Result(String status, Object data, String message) {
            this.status=status;
            this.data=data;
            this.message=message;
        }

}
