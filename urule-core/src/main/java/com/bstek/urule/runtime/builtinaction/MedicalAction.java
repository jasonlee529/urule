package com.bstek.urule.runtime.builtinaction;

import com.bstek.urule.Utils;
import com.bstek.urule.model.library.action.annotation.*;

import java.math.*;

/**
 * @author luoning
 * @version 1.0
 * @date 2020/8/31 下午3:54
 */
@ActionBean(name="医用函数")
public class MedicalAction {
    @ActionMethod(name="求BMI(身体质量指数)")
    @ActionMethodParameter(names={"身高(米/m)","体重(千克/kg)"})
    public Number bmi(Object obj1,Object obj2){
        double height = Double.parseDouble(String.valueOf(obj1));
        double weight = Double.parseDouble(String.valueOf(obj2));
        double BMI = weight / (height * height);
        return BMI;
    }
    @ActionMethod(name="求肾小球滤过率(测试中")
    @ActionMethodParameter(names={"性别(男/女)","年龄","血肌酐(Scr)(mg/dL)"})
    public Number egfr(Object obj1,Object obj2,Object obj3){
        String sex = String.valueOf(obj1);
        int precision = 100;
        MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
        BigDecimal v0 = new BigDecimal("1");
        BigDecimal v1=Utils.toBigDecimal(obj2);
        BigDecimal v2=Utils.toBigDecimal(obj3);
//        v0.divide(v1, 100, RoundingMode.HALF_UP).pow(1234, mc);
        if ("男".equals(sex)) {

        } else if ("女".equals(sex)) {

        }
        return 1;
    }

}