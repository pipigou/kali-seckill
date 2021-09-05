package cn.tgq007.seckill.model;

public class LoginInfo {

    private boolean isLogin;
    private UserModel userModel;

    public LoginInfo() {
    }

    public LoginInfo(boolean isLogin, UserModel userModel) {
        this.isLogin = isLogin;
        this.userModel = userModel;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
