package org.quasar.ic.commodity.application.converter.impl;

import org.quasar.ic.api.common.CommodityDto;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.common.application.converter.BasePoPageConverter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/26 21:20
 */
@Component
public class CommodityPoPageConverter extends BasePoPageConverter<CommodityPo, CommodityDto> {
    private static final String DATABASE_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    private static final String API_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

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
                .setStatus(pageItem.getStatus())
                .setCreateTime(parseTime(pageItem.getCreateTime()))
                .setUpdateTime(parseTime(pageItem.getUpdateTime()));
    }

    private static String parseTime(String dateTime) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat(DATABASE_DATE_TIME_PATTERN);
            SimpleDateFormat outputFormat = new SimpleDateFormat(API_DATE_TIME_PATTERN);
            return outputFormat.format(inputFormat.parse(dateTime));
        } catch (Exception e) {
            return null;
        }
    }
}
