package org.quasar.ic.commodity.api.converter;

import org.quasar.ic.api.common.CommodityDto;
import org.quasar.ic.commodity.domain.entity.Commodity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 17:18
 */
@Component
public class CommodityConverter implements Converter<Commodity, CommodityDto> {
    @Override
    public CommodityDto convert(Commodity commodity) {
        CommodityDto commodityDto = new CommodityDto();
        commodityDto.setId(commodity.getId());
        commodityDto.setName(commodity.getName());
        commodityDto.setPrice(commodity.getPrice());
        commodityDto.setDescription(commodity.getDescription());
        commodityDto.setImage(commodity.getImage());
        commodityDto.setStock(commodity.getStock());
        commodityDto.setDeliveryType(commodity.getDeliveryType().stream().map(Commodity.CommodityDeliveryType::value).toList());
        commodityDto.setStatus(commodity.getStatus().value());
        return commodityDto;
    }
}
