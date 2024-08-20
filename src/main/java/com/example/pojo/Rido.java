package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName rido
 */
@TableName(value ="rido")
public class Rido implements Serializable {
    /**
     * 广播剧
     */
    @TableId
    private Integer ridoid;

    /**
     * 广播剧名字
     */
    private String ridoname;

    /**
     * 广播剧地址
     */
    private String ridourl;

    /**
     * 状态
     */
    private String ridostaus;

    /**
     * 简介
     */
    private String ridocontext;

    /**
     * 种类
     */
    private Integer ridotype;

    /**
     * 是否vip
     */
    private Integer ridoisvip;

    /**
     * 导演或者作者
     */
    private String ridoauthor;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 广播剧
     */
    public Integer getRidoid() {
        return ridoid;
    }

    /**
     * 广播剧
     */
    public void setRidoid(Integer ridoid) {
        this.ridoid = ridoid;
    }

    /**
     * 广播剧名字
     */
    public String getRidoname() {
        return ridoname;
    }

    /**
     * 广播剧名字
     */
    public void setRidoname(String ridoname) {
        this.ridoname = ridoname;
    }

    /**
     * 广播剧地址
     */
    public String getRidourl() {
        return ridourl;
    }

    /**
     * 广播剧地址
     */
    public void setRidourl(String ridourl) {
        this.ridourl = ridourl;
    }

    /**
     * 状态
     */
    public String getRidostaus() {
        return ridostaus;
    }

    /**
     * 状态
     */
    public void setRidostaus(String ridostaus) {
        this.ridostaus = ridostaus;
    }

    /**
     * 简介
     */
    public String getRidocontext() {
        return ridocontext;
    }

    /**
     * 简介
     */
    public void setRidocontext(String ridocontext) {
        this.ridocontext = ridocontext;
    }

    /**
     * 种类
     */
    public Integer getRidotype() {
        return ridotype;
    }

    /**
     * 种类
     */
    public void setRidotype(Integer ridotype) {
        this.ridotype = ridotype;
    }

    /**
     * 是否vip
     */
    public Integer getRidoisvip() {
        return ridoisvip;
    }

    /**
     * 是否vip
     */
    public void setRidoisvip(Integer ridoisvip) {
        this.ridoisvip = ridoisvip;
    }

    /**
     * 导演或者作者
     */
    public String getRidoauthor() {
        return ridoauthor;
    }

    /**
     * 导演或者作者
     */
    public void setRidoauthor(String ridoauthor) {
        this.ridoauthor = ridoauthor;
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
        Rido other = (Rido) that;
        return (this.getRidoid() == null ? other.getRidoid() == null : this.getRidoid().equals(other.getRidoid()))
            && (this.getRidoname() == null ? other.getRidoname() == null : this.getRidoname().equals(other.getRidoname()))
            && (this.getRidourl() == null ? other.getRidourl() == null : this.getRidourl().equals(other.getRidourl()))
            && (this.getRidostaus() == null ? other.getRidostaus() == null : this.getRidostaus().equals(other.getRidostaus()))
            && (this.getRidocontext() == null ? other.getRidocontext() == null : this.getRidocontext().equals(other.getRidocontext()))
            && (this.getRidotype() == null ? other.getRidotype() == null : this.getRidotype().equals(other.getRidotype()))
            && (this.getRidoisvip() == null ? other.getRidoisvip() == null : this.getRidoisvip().equals(other.getRidoisvip()))
            && (this.getRidoauthor() == null ? other.getRidoauthor() == null : this.getRidoauthor().equals(other.getRidoauthor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRidoid() == null) ? 0 : getRidoid().hashCode());
        result = prime * result + ((getRidoname() == null) ? 0 : getRidoname().hashCode());
        result = prime * result + ((getRidourl() == null) ? 0 : getRidourl().hashCode());
        result = prime * result + ((getRidostaus() == null) ? 0 : getRidostaus().hashCode());
        result = prime * result + ((getRidocontext() == null) ? 0 : getRidocontext().hashCode());
        result = prime * result + ((getRidotype() == null) ? 0 : getRidotype().hashCode());
        result = prime * result + ((getRidoisvip() == null) ? 0 : getRidoisvip().hashCode());
        result = prime * result + ((getRidoauthor() == null) ? 0 : getRidoauthor().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ridoid=").append(ridoid);
        sb.append(", ridoname=").append(ridoname);
        sb.append(", ridourl=").append(ridourl);
        sb.append(", ridostaus=").append(ridostaus);
        sb.append(", ridocontext=").append(ridocontext);
        sb.append(", ridotype=").append(ridotype);
        sb.append(", ridoisvip=").append(ridoisvip);
        sb.append(", ridoauthor=").append(ridoauthor);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}