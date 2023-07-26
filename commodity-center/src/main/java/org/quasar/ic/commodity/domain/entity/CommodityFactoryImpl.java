package org.quasar.ic.commodity.domain.entity;

import lombok.RequiredArgsConstructor;
import org.quasar.ic.api.request.CommodityCreateReqDto;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.commodity.infrastructure.query.ICommodityQuery;
import org.quasar.ic.commodity.infrastructure.repository.ICommodityRepository;
import org.quasar.ic.common.exception.ICException;
import org.quasar.ic.common.exception.ICExceptionEnum;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/25 22:37
 */
@Component
@RequiredArgsConstructor
public class CommodityFactoryImpl implements ICommodityFactory {
    private final ICommodityQuery commodityQuery;

    private final ICommodityRepository commodityRepository;

    @Override
    public Commodity create(Long id) {
        Optional<CommodityPo> commodityPo = commodityQuery.find(id);
        if (commodityPo.isEmpty()) {
            throw new ICException(ICExceptionEnum.NOT_FOUND, "Commodity not found");
        }

        Commodity commodity = new Commodity(commodityRepository, id)
                .setName(commodityPo.get().getName())
                .setPrice(commodityPo.get().getPrice())
                .setDescription(commodityPo.get().getDescription())
                .setImage(commodityPo.get().getImage())
                .setStock(commodityPo.get().getStock())
                .setStatus(commodityPo.get().getStatus());
        commodityPo.get().getDeliveryType().forEach(commodity::addDeliveryType);
        return commodity;
    }

    @Override
    public Commodity create(CommodityCreateReqDto reqDto) {
        Commodity commodity = new Commodity(commodityRepository, null)
                .setName(reqDto.getName())
                .setPrice(reqDto.getPrice())
                .setDescription(reqDto.getDescription())
                .setImage(reqDto.getImage())
                .setStock(reqDto.getStock())
                .setStatus(reqDto.getStatus());
        reqDto.getDeliveryType().forEach(commodity::addDeliveryType);

        commodityRepository.save(commodity.toPo());

        return commodity;
    }
}
