package com.lzy.springcloud.service;

import com.lzy.springcloud.dao.PaymentDao;
import com.lzy.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 23868
 */
@Service
public class PaymentServiceIMpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    public Payment getPaymentById (long id){
        return paymentDao.getPaymentById(id);
    }

}
