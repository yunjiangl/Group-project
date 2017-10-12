package online.shixun.service;

import online.shixun.model.Income;

/**
 * @ClassName: IncomeService
 *
 * @Description: 账单服务接口类
 *
 * 
 * @author: 芸江
 *
 * @date 2017年10月12日 下午8:21:20
 */
public interface IncomeService extends BillService<Income> {

	@Override
	void addBillInfo(Income income, Long account_id);

	@Override
	void deleteBillInfo(Income income);

	@Override
	void updateBillInfo(Income income);

	@Override
	Long fuzzyQueryBillPages(Long account_id, String income_type);

	@Override
	String fuzzyQueryBillInfo(Long account_id, String income_type, Long page);

}
