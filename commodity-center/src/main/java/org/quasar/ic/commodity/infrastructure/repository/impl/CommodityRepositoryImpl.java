package org.quasar.ic.commodity.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.commodity.infrastructure.repository.CommodityRepository;
import org.quasar.ic.commodity.infrastructure.repository.mapper.CommodityMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Optional;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 13:45
 */
@Repository
@RequiredArgsConstructor
public class CommodityRepositoryImpl implements CommodityRepository {
    private final CommodityMapper commodityMapper;

    @Override
    public Optional<CommodityPo> find(Long id) {
        return Optional.ofNullable(commodityMapper.selectById(id));
    }

    @Override
    public Page<CommodityPo> findAll(CommodityQueryOption option) {
        return commodityMapper.selectPage(new Page<>(option.getCurrentPage(), option.getPageSize()), new LambdaQueryWrapper<CommodityPo>()
                .eq(option.getName() != null, CommodityPo::getName, option.getName())
                .in(!CollectionUtils.isEmpty(option.getDeliveryTypes()), CommodityPo::getDeliveryType, option.getDeliveryTypes())
                .in(!CollectionUtils.isEmpty(option.getStatuses()), CommodityPo::getStatus, option.getStatuses())
                .ge(null != option.getStartCreateTime(), CommodityPo::getCreateTime, option.getStartCreateTime())
                .le(null != option.getEndCreateTime(), CommodityPo::getCreateTime, option.getStartCreateTime())
        );
    }

    @Override
    public void save(CommodityPo po) {
        commodityMapper.insert(po);
    }

    @Override
    public void update(CommodityPo po) {
        commodityMapper.updateById(po);
    }

    @Override
    public void updateSelective(CommodityPo po) {
        commodityMapper.update(po, new LambdaUpdateWrapper<CommodityPo>()
                .eq(CommodityPo::getId, po.getId())
                .set(po.getName() != null, CommodityPo::getName, po.getName())
                .set(po.getPrice() != null, CommodityPo::getPrice, po.getPrice())
                .set(po.getDescription() != null, CommodityPo::getDescription, po.getDescription())
                .set(po.getImage() != null, CommodityPo::getImage, po.getImage())
                .set(po.getStock() != null, CommodityPo::getStock, po.getStock())
                .set(CollectionUtils.isEmpty(po.getDeliveryType()), CommodityPo::getDeliveryType, po.getDeliveryType())
                .set(po.getStatus() != null, CommodityPo::getStatus, po.getStatus())
        );
    }

    @Override
    public void delete(Long id) {
        commodityMapper.deleteById(id);
    }
}
