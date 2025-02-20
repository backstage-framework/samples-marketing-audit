package com.example.marketing.service.generated;

import com.backstage.app.dict.domain.DictItem;
import com.backstage.app.dict.service.DictDataService;
import com.backstage.app.dict.service.codegen.server.base.AbstractDictItemService;
import jakarta.annotation.Generated;
import org.springframework.stereotype.Service;

@Generated(value = "com.backstage.app.dict.service.codegen.server.generator.DictItemServiceGenerator", date = "2025-02-20T12:07:50.041374+03:00[Europe/Moscow]")
@Service
public class MarketingZoneDictItemService extends AbstractDictItemService<MarketingZoneDictItem>
{
	public MarketingZoneDictItemService(DictDataService dictDataService)
	{
		super(dictDataService);
	}

	@Override
	protected String getDictId()
	{
		return MarketingZoneDictItem.DICT_ID;
	}

	@Override
	protected Long getDictVersion()
	{
		return MarketingZoneDictItem.DICT_VERSION;
	}

	@Override
	protected MarketingZoneDictItem buildItem(DictItem dictItem)
	{
		return new MarketingZoneDictItem(dictItem);
	}
}
