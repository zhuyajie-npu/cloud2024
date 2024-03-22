package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * @version 1.0
 * @Author zhuyajie
 * @Date 2024/3/22 16:09
 * @注释
 */

public interface PayService {

    int add(Pay pay);

    int delete(Integer id);

    int update(Pay pay);

    Pay getPayById(Integer id);

    List<Pay> getAllPay();
}
