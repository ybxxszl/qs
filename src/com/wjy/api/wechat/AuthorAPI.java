package com.wjy.api.wechat;

import javax.transaction.SystemException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.wjy.bean.RegisterWXAuthorBean;
import com.wjy.dao.wechat.AuthorDao;
import com.wjy.exception.business.BusinessException;
import com.wjy.jedis.RedisUtil;
import com.wjy.response.ResponseBuilder;
import com.wjy.send.mail.VerifyCode;
import com.wjy.vo.wx.UserInfo;

import cn.binarywang.wx.miniapp.util.crypt.WxMaCryptUtils;

@Path(value = "/wechat/author")
@Produces(value = "application/json;charset=utf-8")
public class AuthorAPI {

	private static final Logger LOGGER = Logger.getLogger(AuthorAPI.class);

	private AuthorDao authorDao = new AuthorDao();

	@GET
	@Path(value = "/loginAuthor")
	public Response loginAuthor(@QueryParam(value = "code") String code) throws Exception {

		LOGGER.info("code: " + code);

		return ResponseBuilder.success(authorDao.loginAuthor(code));

	}

	@GET
	@Path(value = "/sendVerifyCode")
	public Response sendVerifyCode(@QueryParam(value = "wxAuthorEmail") String wxAuthorEmail) throws Exception {

		LOGGER.info("wxAuthorEmail: " + wxAuthorEmail);

		VerifyCode verifyCode = new VerifyCode();

		if (authorDao.verifyEmail(wxAuthorEmail)) {
			if (verifyCode.send(wxAuthorEmail).getInteger("code") != 200) {
				throw new SystemException("验证码发送失败");
			}
		} else {
			throw new BusinessException("该邮箱已注册");
		}

		return ResponseBuilder.success("验证码发送成功");

	}

	@POST
	@Path(value = "/registerAuthor")
	public Response registerAuthor(RegisterWXAuthorBean registerWXAuthorBean) throws Exception {

		LOGGER.info("RegisterWXAuthorBean: " + registerWXAuthorBean);

		String VerifyCode = RedisUtil.get("verifycode:" + registerWXAuthorBean.getWxAuthorEmail());

		if (!VerifyCode.equals(registerWXAuthorBean.getVerifyCode())) {
			throw new BusinessException("验证码错误，请重新输入");
		}

		String text = WxMaCryptUtils.decrypt(registerWXAuthorBean.getSessionKey(),
				registerWXAuthorBean.getEncryptedData(), registerWXAuthorBean.getIv());

		UserInfo userInfo = JSONObject.parseObject(text, UserInfo.class);

		LOGGER.info("UserInfo:" + userInfo);

		return ResponseBuilder.success(authorDao.registerAuthor(registerWXAuthorBean.getWxAuthorEmail(), userInfo));

	}

}
