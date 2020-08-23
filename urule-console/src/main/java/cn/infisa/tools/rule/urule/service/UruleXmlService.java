package cn.infisa.tools.rule.urule.service;

import cn.infisa.tools.rule.urule.entity.UruleXml;
import cn.infisa.tools.rule.urule.mapper.UruleXmlMapper;
import com.bstek.urule.console.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Urule xml 保存代理类
 */
@Slf4j
@Service
public class UruleXmlService {


//    @Autowired
//    private UruleXmlMapper mapper;

    public void saveFile(UruleXml xml) {
//        return mapper.insert(xml) > 0;
    }

    public void saveFile(String file, String content, Boolean newVersion, String versionComment, User user) {
        UruleXml xml =  new UruleXml();
        xml.setContent(content);
        xml.setName(file);
        xml.setType("");
        this.saveFile(xml);
    }
}
