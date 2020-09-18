package cn.infisa.tools.rule.urule.service;

import com.bstek.urule.model.ExposeAction;
import com.bstek.urule.model.library.action.annotation.ActionMethodParameter;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 定义知识库服务的动作方法, 具体实现在知识库中
 * 定义实体实例/关系实例的操作
 * <p>
 * 注意:  此处仅提供方法名与注解提供的方法描述,
 * 具体的参数信息需要在动作库里配置
 * 实际服务的方法参数列表按照动作库配置进行书写
 *
 * @author luoning
 * @version 1.0
 * @date 2020/9/3 下午3:40
 */
@Service("uruleActionService")
public class KmExampleActionService {

    @ExposeAction("保存数据")
    public String saveData(Map<String, Object> data) {
        return "执行保存数据";
    }

    @ExposeAction("修改数据")
    public String updateData(Map<String, Object> data) {
        return "执行修改数据";
    }

    @ExposeAction("删除数据")
    public String deleteData(Map<String, Object> data) {
        return "执行删除数据";
    }

    @ExposeAction("打印变量名称")
    public String printName(String name) {
        return " [" + name + "] ";
    }
}
