package rehlitskiy;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Film {

    private String name, director, protagonist;
    private int releaseYear, numberOfViews;
    private double rating;

    public Film(String name, String director, String protagonist, int releaseYear, double rating, int numberOfViews) {
        this.name = name;
        this.director = director;
        this.protagonist = protagonist;
        setReleaseYear(releaseYear); // установка значений через метод для проверки правильности ввода данных
        setRating(rating);
        setNumberOfViews(numberOfViews);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProtagonist() {
        return protagonist;
    }

    public void setProtagonist(String protagonist) {
        this.protagonist = protagonist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        Calendar calendar = new GregorianCalendar();
        if (releaseYear >= 1985 && releaseYear <= calendar.get(Calendar.YEAR)) // проверка на правильность данных (все то же и далее)
            this.releaseYear = releaseYear;
        else {
            this.releaseYear = 0;
            System.out.println(getName() + ". Не верно введен год выхода");
        }
    }

    public int getNumberOfViews() {
        return numberOfViews;
    }

    public void setNumberOfViews(int numberOfViews) {
        if (numberOfViews >= 0)
            this.numberOfViews = numberOfViews;
        else {
            this.numberOfViews = 0;
            System.out.println(getName() + ". Не верно введено количество просмотров");
        }
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating >= 0.0 && rating <= 10.0)
            this.rating = (Math.round(rating * 100.00))/100.00;
        else {
            this.rating = 0.0;
            System.out.println(getName() + ". Не верно введен рейтинг");
        }
    }

    public void showInfo() {
        System.out.println("--------------------------------------------------"
                + "\nНазвание фильма: " + this.name
                + "\nРежисер: " + this.director
                + "\nВ главных ролях: " + this.protagonist
                + "\nГод выхода: " + this.releaseYear
                + "\nРейтинг: " + this.rating
                + "\nКоличество просмотров: " + this.numberOfViews);
    }
}

