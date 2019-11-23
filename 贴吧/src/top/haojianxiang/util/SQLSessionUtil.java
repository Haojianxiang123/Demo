package top.haojianxiang.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 郝健祥
 * @Date 2019-11-18 18:33
 * @Description 获取sqlSession映射器工具类
 * @Version 1.0
 */
public class SQLSessionUtil {
    public static SqlSession getSqlSession(){
        SqlSession session = null;
        try {
            InputStream inputStream = Resources.getResourceAsStream("MyBatis.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            session = factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }
}
