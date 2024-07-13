package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName comic
 */
@Getter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@TableName(value ="comic")
public class Comic implements Serializable {
    /**
     * 漫画id
     * -- GETTER --
     *  漫画id

     */
    @TableId
    private Integer comicid;

    /**
     * 名字
     * -- GETTER --
     *  名字

     */
    private String title;

    /**
     * 作者
     * -- GETTER --
     *  作者

     */
    private String author;

    /**
     * 简介描述
     * -- GETTER --
     *  简介描述

     */
    private String description;

    /**
     * 封面
     * -- GETTER --
     *  封面

     */
    private String coverimage;

    /**
     * 标签
     * -- GETTER --
     *  标签

     */
    private String tags;

    /**
     * 状态
     * -- GETTER --
     *  状态

     */
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 漫画id
     */
    public void setComicid(Integer comicid) {
        this.comicid = comicid;
    }

    /**
     * 名字
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 简介描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 封面
     */
    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }

    /**
     * 标签
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 状态
     */
    public void setStatus(String status) {
        this.status = status;
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
        Comic other = (Comic) that;
        return (this.getComicid() == null ? other.getComicid() == null : this.getComicid().equals(other.getComicid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCoverimage() == null ? other.getCoverimage() == null : this.getCoverimage().equals(other.getCoverimage()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getComicid() == null) ? 0 : getComicid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCoverimage() == null) ? 0 : getCoverimage().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", comicid=").append(comicid);
        sb.append(", title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", description=").append(description);
        sb.append(", coverimage=").append(coverimage);
        sb.append(", tags=").append(tags);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}