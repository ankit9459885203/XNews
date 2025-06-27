package com.crio.xnews;

// TODO: CRIO_TASK_MODULE_PROJECT
// Declare variables for the fields: "title","description","author","url","publishedAt" & "content." Ignore any other fields.
// Utilize your IDE to generate getters and setters for these variables.
// Use your IDE to generate the toString method to create a string representation of the variables.
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)


public class NewsArticle {

    private String title;
    private String description;
    private String author;
    private String  url;
    private String publishedAt;
    private  String content;


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPublishedAt() {
        return publishedAt;
    }
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    
    @Override
    public String toString() {
        return "NewsArticle [author=" + author + ", content=" + content + ", description="
                + description + ", publishedAt=" + publishedAt + ", title=" + title + ", url=" + url
                + "]";
    }
    

    
}
