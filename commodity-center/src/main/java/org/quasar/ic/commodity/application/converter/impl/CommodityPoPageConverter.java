package org.quasar.ic.commodity.application.converter.impl;

import org.quasar.ic.api.common.CommodityDto;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.common.application.converter.BasePoPageConverter;
import org.springframework.stereotype.Component;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/26 21:20
 */
@Component
public class CommodityPoPageConverter extends BasePoPageConverter<CommodityPo, CommodityDto> {
    @Override
    protected CommodityDto doConvert(CommodityPo pageItem) {
        return new CommodityDto()
                .setId(pageItem.getId())
                .setName(pageItem.getName())
                .setPrice(pageItem.getPrice())
                .setDescription(pageItem.getDescription())
                .setImage(pageItem.getImage())
                .setStock(pageItem.getStock())
                .setDeliveryType(pageItem.getDeliveryType())
                .setStatus(pageItem.getStatus());
    }
}
