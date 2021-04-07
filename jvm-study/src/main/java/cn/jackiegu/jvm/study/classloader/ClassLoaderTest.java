package cn.jackiegu.jvm.study.classloader;

import cn.jackiegu.jvm.study.common.Utils;

/**
 * 类加载器测试
 *
 * @author JackieGu
 * @date 2021/4/2
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader appClassLoader = ClassLoaderTest.class.getClassLoader();
        Utils.logger("ClassLoaderTest的类加载器");
        System.out.println(appClassLoader);
        ClassLoader extClassLoader = appClassLoader.getParent();
        Utils.logger("AppClassLoader的类加载器");
        System.out.println(extClassLoader);
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        Utils.logger("ExtClassLoader的类加载器");
        System.out.println(bootstrapClassLoader);
        System.out.println();

        Class<?> dnsNameServiceClazz = Class.forName("sun.net.spi.nameservice.dns.DNSNameService");
        Utils.logger("sun.net.spi.nameservice.dns.DNSNameService的类加载器");
        System.out.println(dnsNameServiceClazz.getClassLoader());
        Class<?> stringClazz = Class.forName("java.lang.String");
        Utils.logger("java.lang.String的类加载器");
        System.out.println(stringClazz.getClassLoader());
        System.out.println();

        // ExtClassLoader无法加载AppClassLoaderClass
        Class<?> appClassLoaderClazz = extClassLoader.loadClass("cn.jackiegu.jvm.study.classloader.AppClassLoaderClass");
        Utils.logger("cn.jackiegu.jvm.study.classloader.AppClassLoaderClass的类加载器");
        System.out.println(appClassLoaderClazz.getClassLoader());
    }
}
