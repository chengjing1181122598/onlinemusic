/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.songmgr.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Vicky
 */
@Entity
@Table(name = "singer")
public class Singer implements Serializable {

    @Id
    @Column(name = "singer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private String singerId;
    @Column(name = "singer_name")
    private String singerName;
    @Column(name = "singer_explain")
    private String singerExplain;
    @Column(name = "photo_relative_path")
    private String photoRelativePath;
    @Column(name = "photo_absolute_path")
    private String photoAbsolutePath;
    @Column(name = "create_time")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * @return the singerId
     */
    public String getSingerId() {
        return singerId;
    }

    /**
     * @param singerId the singerId to set
     */
    public void setSingerId(String singerId) {
        this.singerId = singerId;
    }

    /**
     * @return the singerName
     */
    public String getSingerName() {
        return singerName;
    }

    /**
     * @param singerName the singerName to set
     */
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    /**
     * @return the singerExplain
     */
    public String getSingerExplain() {
        return singerExplain;
    }

    /**
     * @param singerExplain the singerExplain to set
     */
    public void setSingerExplain(String singerExplain) {
        this.singerExplain = singerExplain;
    }

    /**
     * @return the photoRelativePath
     */
    public String getPhotoRelativePath() {
        return photoRelativePath;
    }

    /**
     * @param photoRelativePath the photoRelativePath to set
     */
    public void setPhotoRelativePath(String photoRelativePath) {
        this.photoRelativePath = photoRelativePath;
    }

    /**
     * @return the photoAbsolutePath
     */
    public String getPhotoAbsolutePath() {
        return photoAbsolutePath;
    }

    /**
     * @param photoAbsolutePath the photoAbsolutePath to set
     */
    public void setPhotoAbsolutePath(String photoAbsolutePath) {
        this.photoAbsolutePath = photoAbsolutePath;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
