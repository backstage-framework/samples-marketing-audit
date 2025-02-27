package com.example.marketing.service;

import com.backstage.app.attachment.service.AttachmentService;
import com.backstage.app.model.other.user.UserInfo;
import com.example.marketing.service.generated.ExaminationDictItem;
import com.example.marketing.service.generated.ExaminationDictItemAbstractAdvice;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ExaminationDictItemAdvice extends ExaminationDictItemAbstractAdvice
{
	private final AttachmentService attachmentService;

	@Value("classpath:/init/photos/fry.jpg")
	private Resource firstPhotoResource;

	@Value("classpath:/init/photos/bender.jpg")
	private Resource secondPhotoResource;

	private final List<String> photoIds = new ArrayList<>();

	private final Random random = new Random();

	@PostConstruct
	public void init() throws Exception
	{
		try (
				var firstPhotoStream = firstPhotoResource.getInputStream();
				var secondPhotoStream = secondPhotoResource.getInputStream()
		)
		{
			photoIds.add(attachmentService.addAttachment(Objects.requireNonNull(firstPhotoResource.getFilename()),
					MediaType.IMAGE_JPEG_VALUE,
					UserInfo.SYSTEM_USER_ID,
					firstPhotoStream).getId());

			photoIds.add(attachmentService.addAttachment(Objects.requireNonNull(secondPhotoResource.getFilename()),
					MediaType.IMAGE_JPEG_VALUE,
					UserInfo.SYSTEM_USER_ID,
					secondPhotoStream).getId());
		}
	}

	@Override
	public void handleBeforeCreate(ExaminationDictItem item)
	{
		var photoCount = random.nextInt(3);

		if (photoCount > 0)
		{
			item.getPhotos().addAll(photoIds.subList(0, photoCount));
		}
	}
}
