package com.vti.kshop.service;

import com.vti.kshop.dto.AccessoryDto;
import com.vti.kshop.form.AccessoryCreateform;
import com.vti.kshop.form.AccessoryUpdateform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccessoryService {
    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto findById(Long id);

    AccessoryDto create(AccessoryCreateform form);

    AccessoryDto update(Long id, AccessoryUpdateform form);

    void deleteById(Long id);
}
