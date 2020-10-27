package com.jerry.bookcloud.account.service.impl;

import com.jerry.bookcloud.account.bo.UserBO;
import com.jerry.bookcloud.account.common.utils.JwtUtil;
import com.jerry.bookcloud.account.common.utils.UserUtil;
import com.jerry.bookcloud.account.dao.UserMapper;
import com.jerry.bookcloud.account.service.UserService;
import com.jerry.bookcloud.account.vo.AuthVO;
import com.jerry.bookcloud.account.vo.UserVO;
import com.jerry.bookcloud.common.pojo.account.User;
import com.jerry.bookcloud.common.result.Result;
import com.jerry.bookcloud.common.result.ResultUtil;
import com.jerry.bookcloud.common.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

import static com.jerry.bookcloud.common.constant.JwtConstant.EXPIRE_DAY;

@Service
public class UserServiceImpl implements UserService {


    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;


    /**
     * 注册账户
     *
     * @param userBO
     * @return
     */
    @Override
    public Result register(UserBO userBO) {
        User dbUser = userMapper.selectByLoginName(userBO.getLoginName());
        if (dbUser != null) {
            return ResultUtil.verificationFailed().buildMessage(userBO.getLoginName() + "已存在，请使用其它登录名进行注册！");
        }

        User user = new User();
        BeanUtils.copyProperties(userBO, user);
        String encryptPwd = UserUtil.getUserEncryptPassword(userBO.getLoginName(), userBO.getUserPwd());
        user.setUserPwd(encryptPwd);
        try {
            // 设置默认头像
            user.setHeadImgUrl("http://reading.zealon.cn/default.jpg");
            user.setUuid(CommonUtil.getUUID());
            this.userMapper.insert(user);
        } catch (Exception ex) {
            logger.error("注册用户失败了！{}; user:{}", ex, user);
            return ResultUtil.fail().buildMessage("注册失败，服务器被吃了! ＝(#>д<)ﾉ");
        }
        return ResultUtil.success().buildMessage("注册成功！请登录吧");

    }

    /**
     * 登录
     *
     * @param loginName
     * @param password
     * @return
     */
    @Override
    public Result<AuthVO> login(String loginName, String password) {
        try {
            User user = userMapper.selectByLoginName(loginName);
            if (user == null) {
                return ResultUtil.notFound().buildMessage("登录失败,用户不存在");
            }
            //检验用户名和密码
            String encrytPwd = UserUtil.getUserEncryptPassword(loginName, password);
            if (!user.getUserPwd().equalsIgnoreCase(encrytPwd)) {
                return ResultUtil.verificationFailed().buildMessage("登录失败,密码错误");
            }

            //登录成功
            AuthVO authVo = new AuthVO();
            UserVO userVo = new UserVO();
            BeanUtils.copyProperties(user, userVo);
            authVo.setToken(JwtUtil.buildJwt(this.getLoginExpre(), userVo));
            authVo.setUser(userVo);
            return ResultUtil.success(authVo);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("登录失败了！{}; loginName:{}", ex, loginName);
            return ResultUtil.fail().buildMessage("登录失败，服务器被吃了＝(#>д<)ﾉ ！请重试。 ");
        }
    }

    /**
     * 退出登录
     *
     * @param loginName
     * @return
     */
    @Override
    public Result logout(String loginName) {
        return null;
    }

    /**
     * 修改账户
     *
     * @param userBO
     * @return
     */
    @Override
    public Result update(UserBO userBO) {
        return null;
    }

    /**
     * 修改密码
     *
     * @param userBO
     * @return
     */
    @Override
    public Result updatePassword(UserBO userBO) {
        return null;
    }

    /**
     * 获取登陆过期时间
     *
     * @return
     */
    private Date getLoginExpre() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, EXPIRE_DAY);
        return calendar.getTime();
    }
}
