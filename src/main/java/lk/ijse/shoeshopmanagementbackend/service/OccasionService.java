package lk.ijse.shoeshopmanagementbackend.service;

import lk.ijse.shoeshopmanagementbackend.dto.OccasionDTO;

import java.util.List;

public interface OccasionService {
    void saveOccasion(OccasionDTO occasionDTO);

    List<OccasionDTO> getAllOccasion();

    void deleteOccasion(String id);

    void updateOccasion(String id, OccasionDTO occasionDTO);
}
