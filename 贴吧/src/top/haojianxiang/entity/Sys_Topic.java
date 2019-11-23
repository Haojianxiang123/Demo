package top.haojianxiang.entity;

import top.haojianxiang.util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * @Author 郝健祥
 * @Date 2019-11-18 17:50
 * @Description 贴吧表
 * @Version 1.0
 */
public class Sys_Topic {
    private int topicId;
    private String title;
    private String content;
    private String author;
    private Date createDate;
    private int clickAmount;
    private List<Sys_Reply> replyList;  // 该帖子的评论

    public Sys_Topic() {
    }

    public Sys_Topic(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.createDate = new Date();
        this.clickAmount = 0;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getClickAmount() {
        return clickAmount;
    }

    public void setClickAmount(int clickAmount) {
        this.clickAmount = clickAmount;
    }

    public List<Sys_Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Sys_Reply> replyList) {
        this.replyList = replyList;
    }

    /**
     * 得到该帖子的评论信息的字符串格式
     * @return 该帖子的评论信息的字符串格式
     */
    public String getrReply(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Sys_Reply reply : replyList) {
            stringBuilder.append(reply);
        }
        return stringBuilder.toString();
    }

    /**
     * 查看帖子信息列表
     * @return 帖子信息列表字符串格式
     */
    @Override
    public String toString() {
        return  "【帖子编号】" + topicId +
                "\t【标题】" + title +
                "\t\t\t【作者】" + author +
                "\t\t\t【发帖时间】" + DateUtil.dateFormat(createDate) +
                "\t\t\t【访问量】" + clickAmount;

    }

    /**
     * 查看帖子详细信息
     * @return 帖子详细信息字符串格式
     */
    public String toString_m() {
        return  "【帖子编号】" + topicId +
                "\n【标题】" + title +
                "\n【作者】" + author +
                "\n【发帖时间】" + DateUtil.dateFormat(createDate) +
                "\n【访问量】" + clickAmount +
                "\n【内容】" + content +
                "\n【评论】 \n" + getrReply();
    }
}
