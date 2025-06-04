package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.MemberProfileService;
import com.example.demo.entity.Member;
import com.example.demo.entity.Profile;

@RestController
@RequestMapping("/api")
public class MemberProfileController {

	@Autowired
	private MemberProfileService service;
	
	/**
	 * POST /api/member
	 * 同時新增 member + profile
	 */
	@PostMapping("/member")
	public ResponseEntity<Member> addMember(
			@RequestBody Map<String,Object> data){
		
		Member m = new Member();
		m.setEmail((String)data.get("email"));
		m.setPasswd((String)data.get("passwd"));
		
		Profile p = null;
		Map<String,Object> proData = (Map<String,Object>)(data.get("profile"));
		if (proData != null) {
			p = new Profile();
			p.setCname((String)proData.get("cname"));
			p.setAge((Integer)proData.get("age"));
			
			m.setProfile(p);
		}
		
		Member saveMember = service.save(m, p);
		
		return ResponseEntity.ok(saveMember);
	}
	
	@RequestMapping("/member/{id}/profile")
	public ResponseEntity<Profile> addProfile(
			@PathVariable Long id,
			@RequestBody Map<String,Object> data
			){
		
		Map<String,Object> proData = (Map<String,Object>)data;
		Profile p = new Profile();
		p.setCname((String)proData.get("cname"));
		p.setAge((Integer)proData.get("age"));	
		
		Profile profile = service.setProfileToMember(id, p);
		
		
		return ResponseEntity.ok(profile);
	}
	
	
	@GetMapping("/member/query/{id}")
	public ResponseEntity<Member> queryMember(@PathVariable Long id){
		Member member = service.findMemberById(id);
		return ResponseEntity.ok(member);
	}
	
	
	
	
}
