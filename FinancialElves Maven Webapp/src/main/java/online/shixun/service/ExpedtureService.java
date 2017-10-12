/**
 * 
 */
package online.shixun.service;

import online.shixun.model.Expenditure;

/**
 * @ClassName: ExpedtureService
 *
 * @Description: 支出账单服务接口类
 *
 * 
 * @author: 芸江
 *
 * @date 2017年10月12日 下午8:27:24
 */
public interface ExpedtureService extends BillService<Expenditure> {

	@Override
	void addBillInfo(Expenditure expenditure, Long account_id);

	@Override
	void deleteBillInfo(Expenditure expenditure);

	@Override
	void updateBillInfo(Expenditure expenditure);

	@Override
	Long fuzzyQueryBillPages(Long account_id, String expenditure_type);

	@Override
	String fuzzyQueryBillInfo(Long account_id, String expenditure_type, Long page);

}
