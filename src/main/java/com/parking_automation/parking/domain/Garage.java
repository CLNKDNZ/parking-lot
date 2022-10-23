package com.parking_automation.parking.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class Garage {
    private final int SLOT_COUNT = 11;
    private final String SLOT_NAME_CONS = "P";
    private Map<String, Slot> slotMap;

    public Garage() {
        //Init empty garage map
        slotMap = new HashMap<>();
        for (int i = 1; i < SLOT_COUNT; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            var slotName = stringBuilder.append(SLOT_NAME_CONS).append(i).toString();
            slotMap.put(slotName, new Slot(i));
        }
    }
}
