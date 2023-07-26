package org.quasar.ic.commodity.infrastructure.query.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.commodity.infrastructure.query.ICommodityQuery;
import org.quasar.ic.commodity.infrastructure.repository.mapper.CommodityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/26 20:34
 */
@Repository
@RequiredArgsConstructor
public class CommodityQueryImpl implements ICommodityQuery {
    private final CommodityMapper commodityMapper;

    @Override
    public Optional<CommodityPo> find(Long id) {
        return Optional.ofNullable(commodityMapper.selectById(id));
    }

    @Override
    public Page<CommodityPo> findAll(CommodityQueryOption option) {
        List<CommodityPo> commodityPos = commodityMapper.selectAllByOption(option);
        return new Page<CommodityPo>(option.getCurrentPage(), option.getPageSize(), commodityPos.size(), true)
                .setRecords(commodityPos);
    }
}
