package io.jovi.ditto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jovi.ditto.entity.DemoDO;
import io.jovi.ditto.repository.DemoRepository;
import io.jovi.ditto.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
@Service
public class DemoServiceImpl extends ServiceImpl<DemoRepository, DemoDO> implements DemoService {
    @Autowired
    private DemoRepository repository;
    /**
     * 查询
     *
     * @param name
     * @return
     */
    @Override
    public List<DemoDO> query(String name) {
        QueryWrapper<DemoDO> wrapper = new QueryWrapper();
        wrapper.like(StringUtils.hasText(name),"name", name);

        return repository.selectList(wrapper);
    }
}
