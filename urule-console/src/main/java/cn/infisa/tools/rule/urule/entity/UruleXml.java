package cn.infisa.tools.rule.urule.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UruleXml {
    /**
    * id
    */
    private Long id;

    /**
    * 文件名称
    */
    private String name;

    /**
    * 文件类型
    */
    private String type;

    /**
    * 文件内容
    */
    private String content;
    /**
     * 版本
     */
    private String version;
}