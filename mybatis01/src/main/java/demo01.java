import com.ray.dao.UserMapper;
import com.ray.dao.UserMapperAnnotation;
import com.ray.dao.studentMapper;
import com.ray.dao.teacherMapper;
import com.ray.pojo.pojo;
import com.ray.pojo.student;
import com.ray.pojo.teacher;
import com.ray.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.*;


import static com.ray.utils.MybatisUtils.getSqlSession;

public class demo01 {
    @Test
    public void getTeacher()
    {
        SqlSession sql = MybatisUtils.getSqlSession();
        teacherMapper mapper = sql.getMapper(teacherMapper.class);
        List<teacher> teacherList = mapper.getteacher(1);
        for (teacher teacher:teacherList
             ) {
            System.out.println(teacher);
        }
    }

    @Test
    public void getstudentvsteacher()
    {
        SqlSession sql = MybatisUtils.getSqlSession();
        studentMapper mapper =  sql.getMapper(studentMapper.class);
        List<student> studentsList = mapper.getstudent();
        for (student student:studentsList
        ) {
            System.out.println(student);
        }
    }
    @Test
    public void getstudentvsteacher2()
    {
        SqlSession sql = MybatisUtils.getSqlSession();
        studentMapper mapper =  sql.getMapper(studentMapper.class);
        List<student> studentsList = mapper.getstudent2();
        for (student student:studentsList
        ) {
            System.out.println(student);
        }
    }

    @Test
    public void getUserByLimit_Test()
    {
        SqlSession sql = MybatisUtils.getSqlSession();
        UserMapper mapper = sql.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",1);
        map.put("pageSize",3);
        mapper.getUserByLimit(map);
        sql.commit();
        sql.close();
    }

    @Test
    public void getUserByRowBounds()
    {
        SqlSession sql = MybatisUtils.getSqlSession();

        RowBounds rb = new RowBounds(1,2);
        //  通过Java代码层面实现分页
        List<pojo> userlist = sql.selectList
                ("com.ray.dao.UserMapper.getUserByLimit2",
                        null,rb);
        for (pojo user:userlist
             ) {
            System.out.println(user);
        }

        sql.close();
    }
    
    @Test
    public void select() {
        SqlSession sql = getSqlSession();
        //执行SQL
        //拿到一个方法类,通过反射的方式拿到接口中的所有method
        UserMapper usermapper = sql.getMapper(UserMapper.class);
        List<pojo> userlist = usermapper.getUserList();

        for (pojo user:userlist
             ) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void testAnnotation()
    {
        SqlSession sql = getSqlSession();

        UserMapperAnnotation mapper = sql.getMapper(UserMapperAnnotation.class);
        List<pojo> userlist = mapper.getUser();

        for (pojo user:userlist
             ) {
            System.out.println(user);
        }
        sql.close();
    }

    @Test
    public void addUser()
    {
        SqlSession sql = getSqlSession();
        UserMapper mapper = sql.getMapper(UserMapper.class);

        int res = mapper.addUser(new pojo(6,"ray","123123"));
        if(res > 0)
        {
            System.out.println("sucess.");
        }
        sql.commit();
        sql.close();
    }

    @Test
    public void Modify()
    {
        SqlSession sql =  MybatisUtils.getSqlSession();
        UserMapper mapper = sql.getMapper(UserMapper.class);
        mapper.modifyUser(new pojo(1,"祁磊","008778"));

        sql.commit();
        sql.close();
    }

    @Test
    public void deleteUser()
    {
        SqlSession sql =  MybatisUtils.getSqlSession();
        UserMapper mapper = sql.getMapper(UserMapper.class);
        mapper.deleteUser(3);

        sql.commit();
        sql.close();
    }

    @Test
    public void map()
    {
        SqlSession sql =  MybatisUtils.getSqlSession();
        UserMapper mapper = sql.getMapper(UserMapper.class);

        HashMap<String,Object> map = new HashMap<String,Object>();

        map.put("username","ray");
        map.put("password","666666");
        map.put("idnum",2);
        mapper.modifyUser2(map);

        sql.commit();
        sql.close();
    }
}
