/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vicky.onlinemusic.modules.collectmgr.entity;

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
@Table(name = "collect_song")
public class CollectSong implements Serializable {

    @Id
    @Column(name = "collect_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private String collectId;
    @Column(name = "collect_username")
    private String collectUsername;
    @Column(name = "collect_song_id")
    private String collectSongId;
    @Column(name = "create_time")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * @return the collectId
     */
    public String getCollectId() {
        return collectId;
    }

    /**
     * @param collectId the collectId to set
     */
    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    /**
     * @return the collectUsername
     */
    public String getCollectUsername() {
        return collectUsername;
    }

    /**
     * @param collectUsername the collectUsername to set
     */
    public void setCollectUsername(String collectUsername) {
        this.collectUsername = collectUsername;
    }

    /**
     * @return the collectSongId
     */
    public String getCollectSongId() {
        return collectSongId;
    }

    /**
     * @param collectSongId the collectSongId to set
     */
    public void setCollectSongId(String collectSongId) {
        this.collectSongId = collectSongId;
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
