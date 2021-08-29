package cn.tgq007.seckill.controller;

import cn.tgq007.seckill.dto.TelephoneDTO;
import cn.tgq007.seckill.entity.ResponseData;
import cn.tgq007.seckill.model.UserModel;
import cn.tgq007.seckill.service.UserInfoService;
import cn.tgq007.seckill.utils.OTPUtil;
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
        String otp = OTPUtil.generateOTP(100000, 1000000);
        // 暂时存储于session
        httpServletRequest.setAttribute(telephoneDTO.getTelephone(), otp);
        System.out.println("telephone = " + telephoneDTO.getTelephone() + ", code = " + otp);
        return ResponseData.success(true);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseData<UserModel> getUser(@PathVariable("userId") Integer userId) throws ExecutionException, InterruptedException {
        UserModel userModel = userInfoService.getUserInfoByUserId(userId);
        return ResponseData.success(userModel);
    }

    @PostMapping("/registerUser")
    public  ResponseData<Boolean> registerUser(@Valid @RequestBody UserModel userModel) {
        String code = (String) httpServletRequest.getSession().getAttribute(userModel.getTelphone());
        boolean status = userInfoService.registerUser(userModel, code);
        return ResponseData.success(status);
    }
}
