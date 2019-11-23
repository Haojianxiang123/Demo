package top.haojianxiang.service;

import org.apache.ibatis.session.SqlSession;
import top.haojianxiang.entity.Sys_Reply;
import top.haojianxiang.entity.Sys_Topic;
import top.haojianxiang.mapper.Sys_ReplyMapper;
import top.haojianxiang.mapper.Sys_TopicMapper;
import top.haojianxiang.util.SQLSessionUtil;

import java.util.List;
import java.util.Scanner;

/**
 * @Author 郝健祥
 * @Date 2019-11-18 19:08
 * @Description ...
 * @Version 1.0
 */
public class ServiceImpl implements Service {
    //静态键盘扫描器
    static Scanner sc = new Scanner(System.in);

    static SqlSession sqlSession = SQLSessionUtil.getSqlSession();
    //静态Sys_TopicMapper实例
    static Sys_TopicMapper topicMapper = sqlSession.getMapper(Sys_TopicMapper.class);
    //静态Sys_ReplyMapper实例
    static Sys_ReplyMapper replyMapper = sqlSession.getMapper(Sys_ReplyMapper.class);

    /**
     * 查询帖子列表信息
     * @return
     */
    @Override
    public List<Sys_Topic> queryAll() {
        SqlSession sqlSession = SQLSessionUtil.getSqlSession();
        Sys_TopicMapper topicMapper = sqlSession.getMapper(Sys_TopicMapper.class);
        List<Sys_Topic> sys_topics = topicMapper.queryAll();
        return sys_topics;
    }

    /**
     * 发表帖子
     * @return
     */
    @Override
    public int publish() {
        SqlSession sqlSession = SQLSessionUtil.getSqlSession();
        Sys_TopicMapper topicMapper = sqlSession.getMapper(Sys_TopicMapper.class);
        System.out.println();
        System.out.println("------------发表帖子------------");
        System.out.print("帖子标题：");
        String title = sc.next();
        System.out.print("作者：");
        String author = sc.next();
        System.out.print("帖子内容：");
        String content = sc.next();
        Sys_Topic sys_topic = new Sys_Topic(title, content, author);
        int result = topicMapper.insert(sys_topic);
        sqlSession.commit();
        return result;
    }

    /**
     * 查询帖子详细信息
     * @param topicId
     * @return
     */
    @Override
    public Sys_Topic selectOne(int topicId) {
        //访问量+1
        int result = topicMapper.add(topicId);
        sqlSession.commit();
        //查询帖子详细信息
        Sys_Topic sysTopic = topicMapper.selectOne(topicId);
        List<Sys_Reply> sys_replies = replyMapper.selectReply(topicId);
        sysTopic.setReplyList(sys_replies);
        System.out.println();
        System.out.println(result>0? "访问量 +1" :"访问量添加失败");
        return sysTopic;
    }

    /**
     * 发表评论
     * @param topicId
     * @return
     */
    @Override
    public int publishReply(int topicId) {
        System.out.println();
        System.out.println("------------发表评论------------");
        System.out.print("作者：");
        String author = sc.next();
        System.out.print("评论内容：");
        String content = sc.next();
        Sys_Reply sys_reply = new Sys_Reply(topicId, author, content);
        int result = replyMapper.publishReply(sys_reply);
        sqlSession.commit();
        System.out.println(result>0? "评论成功！": "评论失败！");
        return 0;
    }
}
