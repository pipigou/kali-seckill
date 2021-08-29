package cn.tgq007.seckill.dto;

import javax.validation.constraints.NotNull;

public class TelephoneDTO {

    @NotNull(message = "手机号码不能为空")
    private String telephone;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
