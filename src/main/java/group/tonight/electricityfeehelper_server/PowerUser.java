package group.tonight.electricityfeehelper_server;


import javax.persistence.*;

/**
 * 用电用户数据实体
 */
@Entity
@Table(name = "t_power_user")
public class PowerUser {
    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_user_id")
    private long userId;//用户编号
    @Column(name = "t_user_name")
    private String userName;//用户名称
    @Column(name = "t_user_phone")
    private String userPhone;//联系方式
    @Column(name = "t_power_line_id")
    private String powerLineId;//抄表段编号，原来的serialId
    @Column(name = "t_power_line_name")
    private String powerLineName;//抄表段名称
    @Column(name = "t_meter_reading_day")
    private String meterReadingDay;//抄表例日
    @Column(name = "t_meter_reader")
    private String meterReader;//抄表员
    @Column(name = "t_measurement_point_id")
    private String measurementPointId;//计量点编号
    @Column(name = "t_meter_reading_id")
    private String meterReadingId;//抄表序号，原来的positionId
    @Column(name = "t_power_meter_id")
    private String powerMeterId;//电能表编号
    @Column(name = "t_power_value_type")
    private String powerValueType;//示数类型
    @Column(name = "t_last_power_value")
    private String lastPowerValue;//上次示数
    @Column(name = "t_current_power_value")
    private String currentPowerValue;//本次示数
    @Column(name = "t_consume_power_value")
    private String consumePowerValue;//抄见电量
    @Column(name = "t_comprehensive_ratio")
    private String comprehensiveRatio;//综合倍率
    @Column(name = "t_meter_reading_number")
    private String meterReadingNumber;//抄表位数
    @Column(name = "t_exception_types")
    private String exceptionTypes;//异常类型
    @Column(name = "t_meter_reading_status")
    private String meterReadingStatus;//抄表状态
    @Column(name = "t_power_supply_id")
    private String powerSupplyId;//供电单位
    @Column(name = "t_power_supply_name")
    private String powerSupplyName;//供电所
    @Column(name = "t_user_address")
    private String userAddress;//用电地址

    @Column(name = "t_ying_shou_sum")
    private double yingShouSum;
    @Column(name = "t_shi_shou_sum")
    private double shiShouSum;
    @Column(name = "t_qian_fei_sum")
    private double qianFeiSum;

    @Column(name = "t_create_time")
    private long createTime;
    @Column(name = "t_update_time")
    private long updateTime;
    @Column(name = "t_remarks")
    private String remarks;//备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPowerLineId() {
        return powerLineId;
    }

    public void setPowerLineId(String powerLineId) {
        this.powerLineId = powerLineId;
    }

    public String getPowerLineName() {
        return powerLineName;
    }

    public void setPowerLineName(String powerLineName) {
        this.powerLineName = powerLineName;
    }

    public String getMeterReadingDay() {
        return meterReadingDay;
    }

    public void setMeterReadingDay(String meterReadingDay) {
        this.meterReadingDay = meterReadingDay;
    }

    public String getMeterReader() {
        return meterReader;
    }

    public void setMeterReader(String meterReader) {
        this.meterReader = meterReader;
    }

    public String getMeasurementPointId() {
        return measurementPointId;
    }

    public void setMeasurementPointId(String measurementPointId) {
        this.measurementPointId = measurementPointId;
    }

    public String getMeterReadingId() {
        return meterReadingId;
    }

    public void setMeterReadingId(String meterReadingId) {
        this.meterReadingId = meterReadingId;
    }

    public String getPowerMeterId() {
        return powerMeterId;
    }

    public void setPowerMeterId(String powerMeterId) {
        this.powerMeterId = powerMeterId;
    }

    public String getPowerValueType() {
        return powerValueType;
    }

    public void setPowerValueType(String powerValueType) {
        this.powerValueType = powerValueType;
    }

    public String getLastPowerValue() {
        return lastPowerValue;
    }

    public void setLastPowerValue(String lastPowerValue) {
        this.lastPowerValue = lastPowerValue;
    }

    public String getCurrentPowerValue() {
        return currentPowerValue;
    }

    public void setCurrentPowerValue(String currentPowerValue) {
        this.currentPowerValue = currentPowerValue;
    }

    public String getConsumePowerValue() {
        return consumePowerValue;
    }

    public void setConsumePowerValue(String consumePowerValue) {
        this.consumePowerValue = consumePowerValue;
    }

    public String getComprehensiveRatio() {
        return comprehensiveRatio;
    }

    public void setComprehensiveRatio(String comprehensiveRatio) {
        this.comprehensiveRatio = comprehensiveRatio;
    }

    public String getMeterReadingNumber() {
        return meterReadingNumber;
    }

    public void setMeterReadingNumber(String meterReadingNumber) {
        this.meterReadingNumber = meterReadingNumber;
    }

    public String getExceptionTypes() {
        return exceptionTypes;
    }

    public void setExceptionTypes(String exceptionTypes) {
        this.exceptionTypes = exceptionTypes;
    }

    public String getMeterReadingStatus() {
        return meterReadingStatus;
    }

    public void setMeterReadingStatus(String meterReadingStatus) {
        this.meterReadingStatus = meterReadingStatus;
    }

    public String getPowerSupplyId() {
        return powerSupplyId;
    }

    public void setPowerSupplyId(String powerSupplyId) {
        this.powerSupplyId = powerSupplyId;
    }

    public String getPowerSupplyName() {
        return powerSupplyName;
    }

    public void setPowerSupplyName(String powerSupplyName) {
        this.powerSupplyName = powerSupplyName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public double getYingShouSum() {
        return yingShouSum;
    }

    public void setYingShouSum(double yingShouSum) {
        this.yingShouSum = yingShouSum;
    }

    public double getShiShouSum() {
        return shiShouSum;
    }

    public void setShiShouSum(double shiShouSum) {
        this.shiShouSum = shiShouSum;
    }

    public double getQianFeiSum() {
        return qianFeiSum;
    }

    public void setQianFeiSum(double qianFeiSum) {
        this.qianFeiSum = qianFeiSum;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "PowerUser{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", powerLineId='" + powerLineId + '\'' +
                ", powerLineName='" + powerLineName + '\'' +
                ", meterReadingDay='" + meterReadingDay + '\'' +
                ", meterReader='" + meterReader + '\'' +
                ", measurementPointId='" + measurementPointId + '\'' +
                ", meterReadingId='" + meterReadingId + '\'' +
                ", powerMeterId='" + powerMeterId + '\'' +
                ", powerValueType='" + powerValueType + '\'' +
                ", lastPowerValue='" + lastPowerValue + '\'' +
                ", currentPowerValue='" + currentPowerValue + '\'' +
                ", consumePowerValue='" + consumePowerValue + '\'' +
                ", comprehensiveRatio='" + comprehensiveRatio + '\'' +
                ", meterReadingNumber='" + meterReadingNumber + '\'' +
                ", exceptionTypes='" + exceptionTypes + '\'' +
                ", meterReadingStatus='" + meterReadingStatus + '\'' +
                ", powerSupplyId='" + powerSupplyId + '\'' +
                ", powerSupplyName='" + powerSupplyName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", yingShouSum=" + yingShouSum +
                ", shiShouSum=" + shiShouSum +
                ", qianFeiSum=" + qianFeiSum +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
