package cn.tgq007.seckill.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class UserModel {

    private Integer id;
    private String userName;
    private Integer gender;
    private Integer age;
    private String telphone;
    private String registerMode;
    private String thirdPartyId;
    private String encrptPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    @JsonIgnore
    public String getRegisterMode() {
        return registerMode;
    }

    @JsonProperty
    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    @JsonIgnore
    public String getThirdPartyId() {
        return thirdPartyId;
    }

    @JsonProperty
    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    @JsonIgnore
    public String getEncrptPassword() {
        return encrptPassword;
    }

    @JsonProperty
    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword;
    }
}
