# test-project

Система для публикации цитат и голования (like или dislike)

# Ограничения к решению

- Код не адаптирован к bigdata запросам
- код протестирован руками, но не покрыт unit тестами
- не будет swagger спецификации

# Перед использованием

- установить docker 
- установить docker-compose

# Как пользоваться

- Собрать Jar c помощью gradle
```./gradlew bootJar```

- собрать образ
```docker build -t test-project-image ./```

- запустить приложение
```docker run -p 8080:8080 --rm test-project-image```

После запуска может вызывать rest ендпоинты по адресу: http://localhost:8080

Пример вызова: http://localhost:8080/api/quotes/random

- остановить приложение
```docker container ls```
```docker stop container_id```

# Запуск через docker-compose 
Для этого должен быть загружен файл (docker-compose.yml)
И из директории с этим файлом можено выполнить следующие команды:

Команда запуска образа приложения
```docker-compose up```

Команда остановки образа приложения
```docker-compose down```
или командой выхода из консоли (например в ubuntu CTRL+C)



