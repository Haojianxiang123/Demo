package top.haojianxiang.mapper;

import top.haojianxiang.entity.Sys_Reply;

import java.util.List;

public interface Sys_ReplyMapper {
    //查看topicId的帖子的所有评论
    public List<Sys_Reply> selectReply(int topicId);
    //发表评论
    public int publishReply(Sys_Reply sys_reply);
}
