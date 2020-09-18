package cn.infisa.tools.rule.urule.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 标签值数据
 * </p>
 *
 * @author luoning
 * @since 2020-06-01
 */
@Data
public class ExampleData implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 实例id
     */
    private Long exampleId;

    /**
     * 标签id
     */
    private Long tagId;

    /**
     * 数据id
     */
    private Long dataId;

    /**
     * 值描述, 可以是长文本
     */
    private String value;

    /**
     * 标签值数据类型 0: 其他 1. 字符串 5. 自定义长文本
     */
    private Long valueType;
}
