package cn.infisa.tools.rule.urule.web;

import cn.infisa.tools.rule.urule.entity.UruleXml;
import cn.infisa.tools.rule.urule.service.UruleXmlService;
import com.bstek.urule.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
    * @Title: UruleController
    * @Description: 
    * @author libo
    * @date 2020/8/24 10:06
    * @Version 1.0
    */
@Slf4j
@RestController
@RequestMapping("xml")
public class UruleController {
    @Autowired
    private UruleXmlService service;
    @RequestMapping("one")
    public Map getOne(HttpServletRequest request){
        Map result =  new HashMap();
        String name = request.getParameter("fileName");
        name= Utils.decodeURL(name);
        if(StringUtils.isBlank(name)){
            result.put("success",false);
            result.put("message","fileName不能为空");
        }else{
            result.put("success",true);
            List<UruleXml> xml = service.findByName(name);
            result.put("data",xml);
        }
        return result;
    }
}
