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
@Table(name = "album")
public class Album implements Serializable {

    @Id
    @Column(name = "album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private String albumId;
    @Column(name = "album_name")
    private String albumName;
    @Column(name = "album_explain")
    private String albumExplain;
    @Column(name = "cover_relative_path")
    private String coverRelativePath;
    @Column(name = "cover_absolute_path")
    private String coverAbsolutePath;
    @Column(name = "singer_id")
    private String singerId;
    @Column(name = "create_time")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * @return the albumId
     */
    public String getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId the albumId to set
     */
    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    /**
     * @return the albumName
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * @param albumName the albumName to set
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    /**
     * @return the albumExplain
     */
    public String getAlbumExplain() {
        return albumExplain;
    }

    /**
     * @param albumExplain the albumExplain to set
     */
    public void setAlbumExplain(String albumExplain) {
        this.albumExplain = albumExplain;
    }

    /**
     * @return the coverRelativePath
     */
    public String getCoverRelativePath() {
        return coverRelativePath;
    }

    /**
     * @param coverRelativePath the coverRelativePath to set
     */
    public void setCoverRelativePath(String coverRelativePath) {
        this.coverRelativePath = coverRelativePath;
    }

    /**
     * @return the coverAbsolutePath
     */
    public String getCoverAbsolutePath() {
        return coverAbsolutePath;
    }

    /**
     * @param coverAbsolutePath the coverAbsolutePath to set
     */
    public void setCoverAbsolutePath(String coverAbsolutePath) {
        this.coverAbsolutePath = coverAbsolutePath;
    }

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
