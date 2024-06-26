## План тестирования мобильного приложения «Мобильный хоспис»

### Описание функций приложения

Приложение даёт функционал по работе с новостями хосписа и включает в себя:

- информацию о новостях и функционал для работы с ними;
- тематические цитаты;
- информацию о приложении.

### Цели тестирования
- Проведение функционального и нефункционального тестирования.

### Этапы тестирования:
- исследование приложения;
- составление чек-листа;
- составление тест-кейсов;
- автоматизирование тест-кейсов;
- составление отчета о проведенном тестировании.

### Тестовые данные
Данные для авторизации:
- login2;
- password2.

### Описание объекта тестирования:
#### Страница авторизации
 - поле login
 - поле password
 - кнопка "Sign in"
#### Главная страница ("Main")
- панель управления
	- открытие меню и переход на страницы "News"/ "About"
	- переход на страницу "Love is all"
	- переход в меню профиля
 - раздел "News"
	  - сворачивание/ разворачивание блока новостей
	  - переход на страницу "News"
	  - сворачивание/ разворачивание каждой отдельной новости
#### Страница "News"
- панель управления
	- открытие меню и переход на страницы "Main"/ "About"
	- переход на страницу "Love is all"
	- переход в меню профиля
- раздел "News"	
	- сортировка новостей
	- фильтрация новостей (по категории и/или по заданному периоду)
	- переход на страницу "Control panel"
  	- сворачивание/ разворачивание каждой отдельной новости
#### Страница "Control panel"
- панель управления
	- открытие меню и переход на страницы "Main"/ "News" / "About"
	- переход на страницу "Love is all"
	- переход в меню профиля
- раздел "Control panel"
	- сортировка новостей
	- фильтрация новостей (по категории и/или по заданному периоду/ статусу)
	- добавление новости
	- сворачивание/ разворачивание каждой отдельной новости
	- удаление каждой отдельной новости
	- редактирование каждой отдельной новости
#### Страница "Love is all"
- панель управления
	- открытие меню и переход на страницы "Main"/ "About"
	- переход на страницу "Love is all"
	- переход в меню профиля
- раздел "Love is all"	
  	- сворачивание/ разворачивание каждой отдельной цитаты
#### Страница "About"
- панель управления
	- переход на предыдущую страницу
- раздел "About"	
  - Переход по ссылке "Privacy Policy"
  - Переход по ссылке "Terms of use"

### Виды тестирования
- ручное тестирование (применено);
- автоматизированное тестирование (не применено);
- функциональное тестирование (применено);
- GUI-тестирование (применено);
- UX-тестирование (применено);
- тестирование безопасности (применено);
- нагрузочное тестирование (не применено).

### План по автоматизации тестирования
Список сценариев которые планируется автоматизировать:
- Сценарии авторизации
- Сценарии работы главной страницы 		
- Сценарии работы страницы News	
- Сценарии работы станицы Control panel	
- Сценарии работы страницы Love is all
- Сценарии работы страницы About						


### Перечень используемых инструментов с обоснованием выбора
- Android Studio — это интегрированная среда разработки (integrated development environment) от Google для создания Android-приложений. В ней можно писать код, проектировать графический интерфейс, проводить отладку и сборку приложений для публикации в магазинах.
- Эмулятор Android API 29 - эмулятор наиболее распространенных устройств.
- Github - крупнейший веб-сервис для хостинга IT-проектов и их совместной разработки. Позволит хранить репозитории с кодом автотестов, отслеживать изменения в коде проекта, синхронизировать код между разными участниками команды.
- Allure - инструмент, позволяющий внести прозрачность в процесс создания и выполнения функциональных тестов.
- Espresso - фреймворк для тестирования приложений на Android.
- Appium - это инструмент с открытым исходным кодом для автоматизации тестирования нативных, веб и гибридных мобильных приложений (iOS, Android), а также десктопных приложений.
- Charles - прокси-сервер, который позволяет записывать HTTP - и HTTPS-трафик подключенных устройств.

### Перечень необходимых разрешений, данных и доступов
- разрешение на автоматизированное тестирование от владельца приложения;
- требования к приложению (не предоставлено);
- доступ к базе данных (не предоставлено).

### Перечень и описание возможных рисков при автоматизации
- отсутствие достаточного опыта у тестировщика;
- короткие сроки по дедлайну;
- работа тестировщика над другими проектами;
- отсутствие требований к приложению;
- сбой работы инфраструктуры;
- отсутствие доступа к базе данных;
- не полное покрытие тестами;
- не полное автоматизирование тест-кейсов;
- изменение верстки/функциональности приложения в процессе реализации проекта по тестированию;
- окупаемость проекта при реализации автоматизированного тестирования (долго и дорого).

### Перечень необходимых специалистов для тестирования и автоматизации тестирования
- инженер по ручному и автоматизированному тестированию

### Окружение
- Операционная система: Windows 11
- Android Studio: Runtime version: 17.0.7+0-b2043.56-10550314 amd64

### Документация:
- [Чек-лист](Check.xlsx)
- [Тест-кейсы](Cases.xlsx)

### Интервальная оценка с учётом рисков в часах
- Проведение ручного тестирования и составление плана - 4 часа
- Составление чек-листа - 6 часов
- Подготовка тест-кейсов - 16 часов
- Создание автотестов - 112 часов
- Проведение автотестирования - 
- Формирование отчетов - 

### План сдачи работ
- Время составления плана тестирования, чек-листа, тест-кейсов - 20 часов
- Время подготовки автотестирования - 80 часов
- Время проведения автотестирования - 30 минут
- Время формирования отчета о тестировании - 10 минут
