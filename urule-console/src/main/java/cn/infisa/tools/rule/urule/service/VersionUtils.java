package cn.infisa.tools.rule.urule.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

/**
    * @Title: VersionUtils
    * @Description: 
    * @author libo
    * @date 2020/8/25 10:28
    * @Version 1.0
    */
@Slf4j
public class VersionUtils {

    public static String newVersion(String oldVersion){
        if(StringUtils.isBlank(oldVersion)){
           return "1.0";
        }
        String[] a = StringUtils.split(oldVersion,".");
        Integer old = Integer.parseInt(a[1]);
        a[1]= String.valueOf(old+1);
        return String.join(".",a);
    }

}
