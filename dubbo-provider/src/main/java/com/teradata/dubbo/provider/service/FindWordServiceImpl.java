package com.teradata.dubbo.provider.service;

import com.teradata.dubbo.api.FindWordService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @Project:
 * @Description:
 * @Version 1.0.0
 * @Throws SystemException:
 * @Author: <li>2018/12/11/011 Administrator Create 1.0
 * @Copyright ©2018-2019 al.github
 * @Modified By:
 */
@Service(
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}",
        timeout = 5000
)
public class FindWordServiceImpl implements FindWordService {
    @Override
    public String findString(String str) {
        System.out.println("服务端被调用了find!");
        return "find!" + str;
    }
}
