package cn.ccut.invoice.user.service;

import cn.ccut.invoice.user.model.QueryUserVo;
import cn.ccut.invoice.user.model.UserCustom;

/**
 * User的业务逻辑层接口
 * @author ASUS-PC
 *
 */
public interface UserService {
	/**
	 * 添加用户
	 * @param userCustom
	 * @throws Exception
	 */
	public abstract void addUser(UserCustom userCustom) throws Exception;
	
	/**
	 * 查询所有用户
	 * @return 
	 * @throws Exception
	 */
	public abstract QueryUserVo findAllUser() throws Exception;
	
	/**
	 * 发送验证码
	 * @param to
	 * @throws Exception
	 */
	public abstract void sendEmail(UserCustom userCustom) throws Exception;
	
	/**
	 * 验证激活码
	 * @param verifyCode
	 */
	public abstract void avtive(String verifyCode) throws Exception;
	
	/**
	 * 通过验证码删除用户
	 * @param code
	 * @throws Exception
	 */
	public void deleteUser(String code) throws Exception;
}
