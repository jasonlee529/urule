package cn.infisa.tools.rule.urule.service;

import cn.infisa.tools.rule.urule.entity.UruleXml;
import cn.infisa.tools.rule.urule.mapper.UruleXmlMapper;
import com.bstek.urule.console.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Urule xml 保存代理类
 */
@Slf4j
@Service
public class UruleXmlService implements InitializingBean {

    @Autowired
    private UruleXmlMapper mapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("start");
    }

    public void saveFile(UruleXml xml) {
        mapper.insert(xml);
    }

    public void saveFile(String file, String content, Boolean newVersion, String versionComment, User user) {
        UruleXml xml = new UruleXml();
        xml.setContent(content);
        xml.setName(file);
        xml.setType("");
        this.saveFile(xml);
    }

    public UruleXml findByName(String name) {
        return mapper.findByName(name);
    }
}
