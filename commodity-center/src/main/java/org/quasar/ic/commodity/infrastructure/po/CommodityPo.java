package org.quasar.ic.commodity.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.JdbcType;
import org.quasar.ic.common.infrastructure.po.BasePo;
import org.quasar.ic.common.infrastructure.po.extension.ListOfIntegerTypeHandler;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 13:00
 */
@TableName(value = "t_commodity", autoResultMap = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class CommodityPo extends BasePo {
    private String name;
    private BigDecimal price;
    private String description;
    private String image;
    private Integer stock;
    @TableField(value = "delivery_type", jdbcType = JdbcType.ARRAY, typeHandler = ListOfIntegerTypeHandler.class)
    private List<Integer> deliveryType;
    private Integer status;
}
