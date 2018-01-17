package cn.ccut.invoice.user.service.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.ccut.invoice.user.dao.UserMapperCustom;
import cn.ccut.invoice.user.model.QueryUserVo;
import cn.ccut.invoice.user.model.User;
import cn.ccut.invoice.user.model.UserCustom;
import cn.ccut.invoice.user.service.UserService;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

/**
 * UserService接口接口的实现类
 * @author ASUS-PC
 *
 */
@Component("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapperCustom uerMapperCustom;
	@Autowired
	private QueryUserVo queryUserVo;
	
	/**
	 * 查询所有用户
	 */
	public QueryUserVo findAllUser() throws Exception {
		List<User> userList = uerMapperCustom.selectAll();
		queryUserVo.setUserList(userList);
		
		return queryUserVo;
	}
	
	/**
	 * 添加用户
	 */
	public void addUser(UserCustom userCustom) throws Exception {
		//查询用户是否存在
		User user = uerMapperCustom.findByEmail(userCustom.getEmail());
		
		//邮箱存在抛异常
		if(user != null) {
			throw new Exception("该邮箱已被注册，不能重复注册！");
		}
		
		//添加用户
		try {
			uerMapperCustom.addUser(userCustom);
		} catch (Exception e) {
			throw new Exception("未知错误，添加失败！");
		}
	}
	
	/**
	 * 发送验证码
	 */
	public void sendEmail(UserCustom userCustom) throws Exception {
		//获取email文件内容
		Properties props = new Properties();
		props.load(this.getClass().getClassLoader().getResourceAsStream("email.properties"));
		
		String host = props.getProperty("host");
		String emailname = props.getProperty("emailname");
		String password = props.getProperty("password");
		String from = props.getProperty("from");
		String to = userCustom.getEmail();
		String subject = props.getProperty("subject");
		String content = props.getProperty("content");
		content = MessageFormat.format(content, userCustom.getCode());
		
		Session session = MailUtils.createSession(host, emailname, password);
		Mail mail = new Mail(from, to, subject, content);
		//发邮件
		MailUtils.send(session, mail);
	}
	
	/**
	 * 验证激活码
	 */
	public void avtive(String verifyCode) throws Exception{
		//通过code查询用户
		User user = uerMapperCustom.findByCode(verifyCode);
		
		if(user == null) throw new Exception("无效验证码！");
		if(user.getState()) throw new Exception("您已经激活！");
		//更新用户状态
		user.setState(true);
		uerMapperCustom.updateState(user);
	}
	
	/**
	 * 删除用户
	 * @throws Exception
	 */
	public void deleteUser(String code) throws Exception{
		uerMapperCustom.deleteUser(code);
	}
}
