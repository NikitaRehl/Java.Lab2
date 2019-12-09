package rehlitskiy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Films {

    private ArrayList<Film> films;

    public Films(int count) {
        this.films = new ArrayList<>();
    }

    public void addFilm(Film film) { // добавление фильма в первую пустую ячейку. Если такой нету, массив увеличивается на 1 и обьект добавляется в конец
        films.add(film);
    }

    public void changeRatingBy(String increaseOrDecrease, double onHowMuch, int forNumberOfViews, String moreOrLess) { /* метод изменения рейтинга. Увеличить или уменьшить (increase/decrease),
     на сколько, для какого количества просмотров фильма, больше или меньше этого количества */
        if (increaseOrDecrease == "increase") {
            for (int i = 0; i < films.size(); i++) {
                if (moreOrLess == "more")
                    if (films.get(i).getNumberOfViews() > forNumberOfViews) {
                        double newRating = films.get(i).getRating() + onHowMuch;
                        films.get(i).setRating(newRating);
                    }
                if (moreOrLess == "less")
                    if (films.get(i).getNumberOfViews() < forNumberOfViews) {
                        double newRating = films.get(i).getRating() + onHowMuch;
                        films.get(i).setRating(newRating);
                    }
            }
        }
        if (increaseOrDecrease == "decrease") {
            for (int i = 0; i < films.size(); i++) {
                if (moreOrLess == "more")
                    if (films.get(i).getNumberOfViews() > forNumberOfViews) {
                        double newRating = films.get(i).getRating() - onHowMuch;
                        films.get(i).setRating(newRating);
                    }
                if (moreOrLess == "less")
                    if (films.get(i).getNumberOfViews() < forNumberOfViews) {
                        double newRating = films.get(i).getRating() - onHowMuch;
                        films.get(i).setRating(newRating);
                    }
            }
        } else System.out.println("Ошибка изменения рейтинга");

    }

    public void getLastForThreeYearsFilms() { // метод для вывода фильмов вышедших за последних 3 года
        boolean isExist = false;
        Calendar calendar = new GregorianCalendar();
        for (int i = 0; i < films.size(); i++) // проверка на существование таких фильмов
            if (films.get(i).getReleaseYear() <= calendar.get(Calendar.YEAR) && films.get(i).getReleaseYear() >= (calendar.get(Calendar.YEAR) - 3)) {
                isExist = true;
                break;
            }
        if (isExist) {
            System.out.print("Фильмы вышедшие за последние 3 года: ");
            boolean expression;
            for (int i = 0; i < films.size(); i++) {
                expression = films.get(i).getReleaseYear() <= calendar.get(Calendar.YEAR) && films.get(i).getReleaseYear() >= (calendar.get(Calendar.YEAR) - 3);
                if (expression)
                    System.out.print(films.get(i).getName());
                if (i != (films.size() - 1) && expression)
                    System.out.print(" | ");
            }
            System.out.println();
        } else System.out.println("За последних 3 года фильмы не выходили");
    }

    public void getAllFilmsWithProtagonist(String protagonist) { //вывод всех фильмов с указанным актером
        boolean isExist = false;
        for (int i = 0; i < films.size(); i++)
            if (films.get(i).getProtagonist() == protagonist) {
                isExist = true;
                break;
            }
        if (isExist) {
            System.out.print("Фильмы в которых снялся '" + protagonist + "': ");
            for (int i = 0; i < films.size(); i++) {
                if (films.get(i).getProtagonist() == protagonist)
                    System.out.print(films.get(i).getName());
                if (i != (films.size()) && films.get(i).getProtagonist() == protagonist)
                    System.out.print(" | ");
            }
            System.out.println();
        } else System.out.println("Такой актер не найден");
    }

    public void getDirectorByFilmName(String name) { // вывод режисера по названию фильма
        boolean isExist = false;
        for (int i = 0; i < films.size(); i++)
            if (films.get(i).getName() == name) {
                isExist = true;
                break;
            }
        if (isExist) {
            System.out.print("Режисер, который снял фильм '" + name + "': ");
            for (int i = 0; i < films.size(); i++) {
                if (films.get(i).getName() == name) {
                    System.out.print(films.get(i).getDirector());
                }
            }
            System.out.println();
        } else System.out.println("Такой фильм не найден");
    }

    public void showInfo() { // вывод информации обо всех фильмах
        try {
            for (int i = 0; i < films.size(); i++) {
                films.get(i).showInfo();
            }
            System.out.println("--------------------------------------------------");
        } catch (Exception e) {

        }
    }
}