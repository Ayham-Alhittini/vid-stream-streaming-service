package videostreaming.streamingservice.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import videostreaming.streamingservice.data.VideoRepository;
import videostreaming.streamingservice.dto.VideoDto;
import videostreaming.streamingservice.model.Video;
import videostreaming.streamingservice.serviceintegrations.AuthenticationService;
import videostreaming.streamingservice.utilities.Mapper;

import java.util.List;

@RestController
@RequestMapping("/api/streaming")
public class StreamingController {

    private final VideoRepository videoRepository;
    private final AuthenticationService authenticationService;

    @Autowired
    public StreamingController(VideoRepository videoRepository, AuthenticationService authenticationService) {
        this.videoRepository = videoRepository;
        this.authenticationService = authenticationService;
    }


    @GetMapping
    public ResponseEntity<List<VideoDto>> getAllVideos(HttpServletRequest request) {

        if (!authenticationService.isUserAuthenticated(request))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);

        List<Video> videos = videoRepository.findAll();

        List<VideoDto> videoDtos = Mapper.mapVideosToVideoDtos(videos);

        return ResponseEntity.ok(videoDtos);
    }
}
