package com.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;

import java.io.Serializable;

/**
 * 好友关系表
 * @author 24022
 * @TableName usercon
 */
@Getter
@TableName(value ="usercon")
public class Usercon implements Serializable {
    /**
     * 自增主键id
     * -- GETTER --
     *  自增主键id

     */
    @TableId
    private Integer cid;

    /**
     * 好友id
     * -- GETTER --
     *  好友id

     */
    private Integer friemsid;

    /**
     * 用户id
     * -- GETTER --
     *  用户id

     */
    private Integer userid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键id
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 好友id
     */
    public void setFriemsid(Integer friemsid) {
        this.friemsid = friemsid;
    }

    /**
     * 用户id
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
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
        Usercon other = (Usercon) that;
        return (this.getCid() == null ? other.getCid() == null : this.getCid().equals(other.getCid()))
            && (this.getFriemsid() == null ? other.getFriemsid() == null : this.getFriemsid().equals(other.getFriemsid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCid() == null) ? 0 : getCid().hashCode());
        result = prime * result + ((getFriemsid() == null) ? 0 : getFriemsid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cid=").append(cid);
        sb.append(", friemsid=").append(friemsid);
        sb.append(", userid=").append(userid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}