package cn.infisa.tools.rule.urule.mapper;

import cn.infisa.tools.rule.urule.entity.UruleXml;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UruleXmlMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UruleXml record);

    int insertSelective(UruleXml record);

    UruleXml selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UruleXml record);

    int updateByPrimaryKey(UruleXml record);

    UruleXml findByName(@Param("name") String name);
}