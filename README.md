# Пример приложения "Аудит посещений супермаркетов"

## Конфигурация
Структура справочников определяется [миграциями](app/src/main/resources/db/migration/dicts).

Данные справочников импортируются из [CSV файлов](app/src/main/resources/init).

Набор справочников и полей, доступных пользователям, определяется [конфигурацией CMS](devops/localhost/docker/cms-settings.json).

Список [доступных пользователей](app/src/main/java/com/example/marketing/configuration/SecurityConfiguration.java):
- admin/admin
- operator/operator

Примеры реализованной бизнес-логики над созданными справочниками:
- При добавлении записи об аудите супермаркета, [добавляем изображения проверки](app/src/main/java/com/example/marketing/service/ExaminationDictItemAdvice.java).
- При создании нового сотрудника, [проверяем что ФИО не содержит недопустимые символы](app/src/main/java/com/example/marketing/service/UserDictItemAdvice.java).

## Локальная отладка
### Запуск
1. Поднять тестовое окружение.
```sh
docker image rm -f git.backstage-platform.ru:5050/backstage/components/dicts-ui-library
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
![Добавление новой записи](docs/img2.png)
![Фильтрация](docs/img3.png)
