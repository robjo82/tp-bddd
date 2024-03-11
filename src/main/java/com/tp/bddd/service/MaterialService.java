package com.tp.bddd.service;

import com.tp.bddd.model.Group;
import com.tp.bddd.model.Material;
import com.tp.bddd.model.Member;
import com.tp.bddd.model.enums.MaterialType;
import com.tp.bddd.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MaterialService {
    private final MaterialRepository materialRepository;
    private final GroupService groupService;

    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    public Iterable<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Material getMaterialById(String id) {
        return materialRepository.findById(id).orElse(null);
    }

    public Material updateMaterial(String id, Material material) {
        material.setId(id);
        return materialRepository.save(material);
    }

    public void deleteMaterial(String id) {
        materialRepository.deleteById(id);
    }

    public List<Material> generateRandomMaterials(int amount) {
        List<Material> generatedMaterials = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            Material material = new Material();
            material.setPrice(random.nextDouble() * 100);
            material.setType(MaterialType.values()[random.nextInt(MaterialType.values().length)]);
            material.setModel("Model" + random.nextInt(100));
            material.setBrand("Brand" + random.nextInt(100));
            material.setSerialNumber("Serial" + random.nextInt(100));

            setRandomGroup(material, random);
            generatedMaterials.add(saveMaterial(material));
        }

        return generatedMaterials;
    }

    private void setRandomGroup(Material member, Random random) {
        List<Group> groups = (List<Group>) groupService.getAllGroups();
        member.setGroup(groups.get(random.nextInt(groups.size())));
    }
}
