Meta:

Scenario: Тест яндекса 2

Given перейти на https://yandex.ru/
When перейти в яндекс маркет
When Выбрать раздел Электроника
When Выбрать подраздел Наушники и Bluetooth-гарнитуры
When задать минимальную стоимость 5000
When выбрать компании: Beats
When нажать кнопку применить
Then проверить количество элементов:12
When запомнить 1 элемент в списке
When ввести в поисковую строку запомненное значение и найти
Then проверить наименование товара