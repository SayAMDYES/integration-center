package org.quasar.ic.commodity.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.quasar.ic.api.request.CommodityCreateReqDto;
import org.quasar.ic.api.request.CommodityDeleteReqDto;
import org.quasar.ic.api.request.CommodityQueryReqDto;
import org.quasar.ic.api.request.CommodityUpdateReqDto;
import org.quasar.ic.api.response.CommodityCreateRespDto;
import org.quasar.ic.api.response.CommodityDeleteRespDto;
import org.quasar.ic.api.response.CommodityQueryRespDto;
import org.quasar.ic.api.response.CommodityUpdateRespDto;
import org.quasar.ic.commodity.api.converter.CommodityConverter;
import org.quasar.ic.commodity.application.service.CommodityService;
import org.quasar.ic.commodity.domain.entity.Commodity;
import org.quasar.ic.commodity.domain.entity.ICommodityFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/25 23:47
 */
@Service
@RequiredArgsConstructor
public class CommodityServiceImpl implements CommodityService {
    private final ICommodityFactory commodityFactory;

    private final CommodityConverter commodityConverter;

    @Override
    public CommodityQueryRespDto queryCommodity(CommodityQueryReqDto reqDto) {
        return null;
    }

    @Override
    public CommodityCreateRespDto createCommodity(CommodityCreateReqDto reqDto) {
        Commodity commodity = commodityFactory.create(reqDto);
        return new CommodityCreateRespDto()
                .success(commodityConverter.convert(commodity));
    }

    @Override
    public CommodityUpdateRespDto updateCommodity(CommodityUpdateReqDto reqDto) {
        Commodity commodity = commodityFactory.create(reqDto.getId());
        commodity.setName(reqDto.getName());
        commodity.setPrice(reqDto.getPrice());
        commodity.setDescription(reqDto.getDescription());
        commodity.setImage(reqDto.getImage());
        commodity.setStock(reqDto.getStock());
        commodity.removeAllDeliveryType();
        if (!CollectionUtils.isEmpty(reqDto.getDeliveryType())) {
            commodity.removeAllDeliveryType();
            reqDto.getDeliveryType().forEach(commodity::addDeliveryType);
        }
        commodity.setStatus(reqDto.getStatus());
        commodity.save();
        return new CommodityUpdateRespDto()
                .success(commodityConverter.convert(commodity));
    }

    @Override
    public CommodityDeleteRespDto deleteCommodity(CommodityDeleteReqDto reqDto) {
        Commodity commodity = commodityFactory.create(reqDto.getId());
        commodity.delete();
        return new CommodityDeleteRespDto().success("delete success");
    }
}
