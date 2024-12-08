package com.javaweb.service.itface;


import com.javaweb.service.model.DetailRTDTO;

public interface DetailRTService {

    DetailRTDTO findByAccomIDAndRTName(int accomID, String rTName);


}
