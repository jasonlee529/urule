package cn.infisa.tools.rule.urule.service;

import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
    * @Title: TestVersionUtils
    * @Description: 
    * @author libo
    * @date 2020/8/25 10:59
    * @Version 1.0
    */
@Slf4j
public class TestVersionUtils {

    @Test
    public void test1(){
        Assert.assertEquals("1.0",VersionUtils.newVersion(""));
    }
    @Test
    public void test2(){
        Assert.assertEquals("1.1",VersionUtils.newVersion("1.0"));
    }
    @Test
    public void test3(){
        Assert.assertEquals("1.10",VersionUtils.newVersion("1.9"));
    }
}
