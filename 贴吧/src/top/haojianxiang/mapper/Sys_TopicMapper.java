package top.haojianxiang.mapper;

import top.haojianxiang.entity.Sys_Topic;
import java.util.List;

public interface Sys_TopicMapper {
    //查看帖子信息列表
    public List<Sys_Topic> queryAll();
    //发表帖子
    public int insert(Sys_Topic sys_topic);
    //查看topicI帖子的详细信息
    public Sys_Topic selectOne(int topicId);
    //访问量+1
    public int add(int topicId);
}
