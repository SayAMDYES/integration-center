package org.quasar.ic.commodity.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.quasar.ic.api.request.CommodityCreateReqDto;
import org.quasar.ic.api.request.CommodityDeleteReqDto;
import org.quasar.ic.api.request.CommodityQueryReqDto;
import org.quasar.ic.api.request.CommodityUpdateReqDto;
import org.quasar.ic.api.response.CommodityCreateRespDto;
import org.quasar.ic.api.response.CommodityDeleteRespDto;
import org.quasar.ic.api.response.CommodityQueryRespDto;
import org.quasar.ic.api.response.CommodityUpdateRespDto;
import org.quasar.ic.commodity.application.service.CommodityService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 16:55
 */
@Tag(name = "Commodity API")
@RestController
@RequiredArgsConstructor
public class CommodityController {
    private final CommodityService commodityService;

    @Operation(summary = "Query Commodity")
    @PostMapping("/commodity/query")
    public CommodityQueryRespDto queryCommodity(@RequestBody CommodityQueryReqDto reqDto) {
        return commodityService.queryCommodity(reqDto);
    }

    @Operation(summary = "Create Commodity")
    @PostMapping("/commodity")
    public CommodityCreateRespDto createCommodity(@RequestBody CommodityCreateReqDto reqDto) {
        return commodityService.createCommodity(reqDto);
    }

    @Operation(summary = "Update Commodity")
    @PutMapping("/commodity")
    public CommodityUpdateRespDto updateCommodity(@RequestBody CommodityUpdateReqDto reqDto) {
        return commodityService.updateCommodity(reqDto);
    }

    @Operation(summary = "Delete Commodity")
    @DeleteMapping("/commodity")
    public CommodityDeleteRespDto deleteCommodity(@RequestBody CommodityDeleteReqDto reqDto) {
        return commodityService.deleteCommodity(reqDto);
    }
}
