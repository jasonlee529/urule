package com.bstek.urule.console;

import com.bstek.urule.model.ExposeAction;
import com.bstek.urule.model.library.action.annotation.ActionMethodParameter;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 定义知识库服务的动作方法, 具体实现在知识库中
 * @author luoning
 * @version 1.0
 * @date 2020/9/3 下午3:40
 */
@Service("uruleActionService")
public class KmUruleActionService {

    @ExposeAction("保存数据")
    public String saveData(Map<String, Object> data){
        return "执行保存数据";
    }
    @ExposeAction("修改数据")
    public String updateData(Map<String, Object> data){
        return "执行修改数据";
    }
    @ExposeAction("删除数据")
    public String deleteData(Map<String, Object> data){
        return "执行删除数据";
    }
}
