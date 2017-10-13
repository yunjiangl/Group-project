package online.shixun.service;

import online.shixun.model.Bill;

/**
 * @ClassName: BillService
 *
 * @Description: 账单服务接口类
 *
 * @author: 芸江
 *
 * @date 2017年10月12日 下午9:08:15
 */
public interface BillService {

	/**
	 * 新增一条支出账单信息
	 * 
	 * @param bill
	 *            账单实体类对象
	 * 
	 *            <p>
	 *            在此方法中，将账单实体类对象的创建、修改时间设置为当前时间，是否删除标记设置为false
	 *            </p>
	 * 
	 * @param account_id
	 *            与该账单关联的用户id
	 */
	void addBillInfo(Bill bill, Long account_id);

	/**
	 * 删除一条支出账单信息
	 * 
	 * @param bill
	 *            将要删除的账单实体类对象
	 *            <p>
	 *            在此方法中，将账单的修改时间设置为当前时间，是否删除标记设置为true
	 *            </p>
	 */
	void deleteBillInfo(Bill bill);

	/**
	 * 更新一条支出账单信息
	 * 
	 * @param bill
	 *            已经更新相关信息的账单实体类对象
	 *            <p>
	 *            在此方法中，将账单的修改时间设置为当前时间
	 *            </p>
	 */
	void updateBillInfo(Bill bill);

	/**
	 * 查询分页之后的账单的总页数（每页10条数据)
	 * 
	 * <strong> 查询的是当前登录用户的收入账单信息 </strong>
	 * 
	 * @param account_id
	 *            当前登陆用户的id
	 * @return 账单数据的总页数
	 */
	Long queryBillPages(Long account_id);

	/**
	 * 查询某页收入账单信息
	 * 
	 * @param account_id
	 *            与账单关联用户id
	 * @param page
	 *            所要查询的页码
	 * @return 查询到的一页账单数据的json格式的字符串数据
	 *         <p>
	 *         <strong>Gson gson = new
	 *         GsonBuilder().setDateFormat("yyyy-MM-dd").create();
	 *         gson.toJson(list);可将list集合转化为json格式的字符串</strong>
	 *         </p>
	 */
	String queryBillInfo(Long account_id, Long page);

	/**
	 * 模糊查询的账单总页数
	 * 
	 * <p>
	 * 以账单的消费（收入）类型类型，模糊查询当前登陆账户的某种消费（收入）类型的账单的总页数
	 * </p>
	 * 
	 * @param account_id
	 *            当前登陆账户的id
	 * 
	 * @param bill_pay_type
	 *            所要模糊查询的条件（账单的消费（收入）类型）
	 * @return 查询到的总页数
	 */
	Long fuzzyQueryBillPages(Long account_id, String bill_pay_type);

	/**
	 * 查询模糊查询账单的消费（收入）类型结果的某页数据
	 * 
	 * @param account_id
	 *            当前登陆账户的id
	 * @param bill_pay_type
	 *            所要模糊查询的条件（账单的消费（收入）类型）
	 * @param page
	 *            所要查询的的页码
	 * @return 所查询到的当页数据的json格式字符串
	 */
	String fuzzyQueryBillInfo(Long account_id, String bill_pay_type, Long page);

	/**
	 * 查询账单金额
	 * 
	 * <p>
	 * 以账单创建时间分组查询账单金额总数
	 * </p>
	 * 
	 * @param account_id
	 *            当前登录用户id
	 * @return 查询到的数据的json格式字符串
	 */
	String queryBillMoney(Long account_id);

	/**
	 * 查询账单创建时间
	 * 
	 * @param account_id
	 *            当前登录用户id
	 * @return 查询到的数据的json格式字符串
	 */
	String queryBillCreateDate(Long account_id);

}
