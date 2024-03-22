package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @Author zhuyajie
 * @Date 2024/3/22 16:14
 * @注释
 */
@Slf4j
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法，json数据")
    public String addPay(@RequestBody Pay pay) {
        int add = payService.add(pay);
        log.info("新增pay为{}", pay);
        return "新增数量为" + add;
    }

    @GetMapping("/pay/del/{id}")
    public Integer deletePayById(@PathVariable("id") Integer id) {
        int i = payService.delete(id);
        return i;
    }

    @PostMapping("pay/update")
    public Integer updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        return payService.update(pay);
    }

    @GetMapping("/pay/get/{id}")
    public Pay getPayById(@PathVariable("id") Integer id) {
        return payService.getPayById(id);
    }

    @GetMapping("/pay/getAll")
    public List<Pay> getAll() {
        List<Pay> allPay = payService.getAllPay();
        return allPay;
    }
}
