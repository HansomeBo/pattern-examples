package hansomebo.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyJDK<T> implements InvocationHandler {

    /**
     * 被代理的对象
     */
    private final T target;

    public DynamicProxyJDK(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("DynamicProxyJDK : " + proxy.getClass().getSimpleName() + " , " + method.getName() + " , start");
        Object result = method.invoke(target, args);
        System.out.println("DynamicProxyJDK : " + proxy.getClass().getSimpleName() + " , " + method.getName() + " , end");
        return result;
    }

    /**
     * 获取新生成的代理对象
     *
     * @return
     */
    public T getProxyObject() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


}
