package com.example.marketing.service;

import com.backstage.app.exception.AppException;
import com.backstage.app.model.other.exception.ApiStatusCodeImpl;
import com.example.marketing.service.generated.UserDictItem;
import com.example.marketing.service.generated.UserDictItemAbstractAdvice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDictItemAdvice extends UserDictItemAbstractAdvice
{
	@Override
	public void handleAfterCreate(UserDictItem item)
	{
		// Логика валидации элемента справочника.
		if (item.getName().matches(".*\\d"))
		{
			throw new AppException(ApiStatusCodeImpl.ILLEGAL_INPUT, "Имя не должно содержать цифры.");
		}
	}
}
