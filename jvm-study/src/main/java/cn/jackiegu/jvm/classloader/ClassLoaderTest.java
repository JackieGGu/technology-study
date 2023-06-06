package cn.jackiegu.jvm.classloader;

import cn.jackiegu.technology.common.util.LoggerUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 类加载器测试
 * JDK1.8运行
 *
 * @author JackieGu
 * @date 2021/4/2
 */
@Slf4j
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader appClassLoader = ClassLoaderTest.class.getClassLoader();
        LoggerUtil.info("ClassLoaderTest的类加载器");
        log.info(appClassLoader.toString());
        ClassLoader extClassLoader = appClassLoader.getParent();
        LoggerUtil.info("AppClassLoader的类加载器");
        log.info(extClassLoader.toString());
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        LoggerUtil.info("ExtClassLoader的类加载器");
        log.info(bootstrapClassLoader == null ? null : bootstrapClassLoader.toString());

        Class<?> dnsNameServiceClazz = Class.forName("sun.net.spi.nameservice.dns.DNSNameService");
        LoggerUtil.info("sun.net.spi.nameservice.dns.DNSNameService的类加载器");
        log.info(dnsNameServiceClazz.getClassLoader().toString());
        Class<?> stringClazz = Class.forName("java.lang.String");
        LoggerUtil.info("java.lang.String的类加载器");
        log.info(stringClazz.getClassLoader() == null ? null : stringClazz.getClassLoader().toString());

        // ExtClassLoader无法加载AppClassLoaderClass
        Class<?> appClassLoaderClazz = extClassLoader.loadClass("cn.jackiegu.jvm.classloader.AppClassLoaderClass");
        LoggerUtil.info("cn.jackiegu.jvm.classloader.AppClassLoaderClass的类加载器");
        log.info(appClassLoaderClazz.getClassLoader().toString());
    }
}
