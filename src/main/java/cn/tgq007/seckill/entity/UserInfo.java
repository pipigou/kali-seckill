package cn.tgq007.seckill.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cloud
 * @since 2021-08-28
 */
@TableName("ums_user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 0.未知，1.男性，2.女性
     */
    private Integer gender;

    private Integer age;

    /**
     * 电话号码
     */
    private String telphone;

    /**
     * 注册方式
     */
    private String registerMode;

    /**
     * 第三方登录方式
     */
    private String thirdPartyId;

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
    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }
    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
            "id=" + id +
            ", userName=" + userName +
            ", gender=" + gender +
            ", age=" + age +
            ", telphone=" + telphone +
            ", registerMode=" + registerMode +
            ", thirdPartyId=" + thirdPartyId +
        "}";
    }
}
