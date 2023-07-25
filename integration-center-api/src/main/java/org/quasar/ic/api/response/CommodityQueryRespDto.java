package org.quasar.ic.api.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.quasar.ic.api.ICResponse;
import org.quasar.ic.api.common.CommodityDto;
import org.quasar.ic.api.common.PageResult;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 19:41
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommodityQueryRespDto extends ICResponse<PageResult<CommodityDto>, CommodityQueryRespDto> {
}
