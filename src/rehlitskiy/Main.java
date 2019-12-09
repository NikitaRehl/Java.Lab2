package rehlitskiy;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Film film = new Film("Аватар", "Камерон", "Сэм Уортингтон", 2009, 8.9, 201245);
        Film film1 = new Film("Война токов", "Альфонсо", "Бенедикт Камбербэтч", 2019, 7.9, 212341);
        Film film2 = new Film("К Звездам", "Грей", "Брэд Питт", 2019, 5.4, 141212);
        Film film3 = new Film("Звездные Войны: Пробуждение Силы", "Джефри Джейкоб Абрамс", "Адам Драйвер", 2015, 8.0, 321642);
        Film film4 = new Film("Матрица", "Братья Вачовски", "Киану Ривз", 1999, 8.1, 7437353);

        Films films = new Films(4);

        films.addFilm(film);
        films.addFilm(film1);
        films.addFilm(film2);
        films.addFilm(film3);
        films.addFilm(film4);

        films.showInfo();

        films.changeRatingBy("decrease", 3.2, 10000, "more");

        films.showInfo();

        films.getLastForThreeYearsFilms();

        films.getAllFilmsWithProtagonist("Брэд Питт");

        films.getDirectorByFilmName("Аватар");

        SaveRead saveRead = new SaveRead();
        saveRead.saveJson(films, "Films");
        Films films1 = saveRead.readJson("Films");
        films1.showInfo();
    }
}
