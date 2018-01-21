package cn.ccut.invoice.user.controller;

import cn.ccut.invoice.user.model.User;
import cn.ccut.invoice.user.model.UserCustom;
import cn.ccut.invoice.user.service.UserService;
import cn.itcast.vcode.utils.VerifyCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	/**
	 * 向登陆界面发送验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/loginCode")
	public void verifyCode(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//创建验证码类
		VerifyCode verifyCode=new VerifyCode();
		//获取图片
		BufferedImage image = verifyCode.getImage();
		//获取图片内容
		String imageCode = verifyCode.getText();
		//保存验证码
		request.getSession().setAttribute("loginCode", imageCode);
		//相应给客户端
		VerifyCode.output(image, response.getOutputStream());
	}
	
	/**
	 * 登陆功能
	 * @param userCustom
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(UserCustom userCustom, HttpServletRequest request) throws Exception {
		String realVerifyCode = (String) request.getSession().getAttribute("loginCode");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userCustom", userCustom);
		//检查验证码
		if(!realVerifyCode.equalsIgnoreCase(userCustom.getVerifyCode())) {
			modelAndView.addObject("error", "验证码错误");
			modelAndView.setViewName("/jsps/user/login.jsp");
			return modelAndView;
		}
		
		//获取用户
		Subject currentUser = SecurityUtils.getSubject();
		
		if (!currentUser.isAuthenticated()) {
        	/*重点，把用户名密码封装成UsernamePasswordToken对象*/
            UsernamePasswordToken token = new UsernamePasswordToken(userCustom.getEmail(), userCustom.getPassword());
            
            /*RememberMe--通过记住我登陆*/
            token.setRememberMe(userCustom.isRecord());
            try {
            	// 执行登录. 
            	currentUser.login(token);
            } catch(UnknownAccountException ae) {
            	modelAndView.addObject("msg", "登录失败: " + ae.getMessage());
            	modelAndView.setViewName("/jsps/user/login.jsp");
   				return modelAndView;
            } catch(LockedAccountException ae) {
            	modelAndView.addObject("msg", "登录失败: " + ae.getMessage());
            	modelAndView.setViewName("/jsps/user/login.jsp");
   				return modelAndView;
            }
            // 所有认证时异常的父类. 
            catch (AuthenticationException ae) {
            	modelAndView.addObject("msg", "登录失败: 邮箱或者密码错误！");
            	modelAndView.setViewName("/jsps/user/login.jsp");
   				return modelAndView;
            }
        }

        /*保存用户ID到Session域*/
		User user = userService.findByEmail(userCustom.getEmail());
        request.getSession().setAttribute("roleID", user.getUid());
		modelAndView.setViewName("/jsps/index.jsp");
		return modelAndView;
	}
	
	/**
	 * 转发使用，原因是修改项目名也可以使用
	 * @return
	 */
	@RequestMapping("/redirectRegist")
	public String redirectRegist() {
		return "redirect:/jsps/user/regist.jsp";
	}
}







