<p align="center">
  <a href="https://t-j.ru/" target="_blank">
    <img src="media/logos/tj_logo.svg.png" width="500" alt="TJ Logo">
  </a>
</p>


# Проект по автоматизации тестирования сайта [Т-Ж](https://t-j.ru/)


## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Команды для запуска из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>

* <a href="#integrations">Интеграция с Allure TestOps</a>


____
<a id="tools"></a>
## <a name="Технологии и инструменты">**Технологии и инструменты:**</a>


<p align="center">  
<a href="https://www.jetbrains.com/idea/"><img src="media/logos/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="media/logos/Java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="media/logos/Github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="media/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="media/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>  
<a href="https://selenide.org/"><img src="media/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>  
<a href="https://aerokube.com/selenoid/"><img src="media/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://www.jenkins.io/"><img src="media/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="ht[images](images)tps://github.com/allure-framework/allure2"><img src="media/logos/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="media/logos/Allure2.svg" width="50" height="50"  alt="Allure TestOps"/></a>
</p>

- Автотесты написаны в <code>IntelliJ IDEA</code> на языке <code>Java</code> c помощью фреймворков <code>Selenide</code> и <code>JUnit 5</code>.
- При сборке проекта используется <code>Gradle</code>.
- При прогоне тестов браузер запускается в <code>Selenoid-контейнерах</code>.
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и автоматической отправкой результатов в <code>Telegram</code> (при помощи бота).
- Реализована интеграция с <code>Allure TestOps</code>.


____
<a id="cases"></a>
## <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:**</a>
____
✓ *Проверка новостной ленты на главной странице*  
✓ *Проверка появления модального окна входа в профиль*  
✓ *Проверка названия и количества основных вкладок навигации в хедере*  
✓ *Проверка появления окошка с уведомлениями*  
✓ *Проверка появления и размера меню с предлагаемыми запросами после нажатия на поиск*  
✓ *Проверка основных категорий на странице Потоки*  
✓ *Проверка количества категорий на странице Потоки*  
✓ *Проверка успешного поискового запроса*  
✓ *Проверка неуспешного поискового запроса*


____
<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="media/logos/Jenkins.svg" width="25"/></a><a name="Сборка"></a> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/C35-dmitry_endo-tinkoff_journal_ui/)</a>
____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/C35-dmitry_endo-tinkoff_journal_ui/"><img src="media/results/jenkins_job.png" alt="Jenkins" width="850"/></a>  
</p>


<a id="console"></a>
## Команды для запуска из терминала
___
***Локальный запуск:***
```bash  
gradle clean test -Denv=local
```

***Удалённый запуск через Jenkins:***
```bash  
gradle clean test 
-Denv=remote 
-Dbrowser=${BROWSER_NAME}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${SCREEN_RESOLUTION}
```


___
<a id="allure"></a>
## <img alt="Allure" height="25" src="media/logos/Allure.svg" width="25"/></a> <a name="Allure"></a> Allure [отчет](https://jenkins.autotests.cloud/job/C35-dmitry_endo-tinkoff_journal_ui/12/allure/)</a>
___

### *Основная страница отчёта*

<p align="center">  
<img title="Allure Overview Dashboard" src="media/results/allure_report_screenshot.png" width="950">  
</p>  

**Тест-кейсы** содержат в себе:
- Шаги
- Скриншот страницы на последнем шаге
- Page Source
- Логи консоли браузера
- Видео прогона автотестов

<p align="center">  
<img title="Allure Tests" src="media/results/allure_suites.png" width="950">  
</p>


____
<a id="telegram"></a>
## <img alt="Telegram" height="25" src="media/logos/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота
____
После завершения тестов: Telegram-бот отправляет уведомление с результатами и статистикой.
<p align="center">  
<img title="Telegram Notification" src="media/results/tg_notification.png" width="550">  
</p>


____
<a id="video"></a>
## <img alt="Selenoid" height="25" src="media/logos/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid
____

К каждому тесту в отчете прилагается видео его прохождения.
<p align="center">
<img title="Selenoid Video" src="media/results/test_run_video.gif" width="950"  alt="video">   
</p>

___
<a id="integrations"></a>
## <img alt="Allure TestOps" height="25" src="media/logos/Allure2.svg" width="25"/></a> <a name="Интеграция с Allure TestOps"></a>Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4877/dashboards)</a>
___

### *Основные страницы*

<p align="center">  
<a href="https://allure.autotests.cloud/project/4877/dashboards"><img title="Allure TestOps" src="media/results/allure_testops_dashboard.png" width="950"></a>  
</p>  

<p align="center">  
<img title="Allure Tests" src="media/results/allure_testops_cases.png" width="950">  
</p>

____