package online.shixun.action;

/**
 * @ClassName: AccountAction
 *
 * @Description: 账户Action接口类
 *
 * @author: 芸江
 *
 * @date 2017年10月10日 下午5:38:40
 */
public interface AccountAction {

	/**
	 * 用户登录
	 * 
	 * <p>
	 * 使用response对象向前端发送登陆结果，"login"字符串代表成功登录（此时将用户信息加入session）
	 * <p>
	 * "cant'login"表示用户已经被锁定
	 * </p>
	 * <p>
	 * "noLogin"表示用户输入的账户或密码错误
	 * </p>
	 * </p>
	 */
	void doLogin();

	/**
	 * 检查用户名是否重复
	 * 
	 * 
	 * <p>
	 * 使用response对象向前端发送用户名是否重复结果，"yes"表示重复，"no"表示没有重复
	 * </p>
	 */
	void usernameIsRepeat();

	/**
	 * 用户注册
	 * 
	 * <p>
	 * 使用response对象向前端发送注册结果，"success"表示注册成功，"failure"表示注册失败
	 * </p>
	 */
	void doRegistered();

}
