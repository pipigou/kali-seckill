package cn.tgq007.seckill.controller;

import cn.tgq007.seckill.dto.TelephoneDTO;
import cn.tgq007.seckill.entity.ResponseData;
import cn.tgq007.seckill.model.UserModel;
import cn.tgq007.seckill.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cloud
 * @since 2021-08-28
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @PostMapping("/getOTP")
    public ResponseData<Boolean> getUserOTP(@Valid @RequestBody TelephoneDTO telephoneDTO) {
        boolean res = userInfoService.getUserOTP(telephoneDTO.getTelephone());
        return ResponseData.success(res);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseData<UserModel> getUser(@PathVariable("userId") Integer userId) throws ExecutionException, InterruptedException {
        UserModel userModel = userInfoService.getUserInfoByUserId(userId);
        return ResponseData.success(userModel);
    }

    @PostMapping("/registerUser")
    public ResponseData<Boolean> registerUser(@Valid @RequestBody UserModel userModel) {
        boolean status = userInfoService.registerUser(userModel);
        return ResponseData.success(status);
    }
}
