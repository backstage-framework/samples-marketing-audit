package com.example.marketing.service;

import com.example.marketing.service.generated.UserDictItem;
import com.example.marketing.service.generated.UserDictItemAbstractAdvice;
import org.springframework.stereotype.Service;

@Service
public class UserDictItemAdvice extends UserDictItemAbstractAdvice
{
	@Override
	public void handleAfterCreate(UserDictItem item)
	{
		// Логика валидации элемента справочника.
	}
}
