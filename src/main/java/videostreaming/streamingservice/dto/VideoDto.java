package videostreaming.streamingservice.dto;

import java.time.LocalDateTime;

public class VideoDto {
    public Long id;

    public String ownerUserName;

    public String originalFileName;

    public String videoUrl;

    public String thumbnailImageUrl;

    public Long videoDuration;

    public String videoDescription;

    public LocalDateTime creationDateTime;

    public Long totalViews;

    public VideoDto() {}

    public VideoDto(Long id, String ownerUserName, String originalFileName, String videoUrl, String thumbnailImageUrl, Long videoDuration, String videoDescription, LocalDateTime creationDateTime, Long totalViews) {
        this.id = id;
        this.ownerUserName = ownerUserName;
        this.originalFileName = originalFileName;
        this.videoUrl = videoUrl;
        this.thumbnailImageUrl = thumbnailImageUrl;
        this.videoDuration = videoDuration;
        this.videoDescription = videoDescription;
        this.creationDateTime = creationDateTime;
        this.totalViews = totalViews;
    }
}
