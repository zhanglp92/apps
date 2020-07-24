package com.github.zhanglp92.dao;

import com.github.zhanglp92.aop.annotations.ADao;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Dao {
    @ADao
    public void update() {
        log.info("PeopleDao.update()");
    }

    @ADao
    public void select() {
        log.info("PeopleDao.select()");
    }
}
