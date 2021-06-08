package demo.request;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * <p>通用查询请求参数</p>
 * @author 
 * @date 2021-01-04 15:58:07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistributionStatisticsQueryRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 批量查询-idList
	 */
	private List<Long> idList;

	/**
	 * id
	 */
	private Long id;

	/**
	 * 会员ID
	 */
	private String customerId;


	private List<String> customerIds;

	/**
	 * 分销员编号
	 */
	private Long distributionNo;

	/**
	 * 分销员账号
	 */
	private String customerAccount;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 团队人数
	 */
	private Integer teamCount;

	/**
	 * 直接下属数量
	 */
	private Integer oneLevelCount;

	/**
	 * 间接下属数量
	 */
	private Integer twoLevelCount;

	/**
	 * 直接下属销售额
	 */
	private BigDecimal oneLevelSale;

	/**
	 * 间接下属销售额
	 */
	private BigDecimal twoLevelSale;

	/**
	 * 团队销售额
	 */
	private BigDecimal teamSale;

	/**
	 * 直接下属佣金额
	 */
	private BigDecimal oneLevelCommission;

	/**
	 * 间接下属佣金额
	 */
	private BigDecimal twoLevelCommission;

	/**
	 * 团队佣金额
	 */
	private BigDecimal teamCommission;

}