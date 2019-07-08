# Описание

Очень интересный летний проект.

## Настройка базы данных

Для проекта используется база данных Oracle Database 18.4.0-XE, запускаемая на локальной машине (*localhost*).
Для подключения используются:

* Port: **1521**
* Service Name: **XEPDB1**

Для входа в базу данных в файле *application.properties* используются переменные окружения.
Перед запуском проекта необходимо задать их командой:

```bash
export DB_USERNAME='changeme'
export DB_PASSWORD='changeme'
```

## Сборка и запуск проекта

### С помощью gradlew проекта

```bash
git clone https://github.com/zsxoff/summer
cd summer

export DB_USERNAME='changeme'
export DB_PASSWORD='changeme'

./gradlew bootRun
```

Для сборки с помощью установленного локально Gradle следует заменить '*./gradlew*' на '*gradle*'.

### С помощью Docker

Сборка контейнера с проектом осуществляется с помощью команды:

```bash
git clone https://github.com/zsxoff/summer
cd summer

docker build -t "summer-routine" .
```

Запуск осуществляется командой:

```bash
docker run -d \
--net=host \
-p 8080:8080 \
-e DB_USERNAME=${DB_USERNAME} \
-e DB_PASSWORD=${DB_PASSWORD} \
summer-routine bootRun
```

Вместо переменных окружения *${DB_USERNAME}* и *${DB_PASSWORD}* можно указывать конкретные логин и пароль в виде строк:

```bash
...
-e DB_USERNAME='username' \
-e DB_PASSWORD='password' \
...
```

***Внимание! Если вы вносите изменения в файлы проекта, необходимо пересобрать контейнер!***
