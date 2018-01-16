package cn.ccut.invoice.user.model;

/**
 * 用户类的扩展类
 * @author ASUS-PC
 *
 */
public class UserCustom extends User {
	//验证码
	private String verifyCode;
	
	//是否记住密码
	private boolean record;

	public boolean isRecord() {
		return record;
	}

	public void setRecord(boolean record) {
		this.record = record;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
}
