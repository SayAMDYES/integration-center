package org.quasar.ic.api;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.quasar.ic.api.common.BasePage;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/22 18:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ICPageReqDto extends BasePage {
}
