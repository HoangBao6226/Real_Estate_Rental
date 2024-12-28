package com.javaweb.util;

import com.javaweb.service.model.AccomDTO;

import java.util.List;

public class Pagination {
    private static final int ITEMS_PER_PAGE = 9;

    public List<AccomDTO> getPagedList(List<AccomDTO> accommodations, int page) {
        int fromIndex = (page - 1) * ITEMS_PER_PAGE;
        int toIndex = Math.min(fromIndex + ITEMS_PER_PAGE, accommodations.size());
        return accommodations.subList(fromIndex, toIndex);
    }

    public int getTotalPages(List<AccomDTO> accommodations) {
        return (int) Math.ceil((double) accommodations.size() / ITEMS_PER_PAGE);
    }
}
