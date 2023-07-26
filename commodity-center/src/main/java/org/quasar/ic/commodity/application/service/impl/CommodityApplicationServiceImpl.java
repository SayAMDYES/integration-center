package org.quasar.ic.commodity.application.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.quasar.ic.api.common.CommodityDto;
import org.quasar.ic.api.request.CommodityCreateReqDto;
import org.quasar.ic.api.request.CommodityDeleteReqDto;
import org.quasar.ic.api.request.CommodityQueryReqDto;
import org.quasar.ic.api.request.CommodityUpdateReqDto;
import org.quasar.ic.api.response.CommodityCreateRespDto;
import org.quasar.ic.api.response.CommodityDeleteRespDto;
import org.quasar.ic.api.response.CommodityQueryRespDto;
import org.quasar.ic.api.response.CommodityUpdateRespDto;
import org.quasar.ic.commodity.api.converter.CommodityConverter;
import org.quasar.ic.commodity.application.service.ICommodityApplicationService;
import org.quasar.ic.commodity.domain.entity.Commodity;
import org.quasar.ic.commodity.domain.entity.ICommodityFactory;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.commodity.infrastructure.query.ICommodityQuery;
import org.quasar.ic.common.application.converter.BasePoPageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/25 23:47
 */
@Service
@RequiredArgsConstructor
public class CommodityApplicationServiceImpl implements ICommodityApplicationService {
    private final ICommodityQuery commodityQuery;

    private final ICommodityFactory commodityFactory;

    private final CommodityConverter commodityConverter;
    private final BasePoPageConverter<CommodityPo, CommodityDto> pageConverter;

    @Override
    public CommodityQueryRespDto queryCommodity(CommodityQueryReqDto reqDto) {
        Page<CommodityPo> commodityPoPage = commodityQuery.findAll(new ICommodityQuery.CommodityQueryOption(reqDto.getCurrentPage(), reqDto.getPageSize())
                .setName(reqDto.getName())
                .setDeliveryTypes(List.of(reqDto.getDeliveryType()))
                .setStatuses(List.of(reqDto.getStatus()))
                .setStartCreateTime(reqDto.getStartCreateTime())
                .setEndCreateTime(reqDto.getEndCreateTime()));

        return new CommodityQueryRespDto()
                .success(pageConverter.convert(commodityPoPage));
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
