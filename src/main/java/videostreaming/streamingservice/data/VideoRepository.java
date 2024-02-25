package videostreaming.streamingservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import videostreaming.streamingservice.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
