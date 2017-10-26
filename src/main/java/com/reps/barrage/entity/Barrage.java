package com.reps.barrage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.reps.core.orm.IdEntity;

/**
 * 弹幕实体
 * @author qianguobing
 * @date 2017年10月25日 下午2:59:41
 */
@Entity
@Table(name = "reps_barrage")
public class Barrage extends IdEntity implements Serializable{

	private static final long serialVersionUID = 5363563353576213531L;
	
	/** 弹幕内容的时间点 */
	@Column(name = "nt")
	private Integer nt;
	
	/** 弹幕内容 */
	@Column(name = "content", length = 100)
	private String content;
	
	/** 视频标识 */
	@Column(name = "video_id", length = 32)
	private String videoId;
	
	/** 创建时间 */
	@Column(name = "createTime")
	private Date createTime;

	public Integer getNt() {
		return nt;
	}

	public void setNt(Integer nt) {
		this.nt = nt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Barrage [nt=" + nt + ", content=" + content + ", videoId=" + videoId + ", createTime=" + createTime + "]";
	}
	
}
