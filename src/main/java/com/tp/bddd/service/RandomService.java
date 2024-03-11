package com.tp.bddd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RandomService {
    private final GroupService groupService;
    private final MaterialService materialService;
    private final MemberService memberService;
    private final OrderService orderService;

    public Map<String, Object> generateRandomData(int amount) {
        Map<String, Object> generatedData = new HashMap<>();
        generatedData.put("groups", groupService.generateRandomGroups(amount));
        generatedData.put("members", memberService.generateRandomMembers(amount));
        generatedData.put("materials", materialService.generateRandomMaterials(amount));
        generatedData.put("orders", orderService.generateRandomOrders(amount));
        return generatedData;
    }
}
