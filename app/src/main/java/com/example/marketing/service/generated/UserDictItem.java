package com.example.marketing.service.generated;

import com.backstage.app.dict.domain.DictItem;
import com.backstage.app.dict.service.codegen.base.AbstractDictItem;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Generated(value = "com.backstage.app.dict.service.codegen.generator.DictItemModelGenerator", date = "2024-11-13T15:42:17.710948+03:00[Europe/Moscow]")
@Schema(description = "Пользователи")
public final class UserDictItem implements AbstractDictItem
{
	public static final String DICT_ID = "user";

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String CREATED = "created";

	public static final String UPDATED = "updated";

	public static final String DELETED = "deleted";

	public static final String DELETION_REASON = "deletionReason";

	public static final String HISTORY = "history";

	public static final String VERSION = "version";

	@Schema(description = "Идентификатор")
	private String id;

	@Schema(description = "Имя")
	@NotNull
	private String name;

	@Schema(description = "Дата создания")
	@NotNull
	private LocalDateTime created;

	@Schema(description = "Дата обновления")
	@NotNull
	private LocalDateTime updated;

	@Schema(description = "Дата удаления")
	private LocalDateTime deleted;

	@Schema(description = "Причина удаления")
	private String deletionReason;

	@Schema(description = "История изменений")
	@NotNull
	private List<Map<String, Object>> history;

	@Schema(description = "Версия")
	@NotNull
	private Long version;

	public UserDictItem(DictItem dictItem)
	{
		this.id = dictItem.getId();
		this.name = (String) dictItem.getData().get(NAME);
		this.created = dictItem.getCreated();
		this.updated = dictItem.getUpdated();
		this.deleted = dictItem.getDeleted();
		this.deletionReason = dictItem.getDeletionReason();
		this.history = dictItem.getHistory();
		this.version = dictItem.getVersion();
	}

	@Override
	public Map<String, Object> toMap()
	{
		var dataMap = new HashMap<String, Object>();
		dataMap.put(NAME, getName());
		return dataMap;
	}
}
