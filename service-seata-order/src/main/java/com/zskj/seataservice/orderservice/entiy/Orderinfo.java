package com.zskj.seataservice.orderservice.entiy;

import java.io.Serializable;
import lombok.Data;

/**
 * orderinfo
 * @author 
 */
@Data
public class Orderinfo implements Serializable {
    private Long id;

    /**
     * 产品id
     */
    private Long productid;

    /**
     * 数量
     */
    private Integer productnum;

    private static final long serialVersionUID = 1L;
}