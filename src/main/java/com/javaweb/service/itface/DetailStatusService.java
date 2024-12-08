package com.javaweb.service.itface;

import java.time.LocalDateTime;

public interface DetailStatusService {

    void updateStatusAvailable(int accomID);

    void updateStatusUnavailable(int accomID);

    void updateStatusOccupied(int accomID, LocalDateTime startDate, LocalDateTime endDate);

}
