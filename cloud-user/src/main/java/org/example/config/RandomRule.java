package org.example.config;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;

@Configuration
public class RandomRule extends RoundRobinRule {
    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // 初始化逻辑，如果需要的话
    }

    @Override
    public Server choose(ILoadBalancer lb, Object key) {
        System.out.println("---------------------进入ribbon策略选择了");
        if (lb == null) {
            return null;
        }
        Server server = null;
        while (server == null) {
            // 随机从服务器列表中选择一个
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }
            int index = new Random().nextInt(serverCount);
            server = upList.get(index);
            if (server == null) {
                Thread.yield();
            }
        }
        return server;
    }
}




