package io.jovi.ditto.api;

import io.jovi.ditto.api.vo.DemoRespVO;

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
public interface DemoApi {
    /**
     * 查询
     * @param name
     * @return
     */
    List<DemoRespVO> list(String name);
}
