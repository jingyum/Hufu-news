package generator.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;


public class News implements Serializable {
    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private Date time;

    /**
     * 
     */
    private String author;

    /**
     * 
     */
    private String sourceWeb;

    /**
     * 
     */
    private String originalUrl;

    /**
     * 
     */
    private String summary;

    /**
     * 
     */
    private String details;

    /**
     * 
     */
    private String keyWord;

    /**
     * 
     */
    private String originalUrlMd5;

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     */
    public Date getTime() {
        return time;
    }

    /**
     * 
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     */
    public String getSourceWeb() {
        return sourceWeb;
    }

    /**
     * 
     */
    public void setSourceWeb(String sourceWeb) {
        this.sourceWeb = sourceWeb;
    }

    /**
     * 
     */
    public String getOriginalUrl() {
        return originalUrl;
    }

    /**
     * 
     */
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    /**
     * 
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * 
     */
    public String getDetails() {
        return details;
    }

    /**
     * 
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * 
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * 
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * 
     */
    public String getOriginalUrlMd5() {
        return originalUrlMd5;
    }

    /**
     * 
     */
    public void setOriginalUrlMd5(String originalUrlMd5) {
        this.originalUrlMd5 = originalUrlMd5;
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
        News other = (News) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
            && (this.getSourceWeb() == null ? other.getSourceWeb() == null : this.getSourceWeb().equals(other.getSourceWeb()))
            && (this.getOriginalUrl() == null ? other.getOriginalUrl() == null : this.getOriginalUrl().equals(other.getOriginalUrl()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getDetails() == null ? other.getDetails() == null : this.getDetails().equals(other.getDetails()))
            && (this.getKeyWord() == null ? other.getKeyWord() == null : this.getKeyWord().equals(other.getKeyWord()))
            && (this.getOriginalUrlMd5() == null ? other.getOriginalUrlMd5() == null : this.getOriginalUrlMd5().equals(other.getOriginalUrlMd5()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
        result = prime * result + ((getSourceWeb() == null) ? 0 : getSourceWeb().hashCode());
        result = prime * result + ((getOriginalUrl() == null) ? 0 : getOriginalUrl().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getDetails() == null) ? 0 : getDetails().hashCode());
        result = prime * result + ((getKeyWord() == null) ? 0 : getKeyWord().hashCode());
        result = prime * result + ((getOriginalUrlMd5() == null) ? 0 : getOriginalUrlMd5().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", time=").append(time);
        sb.append(", author=").append(author);
        sb.append(", sourceWeb=").append(sourceWeb);
        sb.append(", originalUrl=").append(originalUrl);
        sb.append(", summary=").append(summary);
        sb.append(", details=").append(details);
        sb.append(", keyWord=").append(keyWord);
        sb.append(", originalUrlMd5=").append(originalUrlMd5);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}