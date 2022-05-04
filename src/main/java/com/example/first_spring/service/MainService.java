package com.example.first_spring.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.first_spring.vo.UserVO;

@Service
public class MainService {
    //문제 1. 나이가 60 이하인 배우만 리턴하시오.
    public List<UserVO> getUserList(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        
        for(int i=0; i<list.size(); i++) {
        	int age = list.get(i).getAge();
			if(age >= 60) {
				list.remove(i);
//				--i;
				//해당 i번째 데이터가 지워지므로 --i를 통해 다시 검사.
			}
       }
        return list;
    }
    //문제 2. 나이가 가장많은 배우의 나이를 리턴하시오.
    public int getUserAgeMax(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        int max = list.get(0).getAge();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getAge() > max) {
				max = list.get(i).getAge();
			}
		}
		return max;
	}
    //문제 3. list에 배우이름 배성우가 있다면 리턴하시오.
    public UserVO getUser(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals("배성우")) {
				return list.get(i);
			}
		}
		return null;
	}
    //문제 4. list에 성이 이씨인 배우가 몇명인지 리턴하시오.
    public int getUserCount(){
		List<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO("이병헌",51,"서울"));
        list.add(new UserVO("조승우",42,"서울"));
        list.add(new UserVO("이경영",61,"서울"));
        list.add(new UserVO("배성우",49,"서울"));
        list.add(new UserVO("백윤식",75,"서울"));
        int count = 0;
        for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().contains("이")) {
				count++;
			}
		}
		return count;
	}

}
