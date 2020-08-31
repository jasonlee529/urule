package com.bstek.urule.console.config;

import java.util.*;

/**
 * @author luoning
 * @version 1.0
 * @date 2020/8/31 下午2:40
 */
public interface UruleContants {

    Map<String, String> KM_SERVER = new HashMap<String, String>() {{
        this.put("dev", "http://192.168.1.22:8081");
        this.put("base", "http://192.168.1.215:32150");
        this.put("proView", "http://192.168.1.218:32150");
    }};
}
