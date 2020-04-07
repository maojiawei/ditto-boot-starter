package io.jovi.ditto.controller;

import io.jovi.ditto.api.DemoApi;
import io.jovi.ditto.api.vo.DemoRespVO;
import io.jovi.ditto.entity.DemoDO;
import io.jovi.ditto.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

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
@Slf4j
@RestController
@RequestMapping("/demo/")
public class DemoController implements DemoApi {
    @Autowired
    private DemoService service;


    /**
     * 查询
     *
     * @param name
     * @return
     */
    @Override
    @GetMapping("list")
    public List<DemoRespVO> list(String name) {
        List<DemoDO> demos = service.query(name);
        List<DemoRespVO> respS = demos.stream().map(e -> {
            DemoRespVO respVO = new DemoRespVO();
            BeanUtils.copyProperties(e,respVO);
            return respVO;
        }).collect(Collectors.toList());
        return respS;
    }
}
