package com.tp.bddd.service;


import com.tp.bddd.model.Group;
import com.tp.bddd.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    public Iterable<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public Group getGroupById(String id) {
        return groupRepository.findById(id).orElse(null);
    }

    public Group updateGroup(String id, Group group) {
        group.setId(id);
        return groupRepository.save(group);
    }

    public void deleteGroup(String id) {
        groupRepository.deleteById(id);
    }

    public List<Group> generateRandomGroups(int amount) {
        List<Group> generatedMembers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            Group group = new Group();
            group.setName("Group" + random);
            group.setCity("City" + random);
            group.setPostalCode(random.nextInt(10000) + 10000);

            generatedMembers.add(saveGroup(group));
        }

        return generatedMembers;
    }
}
