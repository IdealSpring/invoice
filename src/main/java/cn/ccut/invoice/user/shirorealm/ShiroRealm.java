package cn.ccut.invoice.user.shirorealm;

import cn.ccut.invoice.user.dao.UserMapperCustom;
import cn.ccut.invoice.user.model.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 登陆认证，授权方.
 * 
 * @author ASUS-PC
 * 
 */
public class ShiroRealm extends AuthorizingRealm {
	@Autowired
	private UserMapperCustom uerMapperCustom;

	/**
	 * 登陆认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 1. 把AuthenticationToken 转为UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;

		// 2. 从UsernamePasswordToken 中获取username
		String username = upToken.getUsername();

		// 3. 调用数据库方法，从数据库中查询username 对应的用户记录
		User user = uerMapperCustom.findByEmail(username);

		// 4. 若用户不存在, 则可以抛出 UnknownAccountException 异常
		if (user == null) {
			throw new UnknownAccountException("用户不存在!");
		}

		// 5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
		//用户未激活，则抛出LockedAccountException
		if(!user.getState()) {
			throw new LockedAccountException("用户未激活，请到邮箱激活!");
		}
		
		// 6.
		// 根据用户的请况，来构建AuthenticationInfo对象并返回，通常使用的实现类为：SimpleAuthenticationInfo
		// 以下信息从数据库中获取
		// 1). principal:认证实体，可以是username， 也可以是数据表对应的实体对象.
		Object principal = user;
		// 2). credentials:密码.
		Object credentials = user.getPassword();
		// 3). realmName:当前realm 对象的name. 调用父类的getName方法
		String realmName = getName();

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, realmName);

		return info;
	}

	/**
	 * 搜全授权方法，在进入的页面有角色过滤器时会被shiro回调
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1. 从PrincipalCollection 中来获取登陆用户信息
		User principal = (User)principals.getPrimaryPrincipal();
		String role = principal.getRole();
		System.out.println(role);

		//2. 利用登陆的用户的信息来判断用户的角色或权限(可能查询数据库)
		Set<String> roles = new HashSet<String>();
		if("user".equals(role)) {
			roles.add("user");
		}
		if("admin".equals(role)) {
			roles.add("admin");
		}
		if("super".equals(role)) {
			roles.add("admin");
			roles.add("super");
		}
		  
		//3. 创建SimpleAuthorizationInfo，并设置其roles属性
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		  
		//4. 返回SimpleAuthorizationInfo return info;
		 
		return info;
	}
}
