package com.yemast.frame.task;

import com.yemast.frame.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Future;

/**
 * 定时任务
 *
 * @author WangWx
 * @date 2018年08月16日 13:21
 */
@Slf4j
@Component
public class TestTask {

    // 每隔3秒执行一次
    // @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "4-40 * * * * ?")
    public void printDate() {
        log.info(DateUtil.formatDateTime(new Date()));
    }

    @Async
    public Future<Boolean> doTask11() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        log.info("任务1耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask22() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(700);
        long end = System.currentTimeMillis();
        log.info("任务2耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

    @Async
    public Future<Boolean> doTask33() throws Exception {
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        long end = System.currentTimeMillis();
        log.info("任务3耗时:" + (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }

}
