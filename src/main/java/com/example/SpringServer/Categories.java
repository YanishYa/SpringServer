package com.example.SpringServer;

import java.util.LinkedList;
import java.util.List;

public class Categories {
    List<String> categories = new LinkedList<>();
    public Categories(){
        categories.add("Бильярдный клуб"); //0
        categories.add("Выставка или галерея"); //1
        categories.add("Гостиница"); //2
        categories.add("Караоке-клуб"); //3
        categories.add("Кинотеатр"); //4
        categories.add("Концертный зал"); //5
        categories.add("Культурный центр"); //6
        categories.add("Дом культуры"); //7
        categories.add("Ночной клуб"); //8
        categories.add("Пляж"); //9
        categories.add("Развлекательный центр"); //10
        categories.add("Ансамбль или фольклерный коллектив"); //11
        categories.add("Театр"); //12
        categories.add("Торговый центр или магазин"); //13
        categories.add("Ресторан быстрого питания"); //14
        categories.add("Доставка еды"); //15
        categories.add("Кафе"); //16
        categories.add("Пиццерия"); //17
        categories.add("Ресторан"); //18
        categories.add("Столовая"); //19
        categories.add("Суши бар"); //20
        categories.add("Пункт аренды велосипедов"); //21
        categories.add("Спортивно-развлекательный центр"); //22
        categories.add("Спортивный клуб"); //23
        categories.add("Спорткомплекс"); //24
        categories.add("Стадион"); //25
        categories.add("Парикмахерская"); //26
        categories.add("Салон красоты"); //27
        categories.add("Массажный салон"); //28
        categories.add("Маникюр и ногтевой дизайн"); //29
        categories.add("Сауна или баня"); //30
        categories.add("Солярий"); //31
        categories.add("Спа-салон"); //32
        categories.add("Фитнес-клуб или тренажерный зал"); //33
        categories.add("Центр йоги"); //34
        categories.add("Квест в реальности"); //35
        categories.add("VR-клуб"); //36
        categories.add("Лазертаг"); //37
        categories.add("Пейнтбольный клуб"); //38
        categories.add("Страйкбол-клуб"); //39
        categories.add("Туристический клуб"); //40
        categories.add("Экскурсия или тур"); //41
        categories.add("Антикафе"); //42
        categories.add("Банкетный зал"); //43
        categories.add("Бар или паб"); //44
        categories.add("Интернет-кафе"); //45
        categories.add("Кальян-бар"); //46

    }
    public List<String> getCategories(){
        return categories;
    }

}
