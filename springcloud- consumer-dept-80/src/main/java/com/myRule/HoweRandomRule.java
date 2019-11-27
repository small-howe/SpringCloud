/*
 *
 * Copyright 2013 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.myRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class HoweRandomRule extends AbstractLoadBalancerRule {

    // 每个机器访问5次  换下一次服务(3个)

    // total=0,默认=0,如果=5 我们就指向下一个服务
   //index =0 默认0 如果total=5,index+1;
    private int total = 0;//被调的次数
    private int currentIndex=0;//当前是谁在提供服务



    /**
     * Randomly choose from all living servers
     */
   // @edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();//获得活着的服务
            List<Server> allList = lb.getAllServers();//获得全部的服务

            int serverCount = allList.size();
            if (serverCount == 0) {

                return null;
            }

//            int index = chooseRandomInt(serverCount);//生成区间随机数
//            server = upList.get(index);// 从活着的服务随机获取一个

            //-================================

            if (total<5){
                 server = upList.get(currentIndex);
                 total++;
            }else {
                total=0;
                currentIndex++;
                if (currentIndex>upList.size()){

                    currentIndex=0;
                }
                server =  upList.get(currentIndex); //从活着的服务中 获取指定的服务来进行操作
            }





            //-================================

            if (server == null) {

                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}
