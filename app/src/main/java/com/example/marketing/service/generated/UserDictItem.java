package com.example.marketing.service.generated;

import com.backstage.app.dict.domain.DictItem;
import com.backstage.app.dict.service.codegen.client.base.AbstractDictItem;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Generated(value = "com.backstage.app.dict.service.codegen.server.generator.DictItemModelGenerator", date = "2025-05-26T14:26:14.654504+03:00[Europe/Moscow]")
@Schema(description = "Пользователи")
public final class UserDictItem implements AbstractDictItem
{
	public static final String DICT_ID = "user";

	public static final Long DICT_VERSION = 4L;

	public static final String ID = "id";

	public static final String NAME = "name";

	public static final String STATUS = "status";

	public static final String CREATED = "created";

	public static final String UPDATED = "updated";

	public static final String HISTORY = "history";

	public static final String VERSION = "version";

	@Schema(description = "Идентификатор")
	private String id;

	@Schema(description = "Имя")
	@NotNull
	private String name;

	@NotNull
	private UserStatus status;

	@Schema(description = "Дата создания")
	@NotNull
	private LocalDateTime created;

	@Schema(description = "Дата обновления")
	@NotNull
	private LocalDateTime updated;

	@Schema(description = "История изменений")
	@NotNull
	private List<Map<String, Object>> history;

	@Schema(description = "Версия")
	@NotNull
	private Long version;

	@Builder
	public UserDictItem(String name, UserStatus status)
	{
		this.name = name;
		this.status = status;
	}

	public UserDictItem(DictItem dictItem)
	{
		this.id = dictItem.getId();
		this.name = (String) dictItem.getData().get(NAME);
		this.status = UserStatus.fromValue((String) dictItem.getData().get(STATUS));
		this.created = dictItem.getCreated();
		this.updated = dictItem.getUpdated();
		this.history = dictItem.getHistory();
		this.version = dictItem.getVersion();
	}

	@Override
	public Map<String, Object> toMap()
	{
		var dataMap = new HashMap<String, Object>();
		dataMap.put(NAME, getName());
		dataMap.put(STATUS, (getStatus() != null) ? getStatus().getValue() : null);
		return dataMap;
	}

	/**
	 * Статус пользователя
	 */
	@Getter
	@RequiredArgsConstructor
	public enum UserStatus
	{
		DISABLED("DISABLED"), ACTIVE("ACTIVE");

		private final String value;

		public static UserStatus fromValue(String value)
		{
			return Arrays.stream(UserStatus.values()).filter(it -> it.getValue().equals(value)).findFirst().orElse(null);
		}
	}
}
