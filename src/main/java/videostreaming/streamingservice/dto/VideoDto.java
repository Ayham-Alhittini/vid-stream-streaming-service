package videostreaming.streamingservice.dto;

public class VideoDto {
    public Long id;

    public String ownerUserName;

    public String originalFileName;

    public String videoUrl;

    public String thumbnailImageUrl;

    public VideoDto() {}

    public VideoDto(Long id, String ownerUserName, String originalFileName, String videoUrl, String thumbnailImageUrl) {
        this.id = id;
        this.ownerUserName = ownerUserName;
        this.originalFileName = originalFileName;
        this.videoUrl = videoUrl;
        this.thumbnailImageUrl = thumbnailImageUrl;
    }
}
