package com.example.entity;
import java.io.Serializable;

public class News implements Serializable{
	private static final long serialVersionUID = -8221467966772683998L;
	private int newsId;
	private String newsContent;
	private String newsTitle;
	private String publishTime;
	private String updateTime;

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public String getCnewsContent() {
		return newsContent;
	}

	public void setCnewsContent(String cnewsContent) {
		this.newsContent = cnewsContent;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "News{" +
				"newsId=" + newsId +
				", cnewsContent='" + newsContent + '\'' +
				", newsTitle='" + newsTitle + '\'' +
				", publishTime='" + publishTime + '\'' +
				", updateTime='" + updateTime + '\'' +
				'}';
	}
}
