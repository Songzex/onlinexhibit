package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName chapter
 */
@TableName(value ="chapter")
public class Chapter implements Serializable {
    /**
     * id
     */
    @TableId
    private Integer chapterid;

    /**
     * 所属漫画id
     */
    private Integer comicid;

    /**
     * 章节名字
     */
    private String title;

    /**
     * 是否支付
     */
    private String ispay;

    /**
     * 漫画Url
     */
    private String imgurl;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Integer getChapterid() {
        return chapterid;
    }

    /**
     * id
     */
    public void setChapterid(Integer chapterid) {
        this.chapterid = chapterid;
    }

    /**
     * 所属漫画id
     */
    public Integer getComicid() {
        return comicid;
    }

    /**
     * 所属漫画id
     */
    public void setComicid(Integer comicid) {
        this.comicid = comicid;
    }

    /**
     * 章节名字
     */
    public String getTitle() {
        return title;
    }

    /**
     * 章节名字
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 是否支付
     */
    public String getIspay() {
        return ispay;
    }

    /**
     * 是否支付
     */
    public void setIspay(String ispay) {
        this.ispay = ispay;
    }

    /**
     * 漫画Url
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * 漫画Url
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
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
        Chapter other = (Chapter) that;
        return (this.getChapterid() == null ? other.getChapterid() == null : this.getChapterid().equals(other.getChapterid()))
            && (this.getComicid() == null ? other.getComicid() == null : this.getComicid().equals(other.getComicid()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getIspay() == null ? other.getIspay() == null : this.getIspay().equals(other.getIspay()))
            && (this.getImgurl() == null ? other.getImgurl() == null : this.getImgurl().equals(other.getImgurl()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getChapterid() == null) ? 0 : getChapterid().hashCode());
        result = prime * result + ((getComicid() == null) ? 0 : getComicid().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getIspay() == null) ? 0 : getIspay().hashCode());
        result = prime * result + ((getImgurl() == null) ? 0 : getImgurl().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", chapterid=").append(chapterid);
        sb.append(", comicid=").append(comicid);
        sb.append(", title=").append(title);
        sb.append(", ispay=").append(ispay);
        sb.append(", imgurl=").append(imgurl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}