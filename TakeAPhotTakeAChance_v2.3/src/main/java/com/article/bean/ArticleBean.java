package com.article.bean;

public class ArticleBean implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String articleID;
	private String articleTitle;
	private String articleContent;
	private String postDate;
	private String memberId;
	private String memberName;
	private String articleLikes;
	private String articleCollect;
	private String articleState;
	private String hashtag;
	
	public ArticleBean() {
		super();
	}
	
	public String getArticleID() { return articleID; }
	public String getArticleTitle() { return articleTitle; }
	public String getArticleContent() { return articleContent; }
	public String getPostDate() { return postDate; }
	public String getMemberId() { return memberId; }
	public String getMemberName() { return memberName; }
	public String getArticleLikes() { return articleLikes; }
	public String getArticleCollect() { return articleCollect; }
	public String getArticleState() { return articleState; }
	public String getHashtag() { return hashtag; }

	public void setArticleID(String articleID) { this.articleID = articleID; }
	public void setArticleTitle(String articleTitle) { this.articleTitle = articleTitle; }
	public void setArticleContent(String articleContent) { this.articleContent = articleContent; }
	public void setPostDate(String postDate) { this.postDate = postDate; }
	public void setMemberId(String memberId) { this.memberId = memberId; }
	public void setMemberName(String memberName) { this.memberName = memberName; }
	public void setArticleLikes(String articleLikes) { this.articleLikes = articleLikes; }
	public void setArticleCollect(String articleCollect) { this.articleCollect = articleCollect; }
	public void setArticleState(String articleState) { this.articleState = articleState; }
	public void setHashtag(String hashtag) { this.hashtag = hashtag; }


	
}
