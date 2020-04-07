package io.jovi.ditto.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.jovi.ditto.entity.DemoDO;

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
public interface DemoService extends IService<DemoDO> {
    /**
     * 查询
     * @param name
     * @return
     */
    List<DemoDO> query(String name);
}
