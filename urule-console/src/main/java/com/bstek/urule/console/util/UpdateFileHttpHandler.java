package com.bstek.urule.console.util;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 修改数据时, 异步请求对应的知识库服务
 *
 * @author luoning
 * @version 1.0
 * @date 2020/9/3 上午10:43
 */
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFileHttpHandler implements Runnable {

    private String url;
    private Map paramMap;

    @Override
    public void run() {
        HttpUtils.doPostForm(url, paramMap);
    }
}
