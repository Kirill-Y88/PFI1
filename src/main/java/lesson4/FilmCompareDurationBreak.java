package lesson4;

import java.util.Comparator;

public class FilmCompareDurationBreak implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        return o1.getDurationBreak() - o2.getDurationBreak();
    }
}
