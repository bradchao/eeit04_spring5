package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;
import com.example.demo.entity.Profile;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.ProfileRepository;

@Service
public class MemberProfileService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private ProfileRepository profileRepository;

	@Transactional
	public Member save(Member member, Profile profile) {
		member.setProfile(profile);
		return memberRepository.save(member);
	}
	
	@Transactional
	public Profile setProfileToMember(Long memberId, Profile profile) {
		Member m = memberRepository.findById(memberId).orElse(null);
		if (m != null) {
			m.setProfile(profile);
			profile.setMember(m);
			return profileRepository.save(profile);
		}else {
			return null;
		}
	}
	
	public Member findMemberById(Long memberId) {
		return memberRepository.findById(memberId).orElse(null);
	}
	
	
	
}
