package com.tp.bddd.controller;

import com.tp.bddd.service.MaterialService;
import com.tp.bddd.model.Material;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materials")
@RequiredArgsConstructor
@Tag(name = "Material", description = "Managing materials")
public class MaterialController {

    private final MaterialService materialService;

    @PostMapping
    public ResponseEntity<Material> addMaterial(@RequestBody Material material) {
        return ResponseEntity.ok(materialService.saveMaterial(material));
    }

    @GetMapping
    public ResponseEntity<Iterable<Material>> getAllMaterials() {
        return ResponseEntity.ok(materialService.getAllMaterials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable String id) {
        return ResponseEntity.ok(materialService.getMaterialById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable String id, @RequestBody Material material) {
        return ResponseEntity.ok(materialService.updateMaterial(id, material));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable String id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
