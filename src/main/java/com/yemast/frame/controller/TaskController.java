package com.yemast.frame.controller;

import com.yemast.frame.common.BaseController;
import com.yemast.frame.task.TestTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author WangWx
 * @date 2018年08月16日 15:16
 */
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController extends BaseController {

    @Autowired
    private TestTask testTask;

    @RequestMapping("get")
    public String test1() throws Exception {
        long start = System.currentTimeMillis();
        Future<Boolean> a = testTask.doTask11();
        Future<Boolean> b = testTask.doTask22();
        Future<Boolean> c = testTask.doTask33();
        while (!a.isDone() || !b.isDone() || !c.isDone()) {
            if (a.isDone() && b.isDone() && c.isDone()) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        String times = "任务全部完成，总耗时：" + (end - start) + "毫秒";
        log.info(times);
        return times;
    }
}
