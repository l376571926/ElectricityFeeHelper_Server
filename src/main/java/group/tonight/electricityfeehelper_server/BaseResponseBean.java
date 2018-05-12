package group.tonight.electricityfeehelper_server;

public class BaseResponseBean {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseResponseBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
