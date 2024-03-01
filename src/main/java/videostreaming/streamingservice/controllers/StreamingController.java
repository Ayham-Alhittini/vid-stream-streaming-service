package videostreaming.streamingservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import videostreaming.streamingservice.data.VideoRepository;
import videostreaming.streamingservice.dto.VideoDto;
import videostreaming.streamingservice.model.Video;
import videostreaming.streamingservice.externalservices.AuthenticationService;
import videostreaming.streamingservice.utilities.Mapper;

import java.util.List;

@RestController
@RequestMapping("/api/streaming")
@CrossOrigin(origins = "*")
public class StreamingController {

    private final VideoRepository videoRepository;
    private final AuthenticationService authenticationService;

    @Autowired
    public StreamingController(VideoRepository videoRepository, AuthenticationService authenticationService) {
        this.videoRepository = videoRepository;
        this.authenticationService = authenticationService;
    }


    @GetMapping("get-all-videos")
    public ResponseEntity<List<VideoDto>> getAllVideos(HttpServletRequest request) {

        if (!authenticationService.isUserAuthenticated(request))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        List<Video> videos = videoRepository.findAllByOrderByCreationDateTimeDesc();

        List<VideoDto> videoDtos = Mapper.mapVideosToVideoDtos(videos);

        return ResponseEntity.ok(videoDtos);
    }

    @GetMapping("get-my-streams")
    public ResponseEntity<List<VideoDto>> getMyStreams(HttpServletRequest request) {
        if (!authenticationService.isUserAuthenticated(request))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        String userName = authenticationService.getUsernameFromToken(request);

        List<Video> videos = videoRepository.findAllByOwnerUserNameOrderByCreationDateTimeDesc(userName);

        List<VideoDto> videoDtos = Mapper.mapVideosToVideoDtos(videos);

        return ResponseEntity.ok(videoDtos);
    }

    @GetMapping("get-video/{videoId}")
    public ResponseEntity<VideoDto> getVideo(HttpServletRequest request, @PathVariable Long videoId) {
        if (!authenticationService.isUserAuthenticated(request))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        Video video = videoRepository.findById(videoId).orElse(null);

        if (video == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        VideoDto videoDto = Mapper.mapVideoToVideoDto(video);

        return ResponseEntity.ok(videoDto);
    }

    @PutMapping("increment-views/{videoId}")
    public ResponseEntity<Void> incrementViews(HttpServletRequest request, @PathVariable Long videoId) {

        if (!authenticationService.isUserAuthenticated(request))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        Video video = videoRepository.findById(videoId).orElse(null);
        if (video == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        video.incrementViews();

        videoRepository.save(video);

        return ResponseEntity.ok().build();
    }

}
