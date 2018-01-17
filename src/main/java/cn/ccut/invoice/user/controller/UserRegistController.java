package cn.ccut.invoice.user.controller;

import cn.ccut.invoice.user.model.UserCustom;
import cn.ccut.invoice.user.service.UserService;
import cn.itcast.commons.CommonUtils;
import cn.itcast.vcode.utils.VerifyCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * User数据的数据表现层
 * @author ASUS-PC
 *
 */
@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	/**
	 * 用户注册
	 * @param userCustom
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping("/regist")
	public ModelAndView regist(UserCustom userCustom, HttpServletRequest request) throws Exception {
		String verifyCode = userCustom.getVerifyCode();
		String realVerifyCode = (String) request.getSession().getAttribute("imageCode");
		
		ModelAndView modelAndView = new ModelAndView();
		//数据回显
		modelAndView.addObject("userCustom", userCustom);
		//不相等，打回注册界面
		if(!realVerifyCode.equalsIgnoreCase(verifyCode)) {
			modelAndView.addObject("error", "验证码错误");
			modelAndView.setViewName("/jsps/user/regist.jsp");
			return modelAndView;
		}
		//补全激活码信息
		userCustom.setCode(CommonUtils.uuid());
		
		//向数据库里存数据
		try {
			userService.addUser(userCustom);
			modelAndView.addObject("msg", "注册成功，请到邮箱去激活！");
		} catch (Exception e) {
			modelAndView.addObject("msg", e.getMessage());
			modelAndView.setViewName("/jsps/user/regist.jsp");
			return modelAndView;
		}
		
		//发激活码
		try {
			userService.sendEmail(userCustom);
		} catch (Exception e) {
			modelAndView.addObject("msg", "未知错误，激活码发送失败！");
			modelAndView.setViewName("/jsps/user/regist.jsp");
			return modelAndView;
		}
		
		modelAndView.setViewName("/jsps/user/regist.jsp");
		return modelAndView;
	}
	
	/**
	 * 向注册界面发送验证码
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/verifyCode")
	public void verifyCode(HttpServletRequest request,HttpServletResponse response) throws Exception {
		//创建验证码类
		VerifyCode verifyCode=new VerifyCode();
		//获取图片
		BufferedImage image = verifyCode.getImage();
		//获取图片内容
		String imageCode = verifyCode.getText();
		//保存验证码
		request.getSession().setAttribute("imageCode", imageCode);
		//相应给客户端
		VerifyCode.output(image, response.getOutputStream());
	}
	
	@RequestMapping("/active")
	public ModelAndView active(HttpServletRequest request) throws Exception {
		//获取验证码
		String code = request.getParameter("code");
		
		ModelAndView modelAndView = new ModelAndView();
		//激活
		try {
			userService.avtive(code);
			modelAndView.addObject("msg", "恭喜，激活成功!");
			modelAndView.setViewName("/jsps/user/registsuccess.jsp");
		} catch (Exception e) {
			modelAndView.addObject("msg", e.getMessage());
			userService.deleteUser(code);
			modelAndView.setViewName("/jsps/user/regist.jsp");
		}
		
		return modelAndView;
	}
	
	/**
	 * 转发使用，原因是修改项目名也可以使用
	 * @return
	 */
	@RequestMapping("/redirectLogin")
	public String redirectRegist() {
		return "redirect:/jsps/user/login.jsp";
	}
}





