package com.example.marketing.service;

import com.backstage.app.dict.service.DictDataService;
import com.backstage.app.dict.service.imp.ImportCsvService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Getter
@Service
public class ExaminationDataGenerator extends DataGenerator
{
	private final String dictId = "examination";

	@Value("classpath:/init/examination.csv")
	private Resource resource;

	public ExaminationDataGenerator(DictDataService dictDataService, ImportCsvService importCsvService)
	{
		super(dictDataService, importCsvService);
	}
}
