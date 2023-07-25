package org.quasar.ic.api.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.quasar.ic.api.ICResponse;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 18:12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommodityDeleteRespDto extends ICResponse<Void, CommodityDeleteRespDto> {
}
