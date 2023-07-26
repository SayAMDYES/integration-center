package org.quasar.ic.common.infrastructure.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/23 13:15
 */
@Data
public abstract class BasePo {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String createTime;
    private String updateTime;
}
