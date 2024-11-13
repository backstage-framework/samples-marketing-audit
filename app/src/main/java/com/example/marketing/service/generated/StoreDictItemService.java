package com.example.marketing.service.generated;

import com.backstage.app.dict.domain.DictItem;
import com.backstage.app.dict.service.DictDataService;
import com.backstage.app.dict.service.codegen.base.AbstractDictItemService;
import jakarta.annotation.Generated;
import org.springframework.stereotype.Service;

@Generated(value = "com.backstage.app.dict.service.codegen.generator.DictItemServiceGenerator", date = "2024-11-13T13:06:25.499579+03:00[Europe/Moscow]")
@Service
public class StoreDictItemService extends AbstractDictItemService<StoreDictItem>
{
	public StoreDictItemService(DictDataService dictDataService)
	{
		super(dictDataService);
	}

	@Override
	protected String getDictId()
	{
		return StoreDictItem.DICT_ID;
	}

	@Override
	protected StoreDictItem buildItem(DictItem dictItem)
	{
		return new StoreDictItem(dictItem);
	}
}
