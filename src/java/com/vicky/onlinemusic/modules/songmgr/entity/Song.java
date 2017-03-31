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
@Table(name = "song")
public class Song implements Serializable {

    @Id
    @Column(name = "song_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select uuid()")
    private String songId;
    @Column(name = "song_name")
    private String songName;
    @Column(name = "lyric")
    private String lyric;
    @Column(name = "create_time")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date createTime;
    @Column(name = "singer_id")
    private String singerId;
    @Column(name = "album_id")
    private String albumId;
    @Column(name = "audio_relative_path")
    private String audioRelativePath;
    @Column(name = "audio_absolute_path")
    private String audioAbsolutePath;
    @Column(name = "album_no")
    private Integer albumNo;

    /**
     * @return the songId
     */
    public String getSongId() {
        return songId;
    }

    /**
     * @param songId the songId to set
     */
    public void setSongId(String songId) {
        this.songId = songId;
    }

    /**
     * @return the songName
     */
    public String getSongName() {
        return songName;
    }

    /**
     * @param songName the songName to set
     */
    public void setSongName(String songName) {
        this.songName = songName;
    }

    /**
     * @return the lyric
     */
    public String getLyric() {
        return lyric;
    }

    /**
     * @param lyric the lyric to set
     */
    public void setLyric(String lyric) {
        this.lyric = lyric;
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
     * @return the audioRelativePath
     */
    public String getAudioRelativePath() {
        return audioRelativePath;
    }

    /**
     * @param audioRelativePath the audioRelativePath to set
     */
    public void setAudioRelativePath(String audioRelativePath) {
        this.audioRelativePath = audioRelativePath;
    }

    /**
     * @return the audioAbsolutePath
     */
    public String getAudioAbsolutePath() {
        return audioAbsolutePath;
    }

    /**
     * @param audioAbsolutePath the audioAbsolutePath to set
     */
    public void setAudioAbsolutePath(String audioAbsolutePath) {
        this.audioAbsolutePath = audioAbsolutePath;
    }

    /**
     * @return the albumNo
     */
    public Integer getAlbumNo() {
        return albumNo;
    }

    /**
     * @param albumNo the albumNo to set
     */
    public void setAlbumNo(Integer albumNo) {
        this.albumNo = albumNo;
    }
}
