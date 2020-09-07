package cn.infisa.tools.rule.urule.entity;

import com.bstek.urule.model.Label;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 实体标签管理表,定义描述实体的元数据
 * </p>
 *
 * @author luoning
 * @since 2020-06-01
 */
@Data
public class SubstanceTag implements Serializable {

//    private Long id;
    private static final long serialVersionUID = 1L;

    @Label("标签名称")
    private String name;

    /**
     * 编码
     */
    @Label("标签编码")
    private String code;

//    private String fieldName;

    /**
     * 标签类型 0. 基础定义标签 1. 自定义标签 2. 虚拟标签
     */
//    private Long dataType;

    @Label("标签分类")
    private String classWayName;

    @Label("标签简称")
    private String simpleName;

    /**
     * 备注, 标签含义描述
     */
    @Label("标签含义")
    private String remark;

    /**
     * 标签值数据类型(具体)
     * 1. 数字 2. 日期 3. 日期时间 4. 自定义短文本 5. 自定义长文本 6. 枚举文本(知识库来源,具体内容见: 标签选项来源)
     */
    @Label("标签值类型")
    private Long valueDetailType;

    // 分类路径id
//    private String classWayId;

    /**
     * 标签规则类型
     */
    @Label("标签规则类型")
    private Long ruleType;


    /**
     * 标签值
     */
    @Label("标签值")
    private String value;

    /**
     * 值单位
     */
    @Label("标签值单位")
    private String valueUnit;

    /**
     * 标签规则
     */
//    private String ruleJson;

    /**
     * 标签值来源
     */
    @Label("标签值来源")
    private String valueSource;

    /**
     * 标签来源
     */
    @Label("标签来源")
    private String source;

    /**
     * 应用项目名称
     */
    @Label("项目应用")
    private String apply;
    /**
     * 标签选项来源 具体类型对应关系与日志记录中的数据类型一致
     * 0: 其他
     * 若为虚拟标签, 则来源为: 1: 关联前项标签 2: 后项标签集 3. 后项标签下拉选项
     */
//    private Long valueOptionSource;

    /**
     * 标签值数据类型 0: 其他 1. 值域选项 5. 自定义长文本 6. 字符串
     */
//    private Long valueType = 0L;


//    /**
//     * 应用项目
//     */
//    private List<DatasetDimension> applyList;


    /**
     * 根据valueOptionSource定义具体含义
     */
//    private Long valueDataId;

    /**
     * valueDataId的名称描述
     */
//    private String valueDataName;

    /**
     * 关联关系标签, 用于限定后项实体
     */
//    private Long relationId;

    /**
     * 对应实体
     */
//    private Long substanceId;

    /**
     * 是否需要排重处理
     */
//    private Long isRepeat;

    /**
     * 业务id
     */
//    private Long dataId;

    /**
     * 业务id的父id
     */
//    private Long parentId;

    /**
     * 前序序列编号
     */
//    private Long line;

    /**
     * 深度
     */
//    private Long lvl;
    /**
     * 标签计算方式 1. 直接抽取 2. 数据治理 3. 自动计算
     */
    @Label("标签计算方式")
    private String operation;


    /**
     * 排序号
     */
    @Label("标签序号")
    private Long sort;

    /**
     * 创建人
     */
    @Label("创建人")
    private String createUser;

    /**
     * 逻辑删除
     */
//    private Long isDeleted;

//    /**
//     * 日志操作
//     */
//    private DailyRecord record;

//    // 用于控制页面行为的属性
//    private Long showList;
//
//    private Long showSearch;
//
//    private Long showAdd;
//
//    private Long orderType;
//
//    private Long isUpdate;
//
//    private Long isRequired;

//    /**
//     * 标签选项, 用于值域类型标签
//     */
//    private List<OptionsModel> valueOptions;


    /**
     * 审核状态 0:审核中 1: 完成
     */
    @Label("审核状态")
    private Long audit;


    /**
     * 标签状态
     */
    @Label("禁用/启用状态")
    private Long status;

}
