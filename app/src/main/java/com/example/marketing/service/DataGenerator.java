package com.example.marketing.service;

import com.backstage.app.dict.service.DictDataService;
import com.backstage.app.dict.service.imp.ImportCsvService;
import com.backstage.app.exception.AppException;
import com.backstage.app.model.other.exception.ApiStatusCodeImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public abstract class DataGenerator
{
	private final DictDataService dictDataService;
	private final ImportCsvService importCsvService;

	abstract String getDictId();

	abstract Resource getResource();

	public void load()
	{
		log.info("Загрузка данных в справочник '{}' из файла '{}'.", getDictId(), getResource());

		var count = dictDataService.countByFilter(getDictId(), "");

		if (count != 0)
		{
			log.info("Загрузка данных в справочник '{}' отменена - справочник не пуст.", getDictId());

			return;
		}

		try (var fileInputStream = getResource().getInputStream())
		{
			importCsvService.importDict(getDictId(), fileInputStream);
		}
		catch (IOException e)
		{
			throw new AppException(ApiStatusCodeImpl.UNKNOWN_ERROR, e);
		}

		log.info("Загрузка данных в справочник '{}' завершена.", getDictId());
	}
}
