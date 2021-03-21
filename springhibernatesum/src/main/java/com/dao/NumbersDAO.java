package com.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.entities.Numbers;

@Component
public class NumbersDAO {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int save(Numbers sum) {
		Integer i=(Integer) this.hibernateTemplate.save(sum);
		return i;		
	}

}
