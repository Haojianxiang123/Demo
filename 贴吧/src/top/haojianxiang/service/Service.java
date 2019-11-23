package top.haojianxiang.service;

import top.haojianxiang.entity.Sys_Topic;

import java.util.List;

/**
 * 业务逻辑层接口
 */
public interface Service {
    //查询帖子信息
    public List<Sys_Topic> queryAll();
    //发表帖子
    public int publish();
    //查看帖子详细信息（访问量加1）
    public Sys_Topic selectOne(int topicId);
    //发表评论
    public int publishReply(int topicId);
}
