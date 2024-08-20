package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName feed
 */
@TableName(value ="feed")
public class Feed implements Serializable {
    /**
     * id
     */
    @TableId
    private Integer titleid;

    /**
     * 名字
     */
    private String titlename;

    /**
     * 话题
     */
    private String topic;

    /**
     * 内容
     */
    private String context;

    /**
     * 作者
     */
    private String author;

    /**
     * 创作时间
     */
    private Date createdate;

    /**
     * 帖子的状态
     */
    private String status;

    /**
     * 转发数
     */
    private String referencecount;

    /**
     * 点赞数
     */
    private String likecount;

    /**
     * 类型（0,1）社区类和 个人空间类
     */
    private String type;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Integer getTitleid() {
        return titleid;
    }

    /**
     * id
     */
    public void setTitleid(Integer titleid) {
        this.titleid = titleid;
    }

    /**
     * 名字
     */
    public String getTitlename() {
        return titlename;
    }

    /**
     * 名字
     */
    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    /**
     * 话题
     */
    public String getTopic() {
        return topic;
    }

    /**
     * 话题
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * 内容
     */
    public String getContext() {
        return context;
    }

    /**
     * 内容
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 创作时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 创作时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 帖子的状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 帖子的状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 转发数
     */
    public String getReferencecount() {
        return referencecount;
    }

    /**
     * 转发数
     */
    public void setReferencecount(String referencecount) {
        this.referencecount = referencecount;
    }

    /**
     * 点赞数
     */
    public String getLikecount() {
        return likecount;
    }

    /**
     * 点赞数
     */
    public void setLikecount(String likecount) {
        this.likecount = likecount;
    }

    /**
     * 类型（0,1）社区类和 个人空间类
     */
    public String getType() {
        return type;
    }

    /**
     * 类型（0,1）社区类和 个人空间类
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Feed other = (Feed) that;
        return (this.getTitleid() == null ? other.getTitleid() == null : this.getTitleid().equals(other.getTitleid()))
            && (this.getTitlename() == null ? other.getTitlename() == null : this.getTitlename().equals(other.getTitlename()))
            && (this.getTopic() == null ? other.getTopic() == null : this.getTopic().equals(other.getTopic()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getReferencecount() == null ? other.getReferencecount() == null : this.getReferencecount().equals(other.getReferencecount()))
            && (this.getLikecount() == null ? other.getLikecount() == null : this.getLikecount().equals(other.getLikecount()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTitleid() == null) ? 0 : getTitleid().hashCode());
        result = prime * result + ((getTitlename() == null) ? 0 : getTitlename().hashCode());
        result = prime * result + ((getTopic() == null) ? 0 : getTopic().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getReferencecount() == null) ? 0 : getReferencecount().hashCode());
        result = prime * result + ((getLikecount() == null) ? 0 : getLikecount().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", titleid=").append(titleid);
        sb.append(", titlename=").append(titlename);
        sb.append(", topic=").append(topic);
        sb.append(", context=").append(context);
        sb.append(", author=").append(author);
        sb.append(", createdate=").append(createdate);
        sb.append(", status=").append(status);
        sb.append(", referencecount=").append(referencecount);
        sb.append(", likecount=").append(likecount);
        sb.append(", type=").append(type);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}