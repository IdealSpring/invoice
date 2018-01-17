package cn.ccut.invoice.user.dao;

import cn.ccut.invoice.user.model.User;
import cn.ccut.invoice.user.model.UserCustom;

import java.util.List;

/**
 * UserMapper的扩展Mapper
 * @author ASUS-PC
 *
 */
public interface UserMapperCustom extends UserMapper{
	/**
	 * 添加用户
	 * @param userCustom
	 */
    public void addUser(UserCustom userCustom);
    
    /**
     * 通过email查询用户
     * @param email
     * @return
     */
    public User findByEmail(String email);
    
    /**
     * 通过code查询用户
     * @param verifyCode
     * @return
     */
    public User findByCode(String verifyCode);
    
    /**
     * 添加用户
     * @param user
     */
    public void updateState(User user);
    
    /**
     * 通过激活码删除用户
     * @param code
     */
    public void deleteUser(String code);

    List<User> selectAll();
}







