package com.zskj.serviceprovider.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zskj.serviceprovider.service.SchooleService;
import org.springframework.stereotype.Service;

@Service("SchooleService")
public class SchooleServiceImpl implements SchooleService {

    //给服务接口提供sentinel的服务降级、限流、熔断等功能
    @SentinelResource(value = "SchooleService#getSchooleDesc", defaultFallback = "getSchooleDescFallback")
    public String getSchooleDesc() {
        return "zhongxin xiaoxue desc";
    }

    public String getSchooleDescFallback(Throwable t) {
        if (BlockException.isBlockException(t)) {
            return "Blocked by Sentinel: " + t.getClass().getSimpleName();
        }
        return "Oops, failed: " + t.getClass().getCanonicalName();
    }
}
