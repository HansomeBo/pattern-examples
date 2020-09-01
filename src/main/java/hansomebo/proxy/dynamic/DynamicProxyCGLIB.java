package hansomebo.proxy.dynamic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicProxyCGLIB<T> implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("DynamicProxyCGLIB : " + o.getClass().getSimpleName() + " , " + method.getName() + " , start");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("DynamicProxyCGLIB : " + o.getClass().getSimpleName() + " , " + method.getName() + " , end");
        return result;
    }

    public T getProxyObject(Class targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }
}
