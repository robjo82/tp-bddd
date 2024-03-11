package com.tp.bddd.controller;

import com.tp.bddd.model.Group;
import com.tp.bddd.service.GroupService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@Tag(name = "Group", description = "Managing groups of members")
public class GroupController {
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<Group> addGroup(@RequestBody Group group) {
        return ResponseEntity.ok(groupService.saveGroup(group));
    }

    @GetMapping
    public ResponseEntity<Iterable<Group>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable String id) {
        return ResponseEntity.ok(groupService.getGroupById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable String id, @RequestBody Group group) {
        return ResponseEntity.ok(groupService.updateGroup(id, group));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable String id) {
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }
}
