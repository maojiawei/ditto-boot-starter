import io.jovi.ditto.CodeGenerationApplication;
import io.jovi.ditto.code.constant.TemplateEnum;
import io.jovi.ditto.code.domain.CodeTemplateBO;
import io.jovi.ditto.code.domain.TableBO;
import io.jovi.ditto.code.service.CodeCreateService;
import io.jovi.ditto.code.service.DescTableService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CodeGenerationApplication.class })
public class CodeGenerationTest {

    @Autowired
    private CodeCreateService codeCreateService;

    @Autowired
    private DescTableService service;

    @Test
    public void test(){
        // 根据表名获取字段
        String tableName = "ditto_code_demo";
        TableBO tableBO = service.findFieldByTableName(tableName);
        System.out.println(tableBO);
        // 生成实体类型
        generateEntity(tableBO);
        // 生成仓储类
        generateRepository(tableBO);
        // 生成业务逻辑类
        generateService(tableBO);
        // 生成controller
        generateController(tableBO);

    }

    /**
     * 生成实体类
     */
    private void generateEntity(TableBO tableBO){
        // 生成实体类型
        CodeTemplateBO entity = new CodeTemplateBO();
        entity.setModuleName("ditto-boot-service");
        entity.setClassName(tableBO.getClassName());
        entity.setPackageName("io.jovi.ditto");
        entity.setTemplate(TemplateEnum.ENTITY);
        Map<String,Object> params = new HashMap<>();
        params.put("tableName",tableBO.getTableName());
        params.put("fieldList",tableBO.getFieldList());
        entity.setParams(params);
        codeCreateService.createEntityBean(entity);
    }

    /**
     * 生成仓储实体类
     */
    private void generateRepository(TableBO tableBO){
        // 生成实体类型
        CodeTemplateBO entity = new CodeTemplateBO();
        entity.setModuleName("ditto-boot-service");
        entity.setClassName(tableBO.getClassName());
        entity.setPackageName("io.jovi.ditto");
        entity.setTemplate(TemplateEnum.REPOSITORY);

        codeCreateService.createRepositoryBean(entity);
    }

    /**
     * 生成业务逻辑实体类
     */
    private void generateService(TableBO tableBO){
        // 生成实体类型
        CodeTemplateBO entity = new CodeTemplateBO();
        entity.setModuleName("ditto-boot-service");
        entity.setClassName(tableBO.getClassName());
        entity.setPackageName("io.jovi.ditto");
        entity.setTemplate(TemplateEnum.SERVICE);

        codeCreateService.createServiceBean(entity);
    }

    /**
     * 生成业务逻辑实体类
     */
    private void generateController(TableBO tableBO){
        // 生成实体类型
        CodeTemplateBO entity = new CodeTemplateBO();
        entity.setModuleName("ditto-boot-ops");
        entity.setClassName(tableBO.getClassName());
        entity.setPackageName("io.jovi.ditto");
        entity.setTemplate(TemplateEnum.CONTROLLER);
        Map<String,Object> params = new HashMap<>();
        params.put("fieldList",tableBO.getFieldList());
        entity.setParams(params);

        codeCreateService.createControllerBean(entity);
    }



    @Test
    public void dir(){
        StringBuilder templatePathBuilder = new StringBuilder(System.getProperty("user.dir"));
        System.out.println(templatePathBuilder.toString());
    }
}
