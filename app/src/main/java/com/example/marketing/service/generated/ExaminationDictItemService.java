package com.example.marketing.service.generated;

import com.backstage.app.dict.domain.DictItem;
import com.backstage.app.dict.service.DictDataService;
import com.backstage.app.dict.service.codegen.server.base.AbstractDictItemService;
import jakarta.annotation.Generated;
import org.springframework.stereotype.Service;

@Generated(value = "com.backstage.app.dict.service.codegen.server.generator.DictItemServiceGenerator", date = "2025-01-29T12:03:57.807843+03:00[Europe/Moscow]")
@Service
public class ExaminationDictItemService extends AbstractDictItemService<ExaminationDictItem>
{
	public ExaminationDictItemService(DictDataService dictDataService)
	{
		super(dictDataService);
	}

	@Override
	protected String getDictId()
	{
		return ExaminationDictItem.DICT_ID;
	}

	@Override
	protected Long getDictVersion()
	{
		return ExaminationDictItem.DICT_VERSION;
	}

	@Override
	protected ExaminationDictItem buildItem(DictItem dictItem)
	{
		return new ExaminationDictItem(dictItem);
	}
}
