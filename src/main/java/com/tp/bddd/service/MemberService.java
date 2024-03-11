package com.tp.bddd.service;

import com.tp.bddd.model.Address;
import com.tp.bddd.model.Group;
import com.tp.bddd.model.Member;
import com.tp.bddd.model.enums.Status;
import com.tp.bddd.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final GroupService groupService;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(String id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member updateMember(String id, Member member) {
        member.setId(id);
        return memberRepository.save(member);
    }

    public void deleteMember(String id) {
        memberRepository.deleteById(id);
    }

    public List<Member> generateRandomMembers(int amount) {
        List<Member> generatedMembers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            Member member = new Member();
            member.setFirstName("First" + i);
            member.setLastName("Last" + i);
            member.setStatus(random.nextBoolean() ? Status.CLIENT : Status.SELLER);
            member.setEmail("email" + i + "@example.com");

            Address address = new Address();
            address.setNumber(i);
            address.setStreet("Street" + i);
            address.setCity("City" + i);
            address.setPostalCode(i);
            member.setAddress(address);

            setRandomGroup(member, random);

            generatedMembers.add(saveMember(member));
        }

        return generatedMembers;
    }

    private void setRandomGroup(Member member, Random random) {
        List<Group> groups = (List<Group>) groupService.getAllGroups();
        member.setGroup(groups.get(random.nextInt(groups.size())));
    }

    public List<Member> getAllMembersByStatus(Status status) {
        return memberRepository.findByStatus(status);
    }
}
