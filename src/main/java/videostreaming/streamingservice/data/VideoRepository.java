package videostreaming.streamingservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import videostreaming.streamingservice.model.Video;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByOrderByCreationDateTimeDesc();
    List<Video> findAllByOwnerUserNameOrderByCreationDateTimeDesc(String ownerUserName);
}
