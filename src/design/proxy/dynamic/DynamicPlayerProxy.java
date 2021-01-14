package design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: ArnoFrost
 * @Date: 2021/1/14 16:03
 * @Version 1.0
 */
public class DynamicPlayerProxy implements InvocationHandler {
    private Object object;

    public DynamicPlayerProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(object, args);
        if ("onInit".equals(method.getName())) {
            System.out.println("动态代理执行 do onInit");
        } else if ("onResume".equals(method.getName())) {
            System.out.println("动态代理执行 do onResume");
        } else if ("onPause".equals(method.getName())) {
            System.out.println("动态代理执行 do onPause");
        } else if ("onStop".equals(method.getName())) {
            System.out.println("动态代理执行 do onStop");
        }
        return result;
    }
}
