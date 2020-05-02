package ${packageName}.controller;

import com.github.pagehelper.Page;
import ${packageName}.controller.vo.${className}DeleteReqVO;
import ${packageName}.controller.vo.${className}HandleReqVO;
import ${packageName}.controller.vo.${className}PageReqVO;
import ${packageName}.controller.vo.${className}PageRespVO;
import io.jovi.ditto.core.domain.vo.PageResultVO;
import io.jovi.ditto.core.web.response.ApiResponse;
import ${packageName}.entity.${className}DO;
import ${packageName}.service.${className}Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
 * Copyright: Copyright (c) 2020
 * </p>
 *
 * @author Jovi
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/ditto/${className?lower_case}")
public class ${className}Controller {
    @Autowired
    private ${className}Service service;

    /***
     * 分页查询
     * @param pageReqVO 分页查询对象
     * @return  ApiResponse<Page<UserPageRespVO>> 分页列表
     */
    @PostMapping("/page")
    public ApiResponse<Page<${className}PageRespVO>> pageable(@RequestBody ${className}PageReqVO pageReqVO) {

        Page<${className}DO> page = service.page(pageReqVO.pageable());
        List<${className}PageRespVO> list = page.getResult().stream().map(e -> new ${className}PageRespVO(e)).collect(Collectors.toList());
        PageResultVO pageResultVO = PageResultVO.create(pageReqVO.pageable(),page.getTotal(),list);
        return ApiResponse.success(pageResultVO);
    }

    /**
     * 添加或更新
     *
     * @param handleReqVO 数据处理对象
     * @return
     */
    @PostMapping("/handle")
    public ApiResponse handle(@RequestBody ${className}HandleReqVO handleReqVO) {
        ${className}DO entity = new ${className}DO();
        // 如果ID为空，即添加
        if(handleReqVO.getId() == null){
            BeanUtils.copyProperties(handleReqVO, entity);
            this.service.save(entity);
            return ApiResponse.success("添加成功").code(200);
        }
        entity = service.getById(handleReqVO.getId());
        BeanUtils.copyProperties(handleReqVO,entity,"id");
        this.service.saveOrUpdate(entity);
        return ApiResponse.success("更新成功").code(201);
    }
    /**
     * 删除
     *
     * @param deleteReqVO 删除处理对象
     * @return
     */
    @PostMapping("/delete")
    public ApiResponse delete(@RequestBody ${className}DeleteReqVO deleteReqVO) {
        this.service.removeByIds(deleteReqVO.getDeleteIds());
        return ApiResponse.success("删除成功").code(200);
    }


}
