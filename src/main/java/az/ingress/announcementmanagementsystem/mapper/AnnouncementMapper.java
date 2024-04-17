package az.ingress.announcementmanagementsystem.mapper;

import az.ingress.announcementmanagementsystem.dto.request.AnnouncementRequest;
import az.ingress.announcementmanagementsystem.dto.response.AnnouncementResponse;
import az.ingress.announcementmanagementsystem.entity.Announcement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnnouncementMapper {
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "title", source = "announcementDetail.title")
    @Mapping(target = "description", source = "announcementDetail.description")
    @Mapping(target = "price", source = "announcementDetail.price")
    AnnouncementResponse entityToResponse(Announcement announcement);

    Announcement requestToEntity(AnnouncementRequest announcementRequest);
}
