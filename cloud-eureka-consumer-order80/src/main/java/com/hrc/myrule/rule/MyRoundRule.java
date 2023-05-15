package com.hrc.myrule.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRoundRule extends AbstractLoadBalancerRule {

    private AtomicInteger integer = new AtomicInteger(0);

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    public int incrementAndGetModulo(int modulo) {
        for (;;) {
            int current = integer.get();
            int next = (current + 1) % modulo;
            if (integer.compareAndSet(current, next))
                return next;
        }
    }

    //默认会调用choose方法，可以从父类哪里拿到LoadBalancer
    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }

    public Server choose(ILoadBalancer bl, Object key) {
        if (bl == null) {
            return null;
        }
        List<Server> allServers = bl.getAllServers();
        List<Server> reachableServers = bl.getReachableServers();
        if (allServers.isEmpty() || reachableServers.isEmpty()) {
            return null;
        }

        int current = 0;
        int count = 0;
        Server server = null;
        while (count++<=10) {
            //AtomicInteger使用原子操作是为了防止并发出现异常
            current = incrementAndGetModulo(allServers.size());
            server = allServers.get(current);
            if (server == null) {
                continue;
            }
            if (server.isAlive() && server.isReadyToServe()){
                return server;
            }
            //server没有活着需要清除server来获取下一个
            server = null;
        }


        return null;
    }
}
