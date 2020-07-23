package com.github.zhanglp92;

import com.google.common.collect.Lists;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.List;

@Log4j2
public class ThreadLocalTest {
    @Test
    public void threadLocalTest() {
        int n = 10 ^ 5;

        /* 测试一个线程可以创建多少个 ThreadLocal */
        List<ThreadLocal<Integer>> threadLocals = Lists.newArrayListWithCapacity(n);

        for (int idx = 0; idx < n; idx++) {
            ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
            threadLocals.add(threadLocal);
            threadLocal.set(idx);
        }

        threadLocals.forEach(threadLocal -> log.info("threadLocal val = {}", threadLocal.get()));
    }
}
