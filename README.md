# Пример приложения "Аудит посещений супермаркетов"

## Назначение
Приложение предназначено для аудита торговых точек. Аудиторы периодически совершают осмотры магазинов по списку и фиксируют состояние различных зон внутри магазина на соответствие стандартам.
Результаты аудита сохраняются в реестре. Добавление результата проверки возможно через пользовательский интерфейс или через интеграционный API (в случае использования внешних специализированных приложений).

## Конфигурация
Структура справочников определяется [миграциями](app/src/main/resources/db/migration/dicts). На основании структуры автоматически генерируются [компоненты для работы со справочниками](app/src/main/java/com/example/marketing/service/generated) с поддержкой типового контроля и валидацией структуры данных.

Данные справочников импортируются из [CSV файлов](app/src/main/resources/init).

Набор справочников и полей, доступных пользователям, определяется [конфигурацией CMS](devops/localhost/docker/cms-settings.json).

Список [доступных пользователей](app/src/main/java/com/example/marketing/configuration/SecurityConfiguration.java):
- admin/admin
- operator/operator

Примеры реализованной бизнес-логики для справочников:
- При добавлении записи об аудите супермаркета [прикрепляем фото из магазина](app/src/main/java/com/example/marketing/service/ExaminationDictItemAdvice.java).
- При создании нового сотрудника [проверяем, что ФИО не содержит недопустимые символы](app/src/main/java/com/example/marketing/service/UserDictItemAdvice.java).

## Локальный запуск
### Запуск
1. Поднять тестовое окружение.
```sh
docker image rm -f git.backstage-platform.ru:5050/backstage/components/cms:stable
docker login git.backstage-platform.ru:5050 -u registry-viewer -p gldt-yyxxD9zddKaWD_QsbVLt
docker-compose -f ./devops/localhost/docker/docker-compose.yml -p backstage-marketing-app up
```

2. Запустить приложение.
```sh
./gradlew bootRun
```

Пользовательский интерфейс доступен по [ссылке](http://localhost/) (логин/пароль: admin/admin). Описание API доступно в [Swagger](http://localhost:8080/swagger-ui/index.html), метрики в [Actuator](http://localhost:8080/actuator).

3. Если в структуру справочников вносятся изменения, то необходимо повторно сгенерировать клиенты для dicts.
```sh
./gradlew app:dictsCodegen
```
После завершения задачи, в пакете com.example.marketing.service.generated появятся обновлённые модели и клиенты к API dicts.
Чтобы изменения отобразились в интерфейсе, перезапускаем приложение.

### Остановка
```sh
docker-compose -p backstage-marketing-app stop
```

## Скриншоты
![Список магазинов](docs/img1.png)
![Экспорт списка](docs/img5.png)
![Магазин на карте](docs/img2.png)
![Редактирование информации о магазине](docs/img3.png)
![Фильтрация](docs/img4.png)
