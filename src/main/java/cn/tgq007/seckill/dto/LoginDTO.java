package cn.tgq007.seckill.dto;

import javax.validation.constraints.NotEmpty;

public class LoginDTO {

    @NotEmpty(message = "手机号不能为空")
    private String telephone;
    @NotEmpty(message = "密码不能为空")
    private String password;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
