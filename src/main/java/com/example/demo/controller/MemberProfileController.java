package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		
		Map<String,Object> proData = (Map<String,Object>)(data.get("profile"));
		Profile p = new Profile();
		p.setCname((String)proData.get("cname"));
		p.setAge((Integer)proData.get("age"));
		
		m.setProfile(p);
		
		Member saveMember = service.save(m, p);
		
		return ResponseEntity.ok(saveMember);
	}
	
	
}
