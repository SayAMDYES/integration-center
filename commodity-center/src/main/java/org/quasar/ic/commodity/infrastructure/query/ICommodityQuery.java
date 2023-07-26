package org.quasar.ic.commodity.infrastructure.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.common.infrastructure.BaseQueryOption;
import org.quasar.ic.common.infrastructure.query.IQuery;

import java.util.Collection;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/26 20:24
 */
public interface ICommodityQuery extends IQuery<CommodityPo, ICommodityQuery.CommodityQueryOption> {
    @EqualsAndHashCode(callSuper = true)
    @Data
    @Accessors(chain = true)
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
