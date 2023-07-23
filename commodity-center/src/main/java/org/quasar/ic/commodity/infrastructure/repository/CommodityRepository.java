package org.quasar.ic.commodity.infrastructure.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.common.infrastructure.repository.BaseQueryOption;
import org.quasar.ic.common.infrastructure.repository.IRepository;

import java.util.Collection;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 13:02
 */
public interface CommodityRepository extends IRepository<CommodityPo> {
    Page<CommodityPo> findAll(CommodityQueryOption option);

    @EqualsAndHashCode(callSuper = true)
    @Data
    class CommodityQueryOption extends BaseQueryOption {
        public CommodityQueryOption(Integer currentPage, Integer pageSize) {
            super(currentPage, pageSize);
        }

        private String name;
        private Collection<Integer> deliveryTypes;
        private Collection<Integer> statuses;
        private String startCreateTime;
        private String endCreateTime;
    }
}
