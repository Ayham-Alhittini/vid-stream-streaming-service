package videostreaming.streamingservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    private Long videoDuration;

    private String videoDescription;

    private LocalDateTime creationDateTime;

    private Long totalViews;

    public Video() {}

    public Video(String ownerUserName, String originalFileName, String videoUrl, String thumbnailImageUrl, Long videoDuration, String videoDescription) {
        this.ownerUserName = ownerUserName;
        this.originalFileName = originalFileName;
        this.videoUrl = videoUrl;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.videoDuration = videoDuration;
        this.videoDescription = videoDescription;
        this.creationDateTime = LocalDateTime.now();
        this.totalViews = 0L;
    }

    public void incrementViews() {
        totalViews++;
    }

    public Long getId() {
        return id;
    }

    public String getOwnerUserName() {
        return ownerUserName;
    }

    public Long getVideoDuration() {
        return videoDuration;
    }

    public String getVideoDescription() {
        return videoDescription;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public Long getTotalViews() {
        return totalViews;
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

    public void setVideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
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
