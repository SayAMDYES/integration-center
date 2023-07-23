package org.quasar.ic.commodity.infrastructure.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.quasar.ic.common.infrastructure.po.BasePo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 13:00
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommodityPo extends BasePo {
    private String name;
    private BigDecimal price;
    private String description;
    private String image;
    private Integer stock;
    private List<Integer> deliveryType;
    private Integer status;
}
