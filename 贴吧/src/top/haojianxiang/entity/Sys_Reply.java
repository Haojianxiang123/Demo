package top.haojianxiang.entity;

import top.haojianxiang.util.DateUtil;

import java.util.Date;

/**
 * @Author 郝健祥
 * @Date 2019-11-18 17:50
 * @Description 评论表
 * @Version 1.0
 */
public class Sys_Reply {
    private int replyId;
    private int topicId;
    private String author;
    private String content;
    private Date createDate;

    public Sys_Reply() {
    }

    public Sys_Reply(int topicId, String author, String content) {
        this.topicId = topicId;
        this.author = author;
        this.content = content;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return  "【作者】" + author +
                "\t\t【评论时间】" + DateUtil.dateFormat(createDate) +
                "\t\t【内容】" + content + "\n";
    }

}
