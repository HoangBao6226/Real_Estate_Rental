package com.javaweb.service.converter;

import com.javaweb.repository.itface.AdvantageRepository;
import com.javaweb.entity.*;
import com.javaweb.service.model.AccomTypeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccomTypeConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AdvantageRepository advanRepository;

    public AccomTypeDTO toAccomTypeDTO (AccomTypeEntity item) {

        AccomTypeDTO ac = modelMapper.map(item, AccomTypeDTO.class);

        List<AdvantageEntity> ad = advanRepository.findAllByaccomTypeID(item);

        String code = ad.stream().map(it -> it.getCode()).collect(Collectors.joining(", "));
        String[] adCodeArray = code.split(",");
        ac.setAdCode(adCodeArray);

        String des = ad.stream().map(it -> it.getDescription()).collect(Collectors.joining("# "));
        String[] adDesArray = des.split("#");
        ac.setAdDes(adDesArray);

        return ac;
    }
}
