package org.quasar.ic.commodity.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.quasar.ic.api.request.CommodityCreateReqDto;
import org.quasar.ic.api.request.CommodityDeleteReqDto;
import org.quasar.ic.api.request.CommodityQueryReqDto;
import org.quasar.ic.api.request.CommodityUpdateReqDto;
import org.quasar.ic.api.response.CommodityCreateRespDto;
import org.quasar.ic.api.response.CommodityDeleteRespDto;
import org.quasar.ic.api.response.CommodityQueryRespDto;
import org.quasar.ic.api.response.CommodityUpdateRespDto;
import org.quasar.ic.commodity.application.service.ICommodityApplicationService;
import org.springframework.web.bind.annotation.*;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 16:55
 */
@Tag(name = "CommodityManagement", description = "Commodity Center API")
@RequestMapping("/api/v1/commodity-center")
@RestController
@RequiredArgsConstructor
public class CommodityController {
    private final ICommodityApplicationService commodityApplicationService;

    @Operation(summary = "Query Commodity")
    @PostMapping("/commodity/query")
    public CommodityQueryRespDto queryCommodity(@Valid @RequestBody CommodityQueryReqDto reqDto) {
        return commodityApplicationService.queryCommodity(reqDto);
    }

    @Operation(summary = "Create Commodity")
    @PostMapping("/commodity")
    public CommodityCreateRespDto createCommodity(@Valid @RequestBody CommodityCreateReqDto reqDto) {
        return commodityApplicationService.createCommodity(reqDto);
    }

    @Operation(summary = "Update Commodity")
    @PutMapping("/commodity")
    public CommodityUpdateRespDto updateCommodity(@Valid @RequestBody CommodityUpdateReqDto reqDto) {
        return commodityApplicationService.updateCommodity(reqDto);
    }

    @Operation(summary = "Delete Commodity")
    @DeleteMapping("/commodity")
    public CommodityDeleteRespDto deleteCommodity(@Valid @RequestBody CommodityDeleteReqDto reqDto) {
        return commodityApplicationService.deleteCommodity(reqDto);
    }
}
