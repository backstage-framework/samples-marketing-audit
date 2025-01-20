package com.example.marketing.service.generated;

import com.backstage.app.dict.domain.DictItem;
import com.backstage.app.dict.service.DictDataService;
import com.backstage.app.dict.service.codegen.server.base.AbstractDictItemService;
import jakarta.annotation.Generated;
import org.springframework.stereotype.Service;

@Generated(value = "com.backstage.app.dict.service.codegen.server.generator.DictItemServiceGenerator", date = "2025-01-16T19:19:15.601093+03:00[Europe/Moscow]")
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
	protected Long getDictVersion()
	{
		return UserDictItem.DICT_VERSION;
	}

	@Override
	protected UserDictItem buildItem(DictItem dictItem)
	{
		return new UserDictItem(dictItem);
	}
}
