package com.bstek.urule.springboot.controller;

import cn.infisa.tools.km.model.Tag;
import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.response.RuleExecutionResponse;
import com.bstek.urule.runtime.service.KnowledgeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
    * @Title: RuleFireController
    * @Description: 
    * @author libo
    * @date 2020/8/18 16:04
    * @Version 1.0
    */
@Slf4j
@RequestMapping("rule")
@RestController
public class RuleFireController {
    @GetMapping("test")
        public Map doTest() throws Exception{
            //从Spring中获取KnowledgeService接口实例
            KnowledgeService service=(KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
            //通过KnowledgeService接口获取指定的资源包"projectName/test123"
            KnowledgePackage knowledgePackage=service.getKnowledge("demo/1");
            //通过取到的KnowledgePackage对象创建KnowledgeSession对象
            KnowledgeSession session= KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

            Tag tag=new Tag();
            tag.setName("abc");
            //将业务数据对象Employee插入到KnowledgeSession中
            session.insert(tag);
            //执行所有满足条件的规则
            RuleExecutionResponse response=session.fireRules();
            Map result = new HashMap();
            result.put("res", tag);
            return result;
        }
}
