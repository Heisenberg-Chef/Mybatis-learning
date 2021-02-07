import com.ray.dao.*;
import com.ray.pojo.Blog;
import com.ray.pojo.pojo;
import com.ray.pojo.student;
import com.ray.pojo.teacher;
import com.ray.utils.IDUtil;
import com.ray.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import static com.ray.utils.MybatisUtils.getSqlSession;

public class demo01 {
    @Test
    public void test3() throws ParseException {
        SimpleDateFormat stdTime = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        System.out.println("Set your date with Pattern : yyyy-MM-dd hh-mm-ss");
        Scanner scanner = new Scanner(System.in);
        String strDate = scanner.nextLine();
        Date dt = stdTime.parse(strDate);
        System.out.println(dt);
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat stdTime = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        System.out.println("Set your date with Pattern : yyyy-MM-dd hh-mm-ss");
        Scanner scanner = new Scanner(System.in);
        String strDate = scanner.nextLine();
        Date dt = stdTime.parse(strDate);
        System.out.println(dt);
    }


    @Test
    public void test()
    {
        SqlSession sql = MybatisUtils.getSqlSession();
        BlogMapper mapper = sql.getMapper(BlogMapper.class);

        Blog blog1 = new Blog(IDUtil.getId(),"大佬vs仓井空","Heisenberg",new Date(),22);
        Blog blog2 = new Blog(IDUtil.getId(),"豪哥vs仓井空","Heisenberg",new Date(),33);
        Blog blog3 = new Blog(IDUtil.getId(),"V神vs仓井空","Heisenberg",new Date(),44);
        Blog blog4 = new Blog(IDUtil.getId(),"祁老师vs仓井空","Heisenberg",new Date(),55);
        Blog blog5 = new Blog(IDUtil.getId(),"大家一起vs仓井空","Heisenberg",new Date(),66);
        mapper.addBlog(blog1);
        mapper.addBlog(blog2);
        mapper.addBlog(blog3);
        mapper.addBlog(blog4);
        mapper.addBlog(blog5);

        sql.close();
    }

    @Test
    public void test2()
    {
        SqlSession sql = MybatisUtils.getSqlSession();
        BlogMapper mapper = sql.getMapper(BlogMapper.class);

        Map<String,Object> map = new HashMap();
        Map<String,Object> map1 = new HashMap();
        Map<String,Object> map2 = new HashMap();
        Map<String,Object> map3 = new HashMap();
        List<Blog> blogList = null;
        System.out.println("=========================map==========================");
        blogList = mapper.queryBlogIF(map);
        for (Blog blog:blogList
             ) {
            System.out.println(blog);
        }
        // map1 写入 author
        map1.put("author","Timon");
        System.out.println("=========================map1==========================");
        blogList = mapper.queryBlogIF(map1);
        for (Blog blog:blogList
        ) {
            System.out.println(blog);
        }
        // map2 写入 名字
        map2.put("title","大佬vs苍井空");
        System.out.println("=========================map2==========================");
        blogList = mapper.queryBlogIF(map2);
        for (Blog blog:blogList
        ) {
            System.out.println(blog);
        }
        //map3 都写入
        map3.put("author","Timon");
        map3.put("title","大佬vs苍井空");
        System.out.println("=========================map3==========================");
        blogList = mapper.queryBlogIF(map3);
        for (Blog blog:blogList
        ) {
            System.out.println(blog);
        }

    }

}
