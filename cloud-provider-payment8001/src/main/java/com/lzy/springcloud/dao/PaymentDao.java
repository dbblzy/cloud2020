package com.lzy.springcloud.dao;

import com.lzy.springcloud.entities.Payment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 23868
 */
@Mapper
public interface PaymentDao {

    public  int create(Payment payment);
    public Payment getPaymentById(@Param("id")Long id);
}
