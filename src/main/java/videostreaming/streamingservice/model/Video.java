package videostreaming.streamingservice.model;

import jakarta.persistence.*;

@Table(name = "videos")
@Entity
public class Video {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerUserName;

    private String originalFileName;

    private String videoUrl;

    private String thumbnailImageUrl;

    public Video() {}

    public Video(String ownerUserName, String originalFileName, String videoUrl, String thumbnailImageUrl) {
        this.ownerUserName = ownerUserName;
        this.originalFileName = originalFileName;
        this.videoUrl = videoUrl;
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public void setOwnerUserName(String ownerUserName) {
        this.ownerUserName = ownerUserName;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getThumbnailImageUrl() {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String thumbnailImageUrl) {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }
}
