package cn.tgq007.seckill.model;

import cn.tgq007.seckill.utils.IsMobile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class UserModel {

    private Integer id;
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    private Integer gender;
    private Integer age;
    @IsMobile(message = "手机号不正确")
    private String telephone;
    private String registerMode;
    private String thirdPartyId;
    @NotEmpty(message = "密码不能为空")
    private String encrptPassword;
    @NotEmpty(message = "验证码不能为空")
    private String otpCode;

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
        return telephone;
    }

    public void setTelphone(String telphone) {
        this.telephone = telphone;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }
}
