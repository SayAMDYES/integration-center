package org.quasar.ic.commodity.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.quasar.ic.commodity.infrastructure.po.CommodityPo;
import org.quasar.ic.commodity.infrastructure.repository.CommodityRepository;
import org.quasar.ic.common.domain.constant.IEnum;
import org.quasar.ic.common.domain.entity.IEntity;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/25 22:18
 */
@Accessors(chain = true)
public class Commodity extends IEntity {
    public Commodity(CommodityRepository commodityRepository, Long id) {
        this.commodityRepository = commodityRepository;
        this.id = id;
    }

    private final CommodityRepository commodityRepository;
    @Getter
    private final Long id;
    @Getter
    private String name;
    @Getter
    private BigDecimal price;
    @Getter
    @Setter
    private String description;
    @Getter
    @Setter
    private String image;
    @Getter
    private Integer stock;
    private final Set<CommodityDeliveryType> deliveryType = new HashSet<>();
    private CommodityStatus status;

    public void save() {
        commodityRepository.update(this.toPo());
    }

    public void delete() {
        commodityRepository.delete(this.id);
    }

    public Commodity setName(String name) {
        if (!StringUtils.hasText(name)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.name = name;
        return this;
    }

    public Commodity setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be greater than or equal to 0");
        }
        this.price = price;
        return this;
    }

    public Commodity setStock(Integer stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("Stock must be greater than or equal to 0");
        }
        this.stock = stock;
        return this;
    }

    public List<CommodityDeliveryType> getDeliveryType() {
        return new ArrayList<>(deliveryType);
    }

    public Commodity addDeliveryType(Integer deliveryType) {
        CommodityDeliveryType commodityDeliveryTypeEnum = CommodityDeliveryType.find(deliveryType);
        if (CommodityDeliveryType.UNKNOWN == commodityDeliveryTypeEnum) {
            throw new IllegalArgumentException("Unknown delivery type " + deliveryType);
        }
        this.deliveryType.add(commodityDeliveryTypeEnum);
        return this;
    }

    public Commodity removeDeliveryType(Integer deliveryType) {
        CommodityDeliveryType commodityDeliveryTypeEnum = CommodityDeliveryType.find(deliveryType);
        if (CommodityDeliveryType.UNKNOWN == commodityDeliveryTypeEnum) {
            throw new IllegalArgumentException("Unknown delivery type " + deliveryType);
        }
        this.deliveryType.remove(commodityDeliveryTypeEnum);
        return this;
    }

    public CommodityStatus getStatus() {
        return status;
    }

    public Commodity setStatus(Integer status) {
        CommodityStatus statusEnum = CommodityStatus.find(status);
        if (CommodityStatus.UNKNOWN == statusEnum) {
            throw new IllegalArgumentException("Unknown status " + status);
        }
        this.status = statusEnum;
        return this;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected CommodityPo toPo() {
        CommodityPo po = new CommodityPo();
        po.setId(this.id);
        po.setName(this.name);
        po.setPrice(this.price);
        po.setDescription(this.description);
        po.setImage(this.image);
        po.setStock(this.stock);
        po.setDeliveryType(this.deliveryType.stream().map(CommodityDeliveryType::value).toList());
        po.setStatus(this.status.value());
        return po;
    }

    public enum CommodityStatus implements IEnum<CommodityStatus> {
        UNKNOWN(-1),
        IN_STOCK(0),
        ON_SALE(1),
        OUT_OF_STOCK(2),
        DISCONTINUED(3),
        ;

        CommodityStatus(Integer value) {
            this.value = value;
        }

        private final int value;

        @Override
        public int value() {
            return value;
        }

        public static CommodityStatus find(Integer value) {
            if (null == value) {
                return UNKNOWN;
            }
            for (CommodityStatus status : CommodityStatus.values()) {
                if (status.value == value) {
                    return status;
                }
            }
            return UNKNOWN;
        }

        public static boolean contains(Integer value) {
            return find(value) != UNKNOWN;
        }

        @Override
        public String toString() {
            return this.name();
        }
    }

    public enum CommodityDeliveryType implements IEnum<CommodityDeliveryType> {
        UNKNOWN(-1),
        EXPRESS(1),
        CITY_DELIVERY(2),
        ;

        CommodityDeliveryType(Integer value) {
            this.value = value;
        }

        private final int value;

        @Override
        public int value() {
            return value;
        }

        public static CommodityDeliveryType find(Integer value) {
            if (null == value) {
                return UNKNOWN;
            }
            for (CommodityDeliveryType type : CommodityDeliveryType.values()) {
                if (type.value == value) {
                    return type;
                }
            }
            return UNKNOWN;
        }

        public static boolean contains(Integer value) {
            return find(value) != UNKNOWN;
        }

        @Override
        public String toString() {
            return this.name();
        }
    }
}
