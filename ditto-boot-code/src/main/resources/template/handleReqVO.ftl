package ${packageName}.controller.vo;

import io.jovi.ditto.core.domain.vo.HandleReqVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



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
 * @author ditto
 * @version 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ${className}HandleReqVO extends HandleReqVO   {

	<#list fieldList as field>
    /**
     * 字段名
     */
    private ${field.type} ${field.name};
    </#list>
}
