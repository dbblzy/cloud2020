package com.lzy.springcloud.service;

import com.lzy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 23868
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id );
}
