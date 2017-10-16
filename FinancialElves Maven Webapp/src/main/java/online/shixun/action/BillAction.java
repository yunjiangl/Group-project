package online.shixun.action;

/**
 * @ClassName: IncomeAction
 *
 * @Description: 账单Action接口类
 *
 * @author: 芸江
 *
 * @date 2017年10月12日 下午8:31:45
 */
public interface BillAction {

	/**
	 * 新增一条用户账单
	 */
	void addAccountBillInfo();

	/**
	 * 删除一条账单信息
	 */
	void deleteAccountBillInfo();

	/**
	 * 更新一条账单信息
	 */
	void updateAccountBillInfo();

	/**
	 * 查询用户关联的账单分页之后的页数
	 * 
	 * <p>
	 * 使用response对象向前端页面发送查询到的结果
	 * </p>
	 */
	void queryAccountBillPages();

	/**
	 * 查询用户关联的某页的账单数据
	 * 
	 * <p>
	 * 根据前端提供的所要查询的页码进行查询，返回查询的结果（使用response对象）
	 * </p>
	 */
	void queryAccountBillInfo();

	/**
	 * 模糊查询的总页数
	 * 
	 * <p>
	 * 接收前端提供的账单类型，返回查询的总页数（使用response对象）
	 * </p>
	 */
	void fuzzyQueryBillPages();

	/**
	 * 模糊查询某页账单数据
	 * 
	 * <p>
	 * 根据前端提供的所要查询的页码进行查询，返回查询的结果（使用response对象）
	 * </p>
	 */
	void fuzzyQueryBillInfo();

	/**
	 * 查询账单的创建时间
	 * 
	 * <p>
	 * 使用response返回结果
	 * </p>
	 */
	void queryBillCreateDate();

	/**
	 * 查询账单的金额
	 * 
	 * <p>
	 * 以账单创建时间分组查询账单金额，使用response返回结果
	 * </p>
	 */
	void queryBillMoney();

	/**
	 * 查询账单的金额
	 * 
	 * <p>
	 * 以支出和收入分组查询账单金额，使用response返回结果
	 * </p>
	 */
	void queryBillAllMoney();

}
