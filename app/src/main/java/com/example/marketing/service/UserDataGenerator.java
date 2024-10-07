package com.example.marketing.service;

import com.backstage.app.dict.service.DictDataService;
import com.backstage.app.dict.service.imp.ImportCsvService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Getter
@Service
public class UserDataGenerator extends DataGenerator
{
	private final String dictId = "user";

	@Value("classpath:/init/user.csv")
	private Resource resource;

	public UserDataGenerator(DictDataService dictDataService, ImportCsvService importCsvService)
	{
		super(dictDataService, importCsvService);
	}
}
