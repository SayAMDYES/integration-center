package org.quasar.ic.commodity.application.service;

import org.quasar.ic.api.request.CommodityCreateReqDto;
import org.quasar.ic.api.request.CommodityDeleteReqDto;
import org.quasar.ic.api.request.CommodityQueryReqDto;
import org.quasar.ic.api.request.CommodityUpdateReqDto;
import org.quasar.ic.api.response.CommodityCreateRespDto;
import org.quasar.ic.api.response.CommodityDeleteRespDto;
import org.quasar.ic.api.response.CommodityQueryRespDto;
import org.quasar.ic.api.response.CommodityUpdateRespDto;
import org.quasar.ic.common.application.service.IApplicationService;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/25 23:45
 */
public interface ICommodityApplicationService extends IApplicationService {
    CommodityQueryRespDto queryCommodity(CommodityQueryReqDto reqDto);

    CommodityCreateRespDto createCommodity(CommodityCreateReqDto reqDto);

    CommodityUpdateRespDto updateCommodity(CommodityUpdateReqDto reqDto);

    CommodityDeleteRespDto deleteCommodity(CommodityDeleteReqDto reqDto);
}
