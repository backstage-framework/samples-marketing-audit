package com.example.marketing.service.generated;

import com.backstage.app.dict.domain.DictItem;
import com.backstage.app.dict.service.DictDataService;
import com.backstage.app.dict.service.codegen.base.AbstractDictItemService;
import jakarta.annotation.Generated;
import org.springframework.stereotype.Service;

@Generated(value = "com.backstage.app.dict.service.codegen.generator.DictItemServiceGenerator", date = "2024-10-19T09:56:12.810501+03:00[Europe/Moscow]")
@Service
public class UserDictItemService extends AbstractDictItemService<UserDictItem>
{
	public UserDictItemService(DictDataService dictDataService)
	{
		super(dictDataService);
	}

	@Override
	protected String getDictId()
	{
		return UserDictItem.DICT_ID;
	}

	@Override
	protected UserDictItem buildItem(DictItem dictItem)
	{
		return new UserDictItem(dictItem);
	}
}
