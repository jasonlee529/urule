package cn.infisa.tools.km.model;

import com.bstek.urule.model.Label;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author libo
 * @Title: Tag
 * @Description:
 * @date 2020/8/13 10:07
 * @Version 1.0
 */
@Slf4j
@Getter
@Setter
public class Tag {
    @Label("数据库ID")
    private Long id;
    @Label("姓名")
    private String name;
    @Label("标签逻辑ID")
    private String uuid;
    @Label("标签类型")
    private String type;
    @Label("标签值")
    private String value;
    @Label("来源")
    private String source;
    @Label("排序")
    private int seq;
}
