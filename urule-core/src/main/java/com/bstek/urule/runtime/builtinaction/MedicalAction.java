package com.bstek.urule.runtime.builtinaction;

import com.bstek.urule.Utils;
import com.bstek.urule.model.library.action.annotation.*;

import java.math.*;

/**
 * @author luoning
 * @version 1.0
 * @date 2020/8/31 下午3:54
 */
@ActionBean(name="医用方法")
public class MedicalAction {
    @ActionMethod(name="求BMI(身体质量指数)(测试用)")
    @ActionMethodParameter(names={"身高(米/m)","体重(千克/kg)"})
    public Number bmi(Object obj1,Object obj2){
        double height = Double.parseDouble(String.valueOf(obj1));
        double weight = Double.parseDouble(String.valueOf(obj2));
        double BMI = weight / (height * height);
        return BMI;
    }


}