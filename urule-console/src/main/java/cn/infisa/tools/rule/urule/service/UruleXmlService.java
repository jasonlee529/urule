package cn.infisa.tools.rule.urule.service;

import cn.infisa.tools.rule.urule.entity.UruleXml;
import cn.infisa.tools.rule.urule.mapper.UruleXmlMapper;
import com.bstek.urule.Utils;
import com.bstek.urule.console.User;
import com.bstek.urule.model.ExposeAction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
        if (xml.getId() == null) {
            mapper.insert(xml);
        } else {
            mapper.updateByPrimaryKeySelective(xml);
        }
    }

    public UruleXml saveFile(String file, String content, Boolean newVersion, String versionComment, User user) {
        file = Utils.decodeURL(file);
        UruleXml xml = new UruleXml();
        List<UruleXml> xmls = mapper.findByName(file);
        if (!CollectionUtils.isEmpty(xmls)) {
            xml = xmls.get(xmls.size() - 1);
        }
        if (newVersion) {
            xml.setId(null);
            xml.setVersion(VersionUtils.newVersion(xml.getVersion()));
        }
        if (StringUtils.isBlank(xml.getVersion())) {
            xml.setVersion(VersionUtils.newVersion(""));
        }
        xml.setContent(content);
        xml.setName(file);
        xml.setType("");
        this.saveFile(xml);
        return xml;
    }

    @ExposeAction(value="测试Int")
    public List<UruleXml> findByName(String name) {
        return mapper.findByName(name);
    }
}
