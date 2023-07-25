package org.quasar.ic.commodity.domain.entity;

import org.quasar.ic.api.request.CommodityCreateReqDto;
import org.quasar.ic.common.domain.factory.IFactory;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/25 23:32
 */
public interface ICommodityFactory extends IFactory<Commodity> {
    Commodity create(CommodityCreateReqDto reqDto);
}
