package com.tp.bddd.controller;

import com.tp.bddd.model.Member;
import com.tp.bddd.service.MemberService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@Tag(name = "Member", description = "Managing members of a group")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> addMember(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    @GetMapping
    public ResponseEntity<Iterable<Member>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable String id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable String id, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.updateMember(id, member));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable String id) {
        memberService.deleteMember(id);
        return ResponseEntity.noContent().build();
    }

}
