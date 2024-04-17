package az.ingress.announcementmanagementsystem.repository;

import az.ingress.announcementmanagementsystem.entity.AnnouncementDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementDetailRepository extends JpaRepository<AnnouncementDetail, Long> {
}
