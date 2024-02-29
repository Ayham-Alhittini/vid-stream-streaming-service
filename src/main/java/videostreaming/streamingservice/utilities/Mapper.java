package videostreaming.streamingservice.utilities;


import videostreaming.streamingservice.dto.VideoDto;
import videostreaming.streamingservice.model.Video;

import java.util.List;

public class Mapper {
    public static VideoDto mapVideoToVideoDto(Video video) {
        return new VideoDto(
                video.getId(),
                video.getOwnerUserName(),
                video.getOriginalFileName(),
                video.getVideoUrl(),
                video.getThumbnailImageUrl(),
                video.getVideoDuration(),
                video.getVideoDescription(),
                video.getCreationDateTime(),
                video.getTotalViews()
        );
    }

    public static List<VideoDto> mapVideosToVideoDtos(List<Video> videos) {
        return videos.stream().map(Mapper::mapVideoToVideoDto).toList();
    }

}
