package com.github.zhanglp92;

import com.github.zhanglp92.aop.proxy.staticproxy.Cat;
import com.github.zhanglp92.aop.proxy.staticproxy.FeederProxy;
import com.github.zhanglp92.aop.proxy.staticproxy.Lion;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

@Log4j2
public class StaticProxyTest {
    @Test
    public void proxyTest() {
        Lion lion = new Lion();
        lion.setName("狮子 小王");
        lion.setRunningSpeed(100);

        Cat proxy = new FeederProxy(lion);
        log.info("{} -- {}", Thread.currentThread().getName(), proxy.eatFood("水牛"));
    }
}
