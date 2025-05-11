package com.demo.fancy.spi.balance.impl;

import com.demo.fancy.annotation.LoadBalanceAno;
import com.demo.fancy.common.constants.RpcConstant;
import com.demo.fancy.common.model.Service;
import com.demo.fancy.spi.balance.LoadBalance;

import java.util.List;
import java.util.Random;

/**
 * 随机算法
 */
@LoadBalanceAno(RpcConstant.BALANCE_RANDOM)
public class RandomBalance implements LoadBalance {

    private static Random random = new Random();

    @Override
    public Service chooseOne(List<Service> services) {
        return services.get(random.nextInt(services.size()));
    }
}
