package org.quasar.ic.commodity.infrastructure.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.commodity.infrastructure.query.ICommodityQuery;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 13:02
 */
@Component
public interface CommodityMapper extends BaseMapper<CommodityPo> {
    List<CommodityPo> selectAllByOption(ICommodityQuery.CommodityQueryOption option);
}
