package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Member;

public interface MemberRepository 
	extends JpaRepository<Member, Long>{
	
	/*
	 * 動詞 + By + 屬性名稱
	 * findByEmail(String email) => Optional<Member>
	 * findAllByAge(Long age) => List<Member> 
	 * countByName(String name) => Integer
	 * deleteByOrderDateAtBefore(Date/LocalDate)
	 * 
	 * And/Or
	 * findByNameAndAge(String name, Integer age)
	 * findByNameOrAge(String name, Integer age)
	 * 
	 * Between/LessThan/GreaterThan/LessThanEqual/GreaterThanEqual
	 * findByOrderDateBetween(Date/LocalDate, Date/LocalDate)
	 * 
	 * Like/NotLike/StartingWith/EndingWith/Containing
	 * findByNameLike(String keyword)
	 * 
	 * IsNull/IsNotNull
	 * findByLastLoginIsNull(Date/LocalDate)
	 * 
	 * OrderBy + 屬性 + Asc/Desc
	 * findByNameLikeOrderByFirstNameAscAndLastNameDesc(String key)
	 * 
	 */

}
