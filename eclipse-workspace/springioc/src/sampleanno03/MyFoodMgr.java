﻿package sampleanno03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myFood")  //default : myFoodMgr
//bean 태그를 대신한다.
public class MyFoodMgr{
	@Autowired
	//@Qualifier(value="unFavoriteFood")
	private Food favoriteFood;     // setter - Can be omitted
	//여기에 알아서 bean객체를 넣어달라는 애노테이션 구문
	@Autowired
	private Food unFavoriteFood;
	                 
	
	@Override
	public String toString() {
		return "[Food1=" + favoriteFood + ", Food2=" + unFavoriteFood + "]";
	}
}
