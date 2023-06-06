package cn.jackiegu.oop.design.pattern.proxy.dynamic;

import lombok.extern.slf4j.Slf4j;

/**
 * 动态代理实现类
 *
 * @author JackieGu
 * @date 2020/10/11
 */
@Slf4j
public class UseServiceImpl implements UserService {

    @Override
    public Integer execute(int result) {
        log.info("executing...");
        return result;
    }
}
