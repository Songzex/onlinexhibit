package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName novles
 */
@TableName(value ="novles")
public class Novles implements Serializable {
    /**
     * 小说id
     */
    @TableId(type = IdType.AUTO)
    private Integer novleid;

    /**
     * 封面
     */
    private String novleimg;

    /**
     * 内容简介
     */
    private String novlecontext;

    /**
     * 类型
     */
    private String novletype;

    /**
     * 状态
     */
    private String novlestatus;

    /**
     * 作者
     */
    private String novleaurthor;

    /**
     * 名字
     */
    private String novlename;

    /**
     * 创建时间
     */
    private Date createdate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 小说id
     */
    public Integer getNovleid() {
        return novleid;
    }

    /**
     * 小说id
     */
    public void setNovleid(Integer novleid) {
        this.novleid = novleid;
    }

    /**
     * 封面
     */
    public String getNovleimg() {
        return novleimg;
    }

    /**
     * 封面
     */
    public void setNovleimg(String novleimg) {
        this.novleimg = novleimg;
    }

    /**
     * 内容简介
     */
    public String getNovlecontext() {
        return novlecontext;
    }

    /**
     * 内容简介
     */
    public void setNovlecontext(String novlecontext) {
        this.novlecontext = novlecontext;
    }

    /**
     * 类型
     */
    public String getNovletype() {
        return novletype;
    }

    /**
     * 类型
     */
    public void setNovletype(String novletype) {
        this.novletype = novletype;
    }

    /**
     * 状态
     */
    public String getNovlestatus() {
        return novlestatus;
    }

    /**
     * 状态
     */
    public void setNovlestatus(String novlestatus) {
        this.novlestatus = novlestatus;
    }

    /**
     * 作者
     */
    public String getNovleaurthor() {
        return novleaurthor;
    }

    /**
     * 作者
     */
    public void setNovleaurthor(String novleaurthor) {
        this.novleaurthor = novleaurthor;
    }

    /**
     * 名字
     */
    public String getNovlename() {
        return novlename;
    }

    /**
     * 名字
     */
    public void setNovlename(String novlename) {
        this.novlename = novlename;
    }

    /**
     * 创建时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
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
        Novles other = (Novles) that;
        return (this.getNovleid() == null ? other.getNovleid() == null : this.getNovleid().equals(other.getNovleid()))
            && (this.getNovleimg() == null ? other.getNovleimg() == null : this.getNovleimg().equals(other.getNovleimg()))
            && (this.getNovlecontext() == null ? other.getNovlecontext() == null : this.getNovlecontext().equals(other.getNovlecontext()))
            && (this.getNovletype() == null ? other.getNovletype() == null : this.getNovletype().equals(other.getNovletype()))
            && (this.getNovlestatus() == null ? other.getNovlestatus() == null : this.getNovlestatus().equals(other.getNovlestatus()))
            && (this.getNovleaurthor() == null ? other.getNovleaurthor() == null : this.getNovleaurthor().equals(other.getNovleaurthor()))
            && (this.getNovlename() == null ? other.getNovlename() == null : this.getNovlename().equals(other.getNovlename()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNovleid() == null) ? 0 : getNovleid().hashCode());
        result = prime * result + ((getNovleimg() == null) ? 0 : getNovleimg().hashCode());
        result = prime * result + ((getNovlecontext() == null) ? 0 : getNovlecontext().hashCode());
        result = prime * result + ((getNovletype() == null) ? 0 : getNovletype().hashCode());
        result = prime * result + ((getNovlestatus() == null) ? 0 : getNovlestatus().hashCode());
        result = prime * result + ((getNovleaurthor() == null) ? 0 : getNovleaurthor().hashCode());
        result = prime * result + ((getNovlename() == null) ? 0 : getNovlename().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", novleid=").append(novleid);
        sb.append(", novleimg=").append(novleimg);
        sb.append(", novlecontext=").append(novlecontext);
        sb.append(", novletype=").append(novletype);
        sb.append(", novlestatus=").append(novlestatus);
        sb.append(", novleaurthor=").append(novleaurthor);
        sb.append(", novlename=").append(novlename);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}