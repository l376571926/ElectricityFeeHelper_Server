package group.tonight.electricityfeehelper_server;

import java.util.List;

public class PowerUserResponse extends BaseResponseBean {
    private List<PowerUser> data;

    public PowerUserResponse() {
    }

    public PowerUserResponse(List<PowerUser> data) {
        this.data = data;
    }

    public List<PowerUser> getData() {
        return data;
    }

    public void setData(List<PowerUser> data) {
        this.data = data;
    }
}
