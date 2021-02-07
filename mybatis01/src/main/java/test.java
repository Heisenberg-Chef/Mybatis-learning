import com.ray.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class test{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Class cls = Class.forName("com.ray.utils.MybatisUtils");
        System.out.println(cls);
        Method[] methods = cls.getMethods();
        for (Method method:methods
             ) {
            System.out.println(method);
        }

    }
}